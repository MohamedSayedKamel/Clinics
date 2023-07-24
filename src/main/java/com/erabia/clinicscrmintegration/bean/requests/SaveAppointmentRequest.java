package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveAppointmentRequest {
	
    @Expose
	@SerializedName("AppointmentDate")
	private String appointmentDate;
    @Expose
	@SerializedName("DevImei")
	private String devImei;
    @Expose
	@SerializedName("DevOsName")
	private String devOsName;
    @Expose
	@SerializedName("DevOsVersion")
	private String devOsVersion;
    @Expose
	@SerializedName("Language")
	private String language;
    @Expose
	@SerializedName("Notes")
	private String notes;
    @Expose
	@SerializedName("PharmacyId")
	private long pharmacyId;
    @Expose
	@SerializedName("PhoneNumber")
	private String phoneNumber; 
	
	
	
	public final String getAppointmentDate() {
		return appointmentDate;
	}
	
	
	public SaveAppointmentRequest() {
		super();
	}


	public SaveAppointmentRequest(String appointmentDate, String language, long pharmacyId, String phoneNumber) {
		super();
		this.appointmentDate = appointmentDate;
		this.language = language;
		this.pharmacyId = pharmacyId;
		this.phoneNumber = phoneNumber;
	}


	public SaveAppointmentRequest(String appointmentDate, String language, long pharmacyId, String phoneNumber,String notes) {
		super();
		this.appointmentDate = appointmentDate;
		this.language = language;
		this.pharmacyId = pharmacyId;
		this.phoneNumber = phoneNumber;
		this.notes=notes;
	}
	public final void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public final String getLanguage() {
		return language;
	}
	public final void setLanguage(String language) {
		this.language = language;
	}
	public final long getPharmacyId() {
		return pharmacyId;
	}
	public final void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public final String getNotes() {
		return notes;
	}


	public final void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	

}
