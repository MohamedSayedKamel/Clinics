package com.erabia.clinicscrmintegration.bean.requests;

import com.erabia.clinicscrmintegration.enums.Language;

public class CityAllPharmaciesFilterRequestData {

	
	private String pharmacyName;

	private String pharmacyCode;

	private String cityId;
	
	private Language language;
	
	
	

	public CityAllPharmaciesFilterRequestData() {
		super();
	}

	public final String getPharmacyName() {
		return pharmacyName;
	}

	public final String getPharmacyCode() {
		return pharmacyCode;
	}

	public final String getCityId() {
		return cityId;
	}


	public final Language getLanguage() {
		return language;
	}

	public final void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public final void setPharmacyCode(String pharmacyCode) {
		this.pharmacyCode = pharmacyCode;
	}

	public final void setCityId(String cityId) {
		this.cityId = cityId;
	}


	public final void setLanguage(Language language) {
		this.language = language;
	}
	
	
	
}
