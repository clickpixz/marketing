package com.example.market.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String code;

	private String[] params;

	public AppException() {
		super();
	}

	public AppException(Exception ex) {
		super(ex);
	}
	
	public AppException(Throwable thrable) {
		super(thrable);
	}

	public AppException(String code,String message) {
		super(message);
		this.code = code;
	}
	
	public AppException(String code,String message, String... params) {
		super(message);
		this.code = code;
		this.params = params;
	}
	
	public AppException(String message) {
		super(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AppException withErrorCode(String code) {
		this.code = code;
		return this;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String... params) {
		this.params = params;
	}
}
