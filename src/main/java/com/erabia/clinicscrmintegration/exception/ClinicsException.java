package com.erabia.clinicscrmintegration.exception;

import com.erabia.clinicscrmintegration.exception.enums.ClinicsExceptionType;

public class ClinicsException extends Exception{
	
	
	
	private static final long serialVersionUID = -2727878348941788892L;
	private final ClinicsExceptionType type;
	private final String requestData;
	private final String responseData;
	private final String headers;
	private final String baseURL;

	public ClinicsException(final ClinicsExceptionType type, final String message,
			final String requestData, final String responseData,final String headers,final String baseURL) {
		super(message);
		this.type = type;
		this.responseData = responseData;
		this.requestData = requestData;
		this.headers=headers;
		this.baseURL=baseURL;

	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ClinicsExceptionType getType() {
		return type;
	}

	public String getRequestData() {
		return requestData;
	}

	public String getResponseData() {
		return responseData;

	}
	public final String getHeaders() {
		return headers;
	}

	public final String getBaseURL() {
		return baseURL;
	}

}
