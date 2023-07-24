package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAppointmentRequest {
	
      @Expose
	  @SerializedName("ApointmentId")
	  private long apointmentId;
      @Expose
	  @SerializedName("PatientId")
	  private long patientId;
      @Expose
	  @SerializedName("AppointmentDate")
	  private String appointmentDate; 
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
	  
	  
	  
	public UpdateAppointmentRequest(long apointmentId, long patientId, String appointmentDate,
			String language) {
		super();
		this.apointmentId = apointmentId;
		this.patientId = patientId;
		this.appointmentDate = appointmentDate;
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
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	  
	  

}
