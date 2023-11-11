package com.sevilay.QuizApp.service;

import com.sevilay.QuizApp.dto.request.AnswerSaveRequestDto;
import com.sevilay.QuizApp.dto.response.AnswerResponseDto;
import com.sevilay.QuizApp.mapper.AnswerMapper;
import com.sevilay.QuizApp.repository.AnswerRepository;
import com.sevilay.QuizApp.repository.QuestionRepository;
import com.sevilay.QuizApp.repository.entity.Answer;
import com.sevilay.QuizApp.repository.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    public AnswerResponseDto saveAnswer(AnswerSaveRequestDto dto) {
        Answer answer = AnswerMapper.INSTANCE.fromSaveRequestToAnswer(dto);
        answer = answerRepository.save(answer);
        return AnswerMapper.INSTANCE.fromAnswerToResponse(answer);
    }


    public Question saveAllAnswers(List<AnswerSaveRequestDto> dtoList, Question question) {
        List<Answer> answerList = new ArrayList<>();
        List<Answer> updatedAnswerList = new ArrayList<>();
        answerList = AnswerMapper.INSTANCE.fromSaveRequestToAnswers(dtoList);

        for (int i = 0; i < answerList.size(); i++) {
            Answer answer = answerList.get(i);
            answer.setQuestionId(question.getId());
            answer.setAnswerNo(i + 1);
            updatedAnswerList.add(answer);
        }
        answerRepository.saveAll(updatedAnswerList);
        List<Long> answerIds = updatedAnswerList.stream().map(q -> q.getId()).collect(Collectors.toList());
        question.setAnswerIds(answerIds);
        return question;
    }

    public List<AnswerResponseDto> findAllByQuestionId(Long id) {
        List<Answer> answerList = answerRepository.findAllByQuestionId(id);
        return AnswerMapper.INSTANCE.fromAnswersToResponses(answerList);
    }
}
