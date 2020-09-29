package com.dxctraining.question.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.question.dao.QuestionDao;
import com.dxctraining.question.entity.Question;
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
		int id1=id.intValue();
		Optional<Question> op=qdao.findById(id1);
		boolean b=op.isPresent();
		if(!b) {
			throw new QuestionIdNotValidException("Id is not valid");
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
		int id1=id.intValue();
		qdao.deleteById(id1);
	}
	@Override
	public Question uppdateQuestion(Question question) {
		Questio
	}
	
}
