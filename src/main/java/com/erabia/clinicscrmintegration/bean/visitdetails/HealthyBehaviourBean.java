package com.erabia.clinicscrmintegration.bean.visitdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthyBehaviourBean {
	
	

	private float weight;

	
	private float height;


	private float bmi;


	private float waistCircumference;

	

	private String nutritionType;

	

	private String physicalActivityType;	




	private String smokingStatus;


	public final float getWeight() {
		return weight;
	}


	public final float getHeight() {
		return height;
	}


	public final float getBmi() {
		return bmi;
	}


	public final float getWaistCircumference() {
		return waistCircumference;
	}


	


	public final String getNutritionType() {
		return nutritionType;
	}


	


	public final String getPhysicalActivityType() {
		return physicalActivityType;
	}


	


	public final String getSmokingStatus() {
		return smokingStatus;
	}


	public final void setWeight(float weight) {
		this.weight = weight;
	}


	public final void setHeight(float height) {
		this.height = height;
	}


	public final void setBmi(float bmi) {
		this.bmi = bmi;
	}


	public final void setWaistCircumference(float waistCircumference) {
		this.waistCircumference = waistCircumference;
	}


	


	public final void setNutritionType(String nutritionType) {
		this.nutritionType = nutritionType;
	}


	


	public final void setPhysicalActivityType(String physicalActivityType) {
		this.physicalActivityType = physicalActivityType;
	}


	


	public final void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	
	
	
	
	

	

}
