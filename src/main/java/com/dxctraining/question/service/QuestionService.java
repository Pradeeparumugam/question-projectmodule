package com.dxctraining.question.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.dxctraining.question.entity.Question;

public interface QuestionService {
	 Question addQuestion(Question q);
	 Question getQuestionById(BigInteger id);
	 List<Question> getAllQuestions();
	 void deleteQuestionById(BigInteger id);
	//public Question updateQuestion(Question newquestion);
	 Question updateQuestion(BigInteger questionId,String questionOptions, String questionTitle, Integer questionAnswer,
			BigDecimal questionMarks, Integer chosenAnswer, BigDecimal marksScored);
}
