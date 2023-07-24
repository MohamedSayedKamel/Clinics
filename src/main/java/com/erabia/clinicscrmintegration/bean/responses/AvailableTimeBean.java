package com.erabia.clinicscrmintegration.bean.responses;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import com.erabia.clinicscrmintegration.exception.DateFormattingException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableTimeBean {
	
	@Expose
	@SerializedName("DateTime")
	private String dateTime;
	@Expose
	@SerializedName("Time")
	private String time;
	
	
	public AvailableTimeBean(String dateTime, String time) {
		super();
		this.dateTime = dateTime;
		this.time = time;
	}

	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a")
	public LocalDateTime getDateTimeDateFormat() throws DateFormattingException {
		
		if(dateTime==null) {
			
			return null;
		}
		else {
			return LocalDateTime.parse(dateTime);
		}
	
		
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a") 
	public LocalTime getTimeFormat() {
		
		
		if(!time.isEmpty()) {
			 return LocalTime.parse(time,DateTimeFormatter.ofPattern("hh:mm a"));
		}
		else {
			return null;
		}

	

	}
	
	@Transient
	public String getDateTime() {
		
		
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Transient
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
