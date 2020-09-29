package com.dxctraining.question.service;

import java.math.BigInteger;
import java.util.List;

import com.dxctraining.question.entity.Question;

public interface QuestionService {
	public Question addQuestion(Question q);
	public Question getQuestionById(BigInteger id);
	public List<Question> getAllQuestions();
	public void deleteQuestionById(BigInteger id);
}
