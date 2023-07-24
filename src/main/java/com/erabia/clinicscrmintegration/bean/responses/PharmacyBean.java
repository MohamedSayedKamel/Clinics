package com.erabia.clinicscrmintegration.bean.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PharmacyBean {
	
	
	@Expose
	@SerializedName("Id")
	private String id ;
	@Expose
	@SerializedName("PharmacyName")
	private String parmacyName;  
	@Expose
	@SerializedName("PharmacyCode")
	private String parmacyCode;
	@Expose
	@SerializedName("Address")
	private String address ;
	@Expose
	@SerializedName("Longitude")
	private String longitude;
	@Expose
	@SerializedName("Latitude")
	private String latitude;
	@Expose
	@SerializedName("CityId")
	private String cityId ;
	@Expose
	@SerializedName("CityName")
	private String cityName;
	
	
	
	
	
	
	
	
	
	public PharmacyBean(String id, String parmacyName, String parmacyCode, String address, String latitude,String longitude,
			String cityId, String cityName) {
		super();
		this.id = id;
		this.parmacyName = parmacyName;
		this.parmacyCode = parmacyCode;
		this.address = address;
		this.cityId = cityId;
		this.cityName = cityName;
	}









	public String getId() {
		return id;
	}









	public void setId(String id) {
		this.id = id;
	}









	public String getParmacyName() {
		return parmacyName;
	}









	public void setParmacyName(String parmacyName) {
		this.parmacyName = parmacyName;
	}









	public String getParmacyCode() {
		return parmacyCode;
	}









	public void setParmacyCode(String parmacyCode) {
		this.parmacyCode = parmacyCode;
	}









	public String getAddress() {
		return address;
	}









	public void setAddress(String address) {
		this.address = address;
	}





















	public String getLongitude() {
		return longitude;
	}









	public String getLatitude() {
		return latitude;
	}









	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}









	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}









	public String getCityId() {
		return cityId;
	}









	public void setCityId(String cityId) {
		this.cityId = cityId;
	}









	public String getCityName() {
		return cityName;
	}









	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	
	
	

}
