package com.dxctraining.question.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.dxctraining.question.entity.Question;

public interface QuestionService {
	public Question addQuestion(Question q);
	public Question getQuestionById(BigInteger id);
	public List<Question> getAllQuestions();
	public void deleteQuestionById(BigInteger id);
	//public Question updateQuestion(Question newquestion);
	public Question updateQuestion(BigInteger questionId,String questionOptions, String questionTitle, Integer questionAnswer,
			BigDecimal questionMarks, Integer chosenAnswer, BigDecimal marksScored);
}
