package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesRequest {
	
	@Expose
	@SerializedName("PageNumber")
	private long pageNumber;
	@Expose
	@SerializedName("PageSize")
	private long pageSize;
	@Expose
	@SerializedName("EnName")
	private String enName;
	@Expose
	@SerializedName("ArName")
	private String arName;
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
	
	
	public CitiesRequest() {
		super();
	}
	
	public CitiesRequest(long pageNumber, long pageSize, String language) {
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
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getArName() {
		return arName;
	}
	public void setArName(String arName) {
		this.arName = arName;
	}
	public String getDevOsVersion() {
		return devOsVersion;
	}
	public void setDevOsVersion(String devOsVersion) {
		this.devOsVersion = devOsVersion;
	}
	public String getDevOsName() {
		return devOsName;
	}
	public void setDevOsName(String devOsName) {
		this.devOsName = devOsName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDevImei() {
		return devImei;
	}
	public void setDevImei(String devImei) {
		this.devImei = devImei;
	}
	
}

