package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SerumCreatinineBean {

	
	private LocalDateTime serumCreatinineTestDate;
	
	
	
	private String strSerumCreatinineTestDate;

	

	
	private float serumCreatinine;


	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getSerumCreatinineTestDate() {
		return serumCreatinineTestDate;
	}





	public final float getSerumCreatinine() {
		return serumCreatinine;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setSerumCreatinineTestDate(LocalDateTime serumCreatinineTestDate) {
		this.serumCreatinineTestDate = serumCreatinineTestDate;
	}

	
	public final void setSerumCreatinine(float serumCreatinine) {
		this.serumCreatinine = serumCreatinine;
	}





	public String getStrSerumCreatinineTestDate() {
		return strSerumCreatinineTestDate;
	}





	public void setStrSerumCreatinineTestDate(String strSerumCreatinineTestDate) {
		this.strSerumCreatinineTestDate = strSerumCreatinineTestDate;
	}
	
	
}
