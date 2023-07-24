package com.erabia.clinicscrmintegration.bean.requests;

import com.erabia.clinicscrmintegration.enums.Language;

public class PatientVisitsSearchRequestData extends SearchRequestData{
	
	private String phoneNumber;

	public PatientVisitsSearchRequestData(long pageNumber, long pageSize, Language language) {
		super(pageNumber, pageSize, language);
	}

	
	
	
//	public PatientVisitsSearchRequestData(long pageNumber, long pageSize, Language language, String phoneNumber) {
//		super(pageNumber, pageSize, language);
//		this.phoneNumber = phoneNumber;
//	}




	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
