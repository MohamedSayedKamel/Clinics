package com.erabia.clinicscrmintegration.bean.responses;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleResponse extends AbstractResponse {

	@Expose
	@SerializedName("AvaliableTime")
	private List<AvailableTimeBean> availableTime;
	
	public ScheduleResponse() {
		super();
	}
	public List<AvailableTimeBean> getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(List<AvailableTimeBean> availableTime) {
		this.availableTime = availableTime;
	}

	
	
}
