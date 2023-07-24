package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteAppointmentRequest {
	
	  @Expose
	  @SerializedName("AppointmentId")
	  private long apointmentId;
	  @Expose
	  @SerializedName("PatientId")
	  private long patientId;
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
		  
	  
	  
	  
	public DeleteAppointmentRequest() {
		super();
	}



	public DeleteAppointmentRequest(long apointmentId, long patientId,  String language) {
		super();
		this.apointmentId = apointmentId;
		this.patientId = patientId;
		this.language = language;
	}
	
	
	
	public long getApointmentId() {
		return apointmentId;
	}
	public void setApointmentId(long apointmentId) {
		this.apointmentId = apointmentId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDevOsVersion() {
		return devOsVersion;
	}
	public void setDevOsVersion(String devOsVersion) {
		this.devOsVersion = devOsVersion;
	}
	public String getDevOsName() {
		return devOsName;
	}
	public void setDevOsName(String devOsName) {
		this.devOsName = devOsName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDevImei() {
		return devImei;
	}
	public void setDevImei(String devImei) {
		this.devImei = devImei;
	}
	  
	  

}
