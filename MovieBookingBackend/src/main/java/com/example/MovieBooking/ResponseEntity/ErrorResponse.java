package com.example.MovieBooking.ResponseEntity;

public class ErrorResponse {
	
	private String ErrorText;
	private String ErrorCode;

	public ErrorResponse(String response,String errorCode) {
		super();
		this.ErrorText = response;
		this.ErrorCode = errorCode;
	}

	public String getResponse() {
		return ErrorText;
	}

	public void setResponse(String response) {
		this.ErrorText = response;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	

}
