package com.dxctraining.question.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.question.dao.QuestionDao;
import com.dxctraining.question.entity.Question;
import com.dxctraining.question.exception.IdNotValidException;
import com.dxctraining.question.exception.QuestionAlreadyExistsException;
import com.dxctraining.question.exception.QuestionIdNotValidException;
import com.dxctraining.question.exception.QuestionNotFoundException;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	public QuestionDao qdao;
	
	@Override
	public Question addQuestion(Question newQuestion) {
		
		Question question=qdao.save(newQuestion);
		return question;
	}

	@Override
	public Question getQuestionById(BigInteger id) {
		validation(id);
		//int id1=id.intValue();
		
		Optional<Question> optional=qdao.findById(id);
		boolean bool=optional.isPresent();
		if(!bool) {
			throw new IdNotValidException("Id is Not valid Enter a valid Id");
		}
		Question question=optional.get();
		return question;	
	}
	
	@Override
	public List<Question> getAllQuestions(){
		List<Question> question=qdao.findAll();
		return question;
	}
	@Override
	public void deleteQuestionById(BigInteger questionId) {
		validation(questionId);
		if(!qdao.existsById(questionId)) {
			throw new QuestionNotFoundException("Question with id : ["+questionId+"] Not Found"); 
		}
		//int id1=id.intValue();
		qdao.deleteById(questionId);
	}
	/*@Override
	public Question updateQuestion(Question newquestion) {
		Question question=qdao.getOne(newquestion.getQuestionId());
		question.setQuestionTitle(newquestion.getQuestionTitle());
		question.setQuestionOptions(newquestion.getQuestionOptions());
		question.setQuestionMarks(newquestion.getQuestionMarks());
		question.setQuestionAnswer(newquestion.getQuestionAnswer());
		question.setMarksScored(newquestion.getMarksScored());
		question=qdao.save(question);
		return question;	
	}
	*/
	@Override
	public Question updateQuestion(BigInteger questionId,String questionOptions, String questionTitle, Integer questionAnswer,
			BigDecimal questionMarks, Integer chosenAnswer, BigDecimal marksScored) {
		Question question=getQuestionById(questionId);          //before updating
		question.setQuestionOptions(questionOptions);
		question.setQuestionTitle(questionTitle);
		question.setQuestionAnswer(questionAnswer);
		question.setQuestionMarks(questionMarks);
		question.setChosenAnswer(chosenAnswer);
		question.setMarksScored(marksScored);
		Question updatedQuestion=getQuestionById(questionId);   //after updating
		return updatedQuestion;
	}
	public void validation(BigInteger questionId) {
		int id=questionId.intValue();
		if(id<=0) {
			throw new QuestionIdNotValidException("Id is not valid, enter a id greater than 0");
		}
		
	}
	
}
