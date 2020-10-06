package com.dxctraining.question.exception;

public class QuestionNotFoundException extends RuntimeException {
	public QuestionNotFoundException(String alert) {
		super(alert);
	}

}
