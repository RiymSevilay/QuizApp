package com.sevilay.QuizApp.repository;

import com.sevilay.QuizApp.dto.response.QuestionResponseDto;
import com.sevilay.QuizApp.repository.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {



}
