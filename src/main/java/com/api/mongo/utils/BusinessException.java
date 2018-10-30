package com.api.mongo.utils;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 182205752672530611L;

	public BusinessException(String message){
		super(message);
	}
}
