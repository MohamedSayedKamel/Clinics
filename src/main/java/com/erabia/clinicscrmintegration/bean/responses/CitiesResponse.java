package com.erabia.clinicscrmintegration.bean.responses;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesResponse extends AbstractResponse {
	@Expose
	@SerializedName("Cities")
	private List<CityBean> cities;
	@Expose
	@SerializedName("TotalCount")
	private long totalCount;

	
	public CitiesResponse() {
		super();
	}

	public List<CityBean> getCities() {
		return cities;
	}

	public void setCities(List<CityBean> cities) {
		this.cities = cities;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
