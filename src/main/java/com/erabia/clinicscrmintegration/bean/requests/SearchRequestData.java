package com.erabia.clinicscrmintegration.bean.requests;

import com.erabia.clinicscrmintegration.enums.Language;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SearchRequestData {
	
	@Expose
	@SerializedName("PageNumber")
	private long pageNumber;
	@Expose
	@SerializedName("PageSize")
	private long pageSize;
	@Expose
	@SerializedName("Language")
	private Language language;
	
	
	
	
	
	public SearchRequestData(long pageNumber, long pageSize, Language language) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.language = language;
	}
	public long getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	
}
