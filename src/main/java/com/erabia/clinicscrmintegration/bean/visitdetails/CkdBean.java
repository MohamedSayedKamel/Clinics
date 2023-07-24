package com.erabia.clinicscrmintegration.bean.visitdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CkdBean {

	


	
	private String strCkd;
	
	private SerumCreatinineBean serumCreatinineBean;

	

	public final SerumCreatinineBean getSerumCreatinineBean() {
		return serumCreatinineBean;
	}



	public final void setSerumCreatinineBean(SerumCreatinineBean serumCreatinineBean) {
		this.serumCreatinineBean = serumCreatinineBean;
	}

	public String getStrCkd() {
		return strCkd;
	}

	public void setStrCkd(String strCkd) {
		this.strCkd = strCkd;
	}
	
	
}
