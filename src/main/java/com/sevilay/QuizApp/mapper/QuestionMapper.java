package com.sevilay.QuizApp.mapper;

import com.sevilay.QuizApp.dto.request.QuestionSaveRequestDto;
import com.sevilay.QuizApp.repository.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    Question fromSaveRequestToQuestion(final QuestionSaveRequestDto dto);

}
