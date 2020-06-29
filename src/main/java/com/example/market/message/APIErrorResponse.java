package com.example.market.message;


import com.example.market.constant.AppConstants;
import com.example.market.exception.AppException;

public class APIErrorResponse extends APIResponse{
	
	public APIErrorResponse() {
		super();
	}
	public APIErrorResponse(String code) {
		super();
		setCode(code);
		setMessage(code);
	}
	public APIErrorResponse forException(Exception exception) {
		if(exception==null) {
			setCode(AppConstants.SYSTEM_ERROR);
			setMessage("Unkown error. Exception is null");
			return this;
		}
		if(exception instanceof AppException) {
			setCode(((AppException)exception).getCode());
			setMessage(((AppException)exception).getMessage());
			return this;			
		}
		setCode(AppConstants.SYSTEM_ERROR);
		setMessage(exception.getMessage());
		return this;
	}
}
