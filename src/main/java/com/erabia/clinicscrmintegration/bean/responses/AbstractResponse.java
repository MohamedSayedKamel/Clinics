package com.erabia.clinicscrmintegration.bean.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractResponse {
	@Expose
	@SerializedName("StatusCode")
	private long statusCode;
	@Expose
	@SerializedName("Message")
	private String message;
	
	@Expose
	private String requestData;
	@Expose
	private String responseData;
	@Expose
	private String headers;
	@Expose
	private String baseUrl;
	
	public long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public String getRequestData() {
		return requestData;
	}
	public String getResponseData() {
		return responseData;
	}
	public String getHeaders() {
		return headers;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	
	
}
