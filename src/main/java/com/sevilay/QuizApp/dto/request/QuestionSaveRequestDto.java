package com.sevilay.QuizApp.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSaveRequestDto {

    @Column(length = 2048)
    private String questionText;

    private List<AnswerSaveRequestDto> answerSaveRequestDtoList;

}
