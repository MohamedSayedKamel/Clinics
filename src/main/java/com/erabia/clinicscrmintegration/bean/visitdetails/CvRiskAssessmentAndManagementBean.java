package com.erabia.clinicscrmintegration.bean.visitdetails;

import java.time.LocalDateTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CvRiskAssessmentAndManagementBean {


	private String bp1;


	private String bp2;


	private String bp3;


	private long pulse1;


	private long pulse2;


	private long pulse3;


	private String antihypertensiveDrugs;

	private String strCvdSymptoms;
	


	private LipidsBean lipidsBean;

	private LipidLoweringTherapyBean lipidLoweringTherapyBean;

	private AceInhibitorBean aceInhibitorBean;

	private AntiplateletAgentBean antiplateletAgentBean;

	
	
	
	
	
	
	public final String getBp1() {
		return bp1;
	}

	public final String getBp2() {
		return bp2;
	}

	public final String getBp3() {
		return bp3;
	}

	public final long getPulse1() {
		return pulse1;
	}

	public final long getPulse2() {
		return pulse2;
	}

	public final long getPulse3() {
		return pulse3;
	}

	public final String getAntihypertensiveDrugs() {
		return antihypertensiveDrugs;
	}

	

	public final LipidsBean getLipidsBean() {
		return lipidsBean;
	}

	public final LipidLoweringTherapyBean getLipidLoweringTherapyBean() {
		return lipidLoweringTherapyBean;
	}

	public final AceInhibitorBean getAceInhibitorBean() {
		return aceInhibitorBean;
	}

	public final AntiplateletAgentBean getAntiplateletAgentBean() {
		return antiplateletAgentBean;
	}

	
	
	public final void setBp1(String bp1) {
		this.bp1 = bp1;
	}

	public final void setBp2(String bp2) {
		this.bp2 = bp2;
	}

	public final void setBp3(String bp3) {
		this.bp3 = bp3;
	}

	public final void setPulse1(long pulse1) {
		this.pulse1 = pulse1;
	}

	public final void setPulse2(long pulse2) {
		this.pulse2 = pulse2;
	}

	public final void setPulse3(long pulse3) {
		this.pulse3 = pulse3;
	}

	public final void setAntihypertensiveDrugs(String antihypertensiveDrugs) {
		this.antihypertensiveDrugs = antihypertensiveDrugs;
	}

	

	public final void setLipidsBean(LipidsBean lipidsBean) {
		this.lipidsBean = lipidsBean;
	}

	public final void setLipidLoweringTherapyBean(LipidLoweringTherapyBean lipidLoweringTherapyBean) {
		this.lipidLoweringTherapyBean = lipidLoweringTherapyBean;
	}

	public final void setAceInhibitorBean(AceInhibitorBean aceInhibitorBean) {
		this.aceInhibitorBean = aceInhibitorBean;
	}

	public final void setAntiplateletAgentBean(AntiplateletAgentBean antiplateletAgentBean) {
		this.antiplateletAgentBean = antiplateletAgentBean;
	}

	public String getStrCvdSymptoms() {
		return strCvdSymptoms;
	}

	public void setStrCvdSymptoms(String strCvdSymptoms) {
		this.strCvdSymptoms = strCvdSymptoms;
	}
	


	

	
	
}
