package com.example.market.message;

/*
 * Just test for builder
 * */
public class ApiResponseBuilder {
	private final boolean succ;
	private Object body;
	private ApiResponseBuilder(boolean isSucess) {
		succ = isSucess;
	}
	
	public static ApiResponseBuilder withSucessResponse() {
		return new ApiResponseBuilder(true);
	}
	
	public ApiResponseBuilder withBody(Object body) {
		this.body = body;
		return this;
	}
	public APIResponse build() {
		if(succ) {
			return new APISuccReponse().withBody(this.body);
		}
		return new APIErrorResponse().withBody(this.body);
	}
}
