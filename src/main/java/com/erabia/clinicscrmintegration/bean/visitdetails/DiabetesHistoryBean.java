package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiabetesHistoryBean {
	
	




	private String diabetesType;
	

	private String strdiabetesDateDiagnosed;
	
	private String strComorbidities;
	

	private LocalDateTime diabetesDateDiagnosed;

	


	

	public final String getDiabetesType() {
		return diabetesType;
	}


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getDiabetesDateDiagnosed() {
		return diabetesDateDiagnosed;
	}


	

	public final void setDiabetesType(String diabetesType) {
		this.diabetesType = diabetesType;
	}


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setDiabetesDateDiagnosed(LocalDateTime diabetesDateDiagnosed) {
		this.diabetesDateDiagnosed = diabetesDateDiagnosed;
	}


	public String getStrComorbidities() {
		return strComorbidities;
	}

	public void setStrComorbidities(String strComorbidities) {
		this.strComorbidities = strComorbidities;
	}



	public String getStrdiabetesDateDiagnosed() {
		return strdiabetesDateDiagnosed;
	}



	public void setStrdiabetesDateDiagnosed(String strdiabetesDateDiagnosed) {
		this.strdiabetesDateDiagnosed = strdiabetesDateDiagnosed;
	}
	
	
	
	

	
}
