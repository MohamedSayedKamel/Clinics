package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DilatedEyeExamBean {

	
	private LocalDateTime dilatedEyeExamDate;

	private String strDilatedEyeExamDate;

	private String strDilatedEyeExamReminded;
	


	private String strRetinopathy;
	
	
	private String severityTherapies;
	
	
	
	public final String getStrDilatedEyeExamReminded() {
		return strDilatedEyeExamReminded;
	}


	public final String getStrRetinopathy() {
		return strRetinopathy;
	}


	public final void setStrDilatedEyeExamReminded(String strDilatedEyeExamReminded) {
		this.strDilatedEyeExamReminded = strDilatedEyeExamReminded;
	}


	public final void setStrRetinopathy(String strRetinopathy) {
		this.strRetinopathy = strRetinopathy;
	}





	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getDilatedEyeExamDate() {
		return dilatedEyeExamDate;
	}





	public final String getSeverityTherapies() {
		return severityTherapies;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setDilatedEyeExamDate(LocalDateTime dilatedEyeExamDate) {
		this.dilatedEyeExamDate = dilatedEyeExamDate;
	}




	public final void setSeverityTherapies(String severityTherapies) {
		this.severityTherapies = severityTherapies;
	}


	public String getStrDilatedEyeExamDate() {
		return strDilatedEyeExamDate;
	}


	public void setStrDilatedEyeExamDate(String strDilatedEyeExamDate) {
		this.strDilatedEyeExamDate = strDilatedEyeExamDate;
	}
	
	
	
}
