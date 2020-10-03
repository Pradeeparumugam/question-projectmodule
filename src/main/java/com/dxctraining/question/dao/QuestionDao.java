package com.dxctraining.question.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctraining.question.entity.Question;

//@Repository
public interface QuestionDao extends JpaRepository<Question, BigInteger> {
	
	/*List<Question> getAllQuestions();
	 void deleteQuestionById(BigInteger id);
	 Question updateQuestion(Question newquestion);
	 	
	*/
}
