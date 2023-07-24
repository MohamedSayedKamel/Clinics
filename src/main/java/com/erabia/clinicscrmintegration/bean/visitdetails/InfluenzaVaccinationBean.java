package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InfluenzaVaccinationBean {

	


	private String strInfluenzaVaccination;
	



	private String influenzaVaccinationReason;

	
	private LocalDateTime influenzaVaccinationDate;


	private String strInfluenzaVaccinationDate;

	
	
	public final String getStrInfluenzaVaccination() {
		return strInfluenzaVaccination;
	}


	public final void setStrInfluenzaVaccination(String strInfluenzaVaccination) {
		this.strInfluenzaVaccination = strInfluenzaVaccination;
	}
	
	


	public final String getInfluenzaVaccinationReason() {
		return influenzaVaccinationReason;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getInfluenzaVaccinationDate() {
		return influenzaVaccinationDate;
	}




	public final void setInfluenzaVaccinationReason(String influenzaVaccinationReason) {
		this.influenzaVaccinationReason = influenzaVaccinationReason;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setInfluenzaVaccinationDate(LocalDateTime influenzaVaccinationDate) {
		this.influenzaVaccinationDate = influenzaVaccinationDate;
	}


	public String getStrInfluenzaVaccinationDate() {
		return strInfluenzaVaccinationDate;
	}


	public void setStrInfluenzaVaccinationDate(String strInfluenzaVaccinationDate) {
		this.strInfluenzaVaccinationDate = strInfluenzaVaccinationDate;
	}


	
	
	
}
