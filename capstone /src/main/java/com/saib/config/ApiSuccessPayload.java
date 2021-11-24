package com.saib.config;

import org.springframework.http.HttpStatus;

public class ApiSuccessPayload {

	private String message;
	private int status;
	private String httpStatus;
	private boolean success;
	private boolean exception;
	private Object body;
	
	public ApiSuccessPayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiSuccessPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			Object body) {
		super();
		this.message = message;
		this.status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.body = body;
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

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "APISuccessPayload [message=" + message + ", status=" + status + ", httpStatus=" + httpStatus
				+ ", success=" + success + ", exception=" + exception + ", body=" + body + "]";
	}
	
	
	public static ApiSuccessPayload build(Object body,String message,HttpStatus status)
	{
		ApiSuccessPayload payload=new ApiSuccessPayload();
		payload.setStatus(status.value());
		payload.setMessage(message);
		payload.setBody(body);
		payload.setSuccess(true);
		payload.setException(false);
		payload.setHttpStatus(String.valueOf(status));
		
		return payload;
	}
	
	
	
	

}
