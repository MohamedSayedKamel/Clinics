package com.erabia.clinicscrmintegration.bean.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityPharmaciesRequest {
	
	



		@Expose
		@SerializedName("PageNumber")  
		private long pageNumber;
		@Expose
		@SerializedName("PageSize") 
		private long pageSize;
		@Expose
		@SerializedName("PharmacyName")
		private String pharmacyName;
		@Expose
		@SerializedName("PharmacyCode")
		private String pharmacyCode;
		@Expose
		@SerializedName("CityId")
		private String cityId;
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
		
		
		
		public CityPharmaciesRequest() {
			super();
		}


		public CityPharmaciesRequest(long pageNumber, long pageSize, 
				String language) {
			super();
			this.pageNumber = pageNumber;
			this.pageSize = pageSize;
			this.language = language;
		}
		
		
		
		
		
		
		public final String getPharmacyName() {
			return pharmacyName;
		}


		public final String getPharmacyCode() {
			return pharmacyCode;
		}


		public final String getCityId() {
			return cityId;
		}


		public final void setPharmacyName(String pharmacyName) {
			this.pharmacyName = pharmacyName;
		}


		public final void setPharmacyCode(String pharmacyCode) {
			this.pharmacyCode = pharmacyCode;
		}


		public final void setCityId(String cityId) {
			this.cityId = cityId;
		}


		public final long getPageNumber() {
			return pageNumber;
		}
		public final void setPageNumber(long pageNumber) {
			this.pageNumber = pageNumber;
		}
		public final long getPageSize() {
			return pageSize;
		}
		public final void setPageSize(long pageSize) {
			this.pageSize = pageSize;
		}

		public final String getLanguage() {
			return language;
		}
		public final void setLanguage(String language) {
			this.language = language;
		}
		
		
}
