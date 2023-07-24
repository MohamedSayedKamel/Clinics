package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientAppointmentRequest {
	
	@Expose
	@SerializedName("IsUpcoming")
    private boolean isUpcoming; 
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
    
    
	public final boolean isUpcoming() {
		return isUpcoming;
	}
	public final void setUpcoming(boolean isUpcoming) {
		this.isUpcoming = isUpcoming;
	}
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public final String getLanguage() {
		return language;
	}
	public final void setLanguage(String language) {
		this.language = language;
	}
    
    

}
