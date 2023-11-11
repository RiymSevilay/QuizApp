package com.sevilay.QuizApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDto {

    private Long questionId;

    private Integer answerNo;

    private String answerText;

    @Builder.Default
    private Boolean isCorrect = false;

}
