package com.erabia.clinicscrmintegration.bean.requests;

import com.erabia.clinicscrmintegration.enums.Language;

public class CityPharmaciesSearchRequestData extends SearchRequestData {



	private String pharmacyName;

	private String pharmacyCode;

	private String cityId;


	
	public CityPharmaciesSearchRequestData(long pageNumber, long pageSize, Language language) {
		super(pageNumber, pageSize, language);
		
	}

	


	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getPharmacyCode() {
		return pharmacyCode;
	}

	public void setPharmacyCode(String pharmacyCode) {
		this.pharmacyCode = pharmacyCode;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
