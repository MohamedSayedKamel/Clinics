package com.erabia.clinicscrmintegration.enums;

public enum Language {
	ENGLISH("english"),
	ARABIC("arabic");

	private String value;

	private Language(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

