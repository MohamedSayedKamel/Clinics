package com.erabia.clinicscrmintegration.bean.responses;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityPharmaciesResponse extends AbstractResponse {

	@Expose
	@SerializedName("cityPharmacies")
	private List<PharmacyBean> pharmacies;
	@Expose
	@SerializedName("TotalCount")
	private long totalCount;

	public CityPharmaciesResponse() {
		super();
	}

	public List<PharmacyBean> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<PharmacyBean> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
