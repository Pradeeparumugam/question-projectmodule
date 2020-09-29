package com.dxctraining.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.question.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {

}
