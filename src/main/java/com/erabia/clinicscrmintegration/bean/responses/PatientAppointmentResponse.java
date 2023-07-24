package com.erabia.clinicscrmintegration.bean.responses;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientAppointmentResponse extends AbstractResponse {

	@Expose
	@SerializedName("resultList")
	
	
	private List<PatientAppointmentsBean> patientAppointments;

	public PatientAppointmentResponse() {
		super();
	}

	public List<PatientAppointmentsBean> getPatientAppointments() {
		return patientAppointments;
	}

	public void setPatientAppointments(List<PatientAppointmentsBean> patientAppointments) {
		this.patientAppointments = patientAppointments;
	}

}
