package com.sevilay.QuizApp.controller;

import com.sevilay.QuizApp.dto.request.AnswerSaveRequestDto;
import com.sevilay.QuizApp.dto.response.AnswerResponseDto;
import com.sevilay.QuizApp.repository.QuestionRepository;
import com.sevilay.QuizApp.repository.entity.Answer;
import com.sevilay.QuizApp.repository.entity.Question;
import com.sevilay.QuizApp.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sevilay.QuizApp.constants.RestApi.*;

@RestController
@RequestMapping(ANSWER)
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
//    private final QuestionRepository questionRepository;
//
//    @PostMapping(SAVE)
//    public ResponseEntity<AnswerResponseDto> saveAnswer(@RequestBody @Valid AnswerSaveRequestDto dto) {
//        return ResponseEntity.ok(answerService.saveAnswer(dto));
//    }
//
//    @PostMapping(SAVEALL)
//    public ResponseEntity<List<AnswerResponseDto>> saveAllAnswers(@RequestBody @Valid List<AnswerSaveRequestDto> dtoList) {
//
//        Question question = new Question();
//        question = questionRepository.save(question);
//        return ResponseEntity.ok(answerService.saveAllAnswers(dtoList, question));
//    }

}
