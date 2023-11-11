package com.sevilay.QuizApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDto {

    private String questionText;

    private List<AnswerResponseDto> answerResponseDtoList;
}
