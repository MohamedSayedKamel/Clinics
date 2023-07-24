package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LipidsBean {

	private float lipidsTg;


	private float lipidsLdlc;


	private float lipidsNonHdlc;


	private LocalDateTime lidpidsTestDate;


	private String strLidpidsTestDate;

	public final float getLipidsTg() {
		return lipidsTg;
	}


	public final float getLipidsLdlc() {
		return lipidsLdlc;
	}


	public final float getLipidsNonHdlc() {
		return lipidsNonHdlc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final LocalDateTime getLidpidsTestDate() {
		return lidpidsTestDate;
	}




	public final void setLipidsTg(float lipidsTg) {
		this.lipidsTg = lipidsTg;
	}


	public final void setLipidsLdlc(float lipidsLdlc) {
		this.lipidsLdlc = lipidsLdlc;
	}


	public final void setLipidsNonHdlc(float lipidsNonHdlc) {
		this.lipidsNonHdlc = lipidsNonHdlc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM,hh:mm a")
	public final void setLidpidsTestDate(LocalDateTime lidpidsTestDate) {
		this.lidpidsTestDate = lidpidsTestDate;
	}


	public String getStrLidpidsTestDate() {
		return strLidpidsTestDate;
	}


	public void setStrLidpidsTestDate(String strLidpidsTestDate) {
		this.strLidpidsTestDate = strLidpidsTestDate;
	}



	
}
