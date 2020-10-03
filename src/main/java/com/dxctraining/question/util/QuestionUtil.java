package com.dxctraining.question.util;

import org.springframework.stereotype.Component;

import com.dxctraining.question.dto.QuestionDto;
import com.dxctraining.question.entity.Question;

@Component
public class QuestionUtil {
	public QuestionDto questiondto(Question question) {
		QuestionDto dto=new QuestionDto(question.getQuestionId(),question.getQuestionOptions(),
				question.getQuestionTitle(),question.getQuestionAnswer(),question.getQuestionMarks(),
				question.getChosenAnswer(),question.getMarksScored());
		return dto;
	}
	
}
