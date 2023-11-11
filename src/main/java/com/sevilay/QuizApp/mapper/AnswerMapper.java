package com.sevilay.QuizApp.mapper;

import com.sevilay.QuizApp.dto.request.AnswerSaveRequestDto;

import com.sevilay.QuizApp.dto.response.AnswerResponseDto;
import com.sevilay.QuizApp.repository.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    Answer fromSaveRequestToAnswer(final AnswerSaveRequestDto dto);

    AnswerResponseDto fromAnswerToResponse(final Answer answer);

    List<Answer> fromSaveRequestToAnswers(final List<AnswerSaveRequestDto> dtoList);

    List<AnswerResponseDto> fromAnswersToResponses(final List<Answer> answerList);

}
