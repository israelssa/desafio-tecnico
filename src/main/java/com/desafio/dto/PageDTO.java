package com.desafio.dto;

import java.io.Serializable;

public class PageDTO implements Serializable {
	
	private static final long serialVersionUID = 892757854512054937L;
	
	private Integer pageNumber;
	private Integer pageSize;
	private String sortField;
	private Boolean sortOrderAsc;
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public Boolean getSortOrderAsc() {
		return sortOrderAsc;
	}
	public void setSortOrderAsc(Boolean sortOrderAsc) {
		this.sortOrderAsc = sortOrderAsc;
	}
	
	
}
