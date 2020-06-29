package com.example.market.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public class QueryRequest<E> {
	
	private E sample;
	
	private Paging pageInfo;
	
	private List<OrderBy> orders;

	public E getSample() {
		return sample;
	}

	public void setSample(E sample) {
		this.sample = sample;
	}

	public Paging getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(Paging pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<OrderBy> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBy> orders) {
		this.orders = orders;
	}

	
}
