package com.dxctraining.question.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.question.dto.CreateRequest;
import com.dxctraining.question.dto.QuestionDto;
import com.dxctraining.question.entity.Question;
import com.dxctraining.question.service.QuestionServiceImpl;
import com.dxctraining.question.util.QuestionUtil;

@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {

	@Autowired
	private QuestionUtil util;
	
	//private QuestionDto dto;
	@Autowired
	private QuestionServiceImpl service;
	
	@PostMapping("/addquestion")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public QuestionDto addquestion(@Valid @RequestBody CreateRequest req) {
		@NotBlank
		String questionOptions=req.getQuestionOptions(); 
		String questionTitle=req.getQuestionTitle();
		Integer questionAnswer=req.getQuestionAnswer();
		BigDecimal questionMarks=req.getQuestionMarks();
		Integer chosenAnswer=req.getChosenAnswer();
		BigDecimal marksScored=req.getMarksScored();
		
		Question question=new Question(questionOptions,questionTitle,questionAnswer,questionMarks,chosenAnswer,marksScored);
		question=service.addQuestion(question);
		QuestionDto dto=util.questiondto(question);
		return dto;
	}
	
	@GetMapping("/getQuestion/{id}")
	public QuestionDto getquestion(@PathVariable("id") BigInteger id) {
		Question question=service.getQuestionById(id);
		QuestionDto dto=util.questiondto(question);
		return dto;
	}
	@DeleteMapping("/deletequestion/{id}")
	public String deletequestion(@PathVariable("id") BigInteger id) {
		service.deleteQuestionById(id);
		//QuestionDto dto=util.questiondto(q);
		return "question deleted";
	}
	@GetMapping("/allquestions")
	public List<Question> getAllQuestion(){
		List<Question> question=service.getAllQuestions();
		return question;
	}
	
	@PutMapping("/update")
	public Question updateQuestion(@RequestBody CreateRequest req) {
		BigInteger questionId=req.getquestionId();
		String questionOptions=req.getQuestionOptions(); 
		String questionTitle=req.getQuestionTitle();
		Integer questionAnswer=req.getQuestionAnswer();
		BigDecimal questionMarks=req.getQuestionMarks();
		Integer chosenAnswer=req.getChosenAnswer();
		BigDecimal marksScored=req.getMarksScored();
		
		
		Question updatedquestion=service.updateQuestion(questionId, questionOptions, questionTitle, questionAnswer, questionMarks, chosenAnswer, marksScored);
		return updatedquestion;
	}
}
