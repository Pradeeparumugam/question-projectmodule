package com.dxctraining.question.exception;

public class QuestionAlreadyExistsException extends RuntimeException{
	public QuestionAlreadyExistsException(String alert) {
		super(alert);
	}

}
