package com.sevilay.QuizApp.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSaveRequestDto {

    @Column(length =2048, nullable = false)
    private String answerText;

    @Builder.Default
    private Boolean isCorrect = false;

}
