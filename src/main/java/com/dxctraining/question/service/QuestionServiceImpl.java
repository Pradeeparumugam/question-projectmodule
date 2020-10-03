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
import com.dxctraining.question.exception.EmptyException;
import com.dxctraining.question.exception.QuestionIdNotValidException;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	public QuestionDao qdao;
	
	@Override
	public Question addQuestion(Question q) {
		Question question=qdao.save(q);
		return question;
	}

	@Override
	public Question getQuestionById(BigInteger id) {
		validation(id);
		//int id1=id.intValue();
		Optional<Question> op=qdao.findById(id);
		boolean b=op.isPresent();
		if(!b) {
			throw new EmptyException("NULL");
		}
		Question question=op.get();
		return question;	
	}
	
	@Override
	public List<Question> getAllQuestions(){
		List<Question> question=qdao.findAll();
		return question;
	}
	@Override
	public void deleteQuestionById(BigInteger id) {
		validation(id);
		//int id1=id.intValue();
		qdao.deleteById(id);
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
		Question q=getQuestionById(questionId);          //before updating
		q.setQuestionOptions(questionOptions);
		q.setQuestionTitle(questionTitle);
		q.setQuestionAnswer(questionAnswer);
		q.setQuestionMarks(questionMarks);
		q.setChosenAnswer(chosenAnswer);
		q.setMarksScored(marksScored);
		Question question=getQuestionById(questionId);   //after updating
		return question;
	}
	public void validation(BigInteger ob) {
		int id=ob.intValue();
		if(id<=0) {
			throw new QuestionIdNotValidException("Id is not valid");
		}
		
	}
	
}
