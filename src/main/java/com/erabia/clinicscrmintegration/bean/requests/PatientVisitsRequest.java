package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientVisitsRequest {
	
	@Expose
	@SerializedName("PageNumber")
	private long pageNumber;
	@Expose
	@SerializedName("PageSize")
	private long pageSize;
	@Expose
	@SerializedName("PhoneNumber")
	private String phoneNumber; 
	@Expose
	@SerializedName("DevOsVersion")
	private String devOsVersion;
	@Expose
	@SerializedName("DevOsName")
	private String devOsName;
	@Expose
	@SerializedName("Language")
	private String language;
	@Expose
	@SerializedName("DevImei")
	private String devImei;
	
	
	
	
	public PatientVisitsRequest() {
		super();
	}


	public PatientVisitsRequest(long pageNumber, long pageSize, String language, String phoneNumber) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.language = language;
		this.phoneNumber = phoneNumber;
	}


	public final void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}


	public final void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}


	public final void setLanguage(String language) {
		this.language = language;
	}


	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

}
