package com.erabia.clinicscrmintegration.bean.responses;

import java.time.LocalDateTime;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientVisitsBean {

	@Expose
	@SerializedName("Id")
	private long id;
	@Expose
	@SerializedName("PatientId")
	private long patientId;
	@Expose
	@SerializedName("Date")
	private String visitDate;
	@Expose
	@SerializedName("PharmacyName")
	private String pharmacyName;
	@Expose
	@SerializedName("DoctorName")
	private String doctorName;
	
	
	public PatientVisitsBean(long id, long patientId, String visitDate, String pharmacyName, String doctorName) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.visitDate = visitDate;
		this.pharmacyName = pharmacyName;
		this.doctorName = doctorName;
	}

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a")
	public LocalDateTime getVisitDateFormat() throws DateFormattingException {
		
		if(visitDate==null) {
			
			return null;
		}
		else {
			return LocalDateTime.parse(visitDate);
		}
	
		
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getPatientId() {
		return patientId;
	}


	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}


	public String getVisitDate() {
		return visitDate;
	}


	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}


	public String getPharmacyName() {
		return pharmacyName;
	}


	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	
	
	
}
