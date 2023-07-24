package com.erabia.clinicscrmintegration.bean.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityBean {
	
	

	@Expose
	@SerializedName("Id")
	private String id;
	@Expose
	@SerializedName("Name")
	private String name;
	
	
	
	public CityBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

