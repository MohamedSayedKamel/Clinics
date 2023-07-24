package com.erabia.clinicscrmintegration.exception;

import com.erabia.clinicscrmintegration.exception.enums.ClinicsExceptionType;

public class DateFormattingException extends Exception{

	
	private static final long serialVersionUID = -2727878348941788892L;
	private final ClinicsExceptionType type;

	
	
	public DateFormattingException(final ClinicsExceptionType type,final String message) {
		super(message);
		this.type = type;
		
	}


	public static final long getSerialversionuid() {
		return serialVersionUID;
	}


	public final ClinicsExceptionType getType() {
		return type;
	}




	
	
	


}
