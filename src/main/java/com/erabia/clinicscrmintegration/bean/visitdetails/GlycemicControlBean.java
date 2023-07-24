package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlycemicControlBean {
	

	private LocalDateTime a1cTestDate;


	private String a1cResult;

	private String antihyperglycemicMedications;

	private String strA1cTestDate;
	
	private String therapyAdherence;

	private BgRecordBean bgRecordBean;

	
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getA1cTestDate() {
		return a1cTestDate;
	}


	public final String getA1cResult() {
		return a1cResult;
	}

	public final String getAntihyperglycemicMedications() {
		return antihyperglycemicMedications;
	}

	public final String getTherapyAdherence() {
		return therapyAdherence;
	}

	public final BgRecordBean getBgRecordBean() {
		return bgRecordBean;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setA1cTestDate(LocalDateTime a1cTestDate) {
		this.a1cTestDate = a1cTestDate;
	}

	public final void setA1cResult(String a1cResult) {
		this.a1cResult = a1cResult;
	}

	public final void setAntihyperglycemicMedications(String antihyperglycemicMedications) {
		this.antihyperglycemicMedications = antihyperglycemicMedications;
	}

	public final void setTherapyAdherence(String therapyAdherence) {
		this.therapyAdherence = therapyAdherence;
	}

	public final void setBgRecordBean(BgRecordBean bgRecordBean) {
		this.bgRecordBean = bgRecordBean;
	}


	public String getStrA1cTestDate() {
		return strA1cTestDate;
	}


	public void setStrA1cTestDate(String strA1cTestDate) {
		this.strA1cTestDate = strA1cTestDate;
	}


	
	


	
	
	
}
