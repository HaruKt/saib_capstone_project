package com.saib.exceptions;

import java.time.LocalDateTime;

public class ApiExceptionPayload {

	private String message;
	private int status;
	private String httpStatus;
	private boolean success;
	private boolean exception;
	private String path;
	private LocalDateTime timestamp;
	
	
	public ApiExceptionPayload() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiExceptionPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			String path, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.path = path;
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public boolean isException() {
		return exception;
	}


	public void setException(boolean exception) {
		this.exception = exception;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public static String formatMessage(String message)
	{
		//"404 NOT_FOUND \"Account doesn't exist\"",
		int indexOfDoubleQuotes=message.indexOf("\"");
		message=message.substring(indexOfDoubleQuotes+1);
		message=message.replace("\"","");
		return message;
	}
	
	
	
	
	
	
}