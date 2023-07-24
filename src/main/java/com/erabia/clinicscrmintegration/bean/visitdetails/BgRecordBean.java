package com.erabia.clinicscrmintegration.bean.visitdetails;

public class BgRecordBean {


	private float fastingBg;


	private float postPrandialBg;


	private String hypoglycemicEpisodes;

	
	
	public final float getFastingBg() {
		return fastingBg;
	}

	public final float getPostPrandialBg() {
		return postPrandialBg;
	}

	public final String getHypoglycemicEpisodes() {
		return hypoglycemicEpisodes;
	}

	public final void setFastingBg(float fastingBg) {
		this.fastingBg = fastingBg;
	}

	public final void setPostPrandialBg(float postPrandialBg) {
		this.postPrandialBg = postPrandialBg;
	}

	public final void setHypoglycemicEpisodes(String hypoglycemicEpisodes) {
		this.hypoglycemicEpisodes = hypoglycemicEpisodes;
	}
	
	
	
	
}
