package com.example.market.exception;
import com.example.market.constant.AppConstants;


public class AppAssertionException extends AppException{
	private static final long serialVersionUID = 1L;
	public AppAssertionException(String messages) {
		super(AppConstants.NULL_OBJ, messages);
	}
}
