package com.erabia.clinicscrmintegration.exception.enums;

public enum ClinicsExceptionType {
	BAD_REQUEST(),
	GENERAL_ERROR(100),
	INVALID_PARAMETERS(101),
	INVALID_CLIENT_KEY(102),
	DATE_FORMAT_ERROR("please enter the correct date format ");

	


	private long errorCode;
	private String errorMessage;
	
	
	
	
	ClinicsExceptionType() {
	}
	ClinicsExceptionType(int errorCode) {
		this.errorCode = errorCode;
	}
	ClinicsExceptionType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
	
	public long getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

}
