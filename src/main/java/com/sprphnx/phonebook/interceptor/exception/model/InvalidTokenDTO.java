package com.sprphnx.phonebook.interceptor.exception.model;

public class InvalidTokenDTO {
	
	String errorCode;
	String message;
	
	public InvalidTokenDTO(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}

}
