package com.erabia.clinicscrmintegration.bean.responses;

import java.beans.Transient;
import java.time.LocalDateTime;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientAppointmentsBean {
	
    @Expose
	@SerializedName("Id")
    private long id;
    @Expose
	@SerializedName("PatientId")
    private long patientId;
    @Expose
	@SerializedName("Date")
    private String date;
    @Expose
	@SerializedName("PharmacyName")
    private String pharmacyName;
    @Expose
	@SerializedName("DoctorName")
    private String doctorName;
    @Expose
	@SerializedName("PharmacyId")
    private long pharmacyId;
    
    
    
    
	public PatientAppointmentsBean(long id, long patientId, String date, String pharmacyName, String doctorName,
			long pharmacyId) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.date = date;
		this.pharmacyName = pharmacyName;
		this.doctorName = doctorName;
		this.pharmacyId = pharmacyId;
	}
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") //TODO
	public LocalDateTime getDateTimeDateFormat() throws DateFormattingException {
	
		if(!date.isEmpty()) {
			return LocalDateTime.parse(date);
		}
		else {
			return null;
		}
	}


	
	
	public final long getId() {
		return id;
	}
	public final long getPatientId() {
		return patientId;
	}
	@Transient
	public final String getDate() {
		return date;
	}
	public final String getPharmacyName() {
		return pharmacyName;
	}
	public final String getDoctorName() {
		return doctorName;
	}
	public final long getPharmacyId() {
		return pharmacyId;
	}
	public final void setId(long id) {
		this.id = id;
	}
	public final void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public final void setDate(String date) {
		this.date = date;
	}
	public final void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public final void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public final void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
    

   

}
