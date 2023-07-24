package com.erabia.clinicscrmintegration.bean.responses;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientVisitsResponse extends AbstractResponse {

	@Expose
	@SerializedName("resultList")
	private List<PatientVisitsBean> visits;
	@Expose
	@SerializedName("TotalCount")
	private long totalCount;

	
	
	public PatientVisitsResponse() {
		super();
	}

	public List<PatientVisitsBean> getVisits() {
		return visits;
	}

	public void setVisits(List<PatientVisitsBean> visits) {
		this.visits = visits;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

}
