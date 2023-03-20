package com.mappingProject.utils;



public class EmailStatus {
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	
	private final String to;
	private final String subject;
	private final String body;
	
	private String status;
	private String errorMessage;
	
	public EmailStatus(String[] to, String subject, String body) {
		super();
		this.to = "to";
		
		this.subject = subject;
		this.body = body;
	}
	////////// Created success method for success ////////
	public EmailStatus success() {
		this.status = SUCCESS;
		return this;
	}
//////////Created error method for error ////////
	public EmailStatus error() {
		this.errorMessage = ERROR;
		return this;
	}
	
	/////// Check for success method ///////////
	public Boolean isSuccess() {
		return SUCCESS.equals(this.status);
	}
	
/////// Check for Error method ///////////
	public Boolean isError() {
		return ERROR.equals(this.errorMessage);
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static String getSuccess() {
		return SUCCESS;
	}
	public static String getError() {
		return ERROR;
	}
	public String getTo() {
		return to;
	}
	public String getSubject() {
		return subject;
	}
	public String getBody() {
		return body;
	}
	
	

}
