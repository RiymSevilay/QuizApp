package com.sevilay.QuizApp.controller;

import com.sevilay.QuizApp.dto.request.QuestionSaveRequestDto;
import com.sevilay.QuizApp.dto.response.QuestionResponseDto;
import com.sevilay.QuizApp.repository.entity.Question;
import com.sevilay.QuizApp.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sevilay.QuizApp.constants.RestApi.*;

@RestController
@RequestMapping(QUESTION)
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping(SAVE)
    public ResponseEntity<Question> saveQuestion(@RequestBody @Valid QuestionSaveRequestDto dto) {
        return ResponseEntity.ok(questionService.saveQuestion(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Question>> findAll() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping(FINDBYIDWITHANSWERDATA)
    public ResponseEntity<QuestionResponseDto> findByIdWithAnswerData(Long id) {
        return ResponseEntity.ok(questionService.findByIdWithAnswerData(id));
    }

    @GetMapping(FINDALLWITHANSWERDATA)
    public ResponseEntity<List<QuestionResponseDto>> findAllAnswerData() {
        return ResponseEntity.ok(questionService.findAllAnswerData());
    }

}
