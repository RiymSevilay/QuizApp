package com.sevilay.QuizApp.service;

import com.sevilay.QuizApp.dto.request.AnswerSaveRequestDto;
import com.sevilay.QuizApp.dto.request.QuestionSaveRequestDto;
import com.sevilay.QuizApp.dto.response.AnswerResponseDto;
import com.sevilay.QuizApp.dto.response.QuestionResponseDto;
import com.sevilay.QuizApp.exception.ErrorType;
import com.sevilay.QuizApp.exception.QuizAppException;
import com.sevilay.QuizApp.mapper.QuestionMapper;
import com.sevilay.QuizApp.repository.QuestionRepository;
import com.sevilay.QuizApp.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerService answerService;

    public Question saveQuestion(QuestionSaveRequestDto dto) {
        Question question = null;
        List<AnswerSaveRequestDto> answerList = dto.getAnswerSaveRequestDtoList();
        if (answerList.size() >= 2) {
            question = questionRepository.save(QuestionMapper.INSTANCE.fromSaveRequestToQuestion(dto));
            question = answerService.saveAllAnswers(dto.getAnswerSaveRequestDtoList(), question);
            return questionRepository.save(question);
        } else {
            throw new QuizAppException(ErrorType.AT_LEAST_TWO_OPTION);
        }

    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public QuestionResponseDto findByIdWithAnswerData(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);

        if (questionOptional.isPresent()) {
            List<AnswerResponseDto> answerResponseDtoList = answerService.findAllByQuestionId(questionOptional.get().getId());
            QuestionResponseDto questionResponseDto = QuestionResponseDto.builder()
                    .questionText(questionOptional.get().getQuestionText())
                    .answerResponseDtoList(answerResponseDtoList)
                    .build();
            return questionResponseDto;
        } else {
            throw new QuizAppException(ErrorType.QUESTION_NOT_FOUND);
        }
    }

    public List<QuestionResponseDto> findAllAnswerData() {
        List<Question> questionList = questionRepository.findAll();
        List<QuestionResponseDto> questionResponseDtoList = new ArrayList<>();
        if (questionList.size() > 0) {
            for (Question question : questionList) {
                List<AnswerResponseDto> answerResponseDtoList = answerService.findAllByQuestionId(question.getId());
                QuestionResponseDto questionResponseDto = QuestionResponseDto.builder()
                        .questionText(question.getQuestionText())
                        .answerResponseDtoList(answerResponseDtoList)
                        .build();
                questionResponseDtoList.add(questionResponseDto);
            }
            return questionResponseDtoList;
        } else {
            throw new QuizAppException(ErrorType.QUESTION_NOT_FOUND);
        }
    }


}
