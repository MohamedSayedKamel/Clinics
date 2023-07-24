package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PharmacyScheduleRequest {

    @Expose
	@SerializedName("AppointmentDate")
    private String appointmentDate;
    @Expose
	@SerializedName("PharmacyId")
    private long pharmacyId;
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
    
    
    
    
    
    
	public PharmacyScheduleRequest(String appointmentDate, long pharmacyId, String language) {
		super();
		this.appointmentDate = appointmentDate;
		this.pharmacyId = pharmacyId;
		this.language = language;
	}


	public PharmacyScheduleRequest() {
		super();
	}
	
	
	


	public final String getAppointmentDate() {
		return appointmentDate;
	}


	public final long getPharmacyId() {
		return pharmacyId;
	}


	public final String getDevOsVersion() {
		return devOsVersion;
	}


	public final String getDevOsName() {
		return devOsName;
	}


	public final String getLanguage() {
		return language;
	}


	public final String getDevImei() {
		return devImei;
	}


	public final void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public final void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}


	public final void setDevOsVersion(String devOsVersion) {
		this.devOsVersion = devOsVersion;
	}


	public final void setDevOsName(String devOsName) {
		this.devOsName = devOsName;
	}


	public final void setLanguage(String language) {
		this.language = language;
	}


	public final void setDevImei(String devImei) {
		this.devImei = devImei;
	}



	
	

    
    
}
