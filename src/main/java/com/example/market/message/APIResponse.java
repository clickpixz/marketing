package com.example.market.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public abstract class APIResponse {

	private String code;

	private String message;

	private Object body;

	public APIResponse() {
		super();
	}

	public APIResponse(String code, String message, BReponseBody body) {
		super();
		this.code = code;
		this.message = message;
		this.body = body;
	}
	public APIResponse emptyBody() {
		return this;
	}
	protected APIResponse withCode(String code) {
		this.code = code;
		return this;
	}

	public APIResponse withMessage(String message) {
		this.message = message;
		return this;
	}

	public APIResponse withBody(Object body) {
		this.body = body;
		return this;
	}

	public String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setContent(Object body) {
		this.body = body;
	}
}
