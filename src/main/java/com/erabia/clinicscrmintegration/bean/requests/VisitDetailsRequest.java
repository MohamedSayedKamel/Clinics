package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitDetailsRequest {
	
      @Expose
	  @SerializedName("VisitId")
	  private long visitId;
      @Expose
	  @SerializedName("DevOsVersion")
	  private String devOsVersion;
      @Expose
	  @SerializedName("DevOsName")
	  private String devOsName;
      @Expose
	  @SerializedName("Language")
	  private String language;
      @Expose
	  @SerializedName("DevImei")
	  private String devImei;
	  
      
	  
	public VisitDetailsRequest(long visitId, String language) {
		super();
		this.visitId = visitId;
		this.language = language;
	}
	  
	  

}
