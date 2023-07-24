package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.AceInhibitorBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.AntiplateletAgentBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.CvRiskAssessmentAndManagementBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.LipidLoweringTherapyBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.LipidsBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("cvRiskAssessmentAndManagementBeanConverterConverter")
public class CvRiskAssessmentAndManagementBeanConverter implements Converter<VisitDetailsResponse, CvRiskAssessmentAndManagementBean> {

	@Autowired
	@Qualifier("lipidsBeanConverter")
	private Converter<VisitDetailsResponse, LipidsBean> lipidsBeanConverter;
	
	@Autowired
	@Qualifier("lipidLoweringTherapyBeanConverter")
	private Converter<VisitDetailsResponse, LipidLoweringTherapyBean> lipidLoweringTherapyBeanConverter;
	
	@Autowired
	@Qualifier("aceInhibitorBeanConverter")
	private Converter<VisitDetailsResponse, AceInhibitorBean> aceInhibitorBeanConverter;
	
	

	@Autowired
	@Qualifier("antiplateletAgentBeanConverter")
	private Converter<VisitDetailsResponse, AntiplateletAgentBean> antiplateletAgentBeanConverter;

	

	

	@Override
	public CvRiskAssessmentAndManagementBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		CvRiskAssessmentAndManagementBean target = new CvRiskAssessmentAndManagementBean();
		target.setBp1(source.getBp1());
		target.setBp2(source.getBp2());
		target.setBp3(source.getBp3());
		target.setPulse1(source.getPulse1());
		target.setPulse2(source.getPulse2());
		target.setPulse3(source.getPulse3());
		target.setAntihypertensiveDrugs(source.getAntihypertensiveDrugs());
		target.setStrCvdSymptoms(source.getStrCvdSymptoms());
		
		
		target.setLipidsBean(getLipidsBeanConverter().convert(source));
	
		target.setLipidLoweringTherapyBean(getLipidLoweringTherapyBeanConverter().convert(source));
		
		target.setAceInhibitorBean(getAceInhibitorBeanConverter().convert(source));
		
		target.setAntiplateletAgentBean(getAntiplateletAgentBeanConverter().convert(source));
		
		

		return target;
	}

	@Override
	public CvRiskAssessmentAndManagementBean convert(VisitDetailsResponse source, CvRiskAssessmentAndManagementBean target)
			throws ConversionException {

		return convert(source);
	}

	public Converter<VisitDetailsResponse, LipidsBean> getLipidsBeanConverter() {
		return lipidsBeanConverter;
	}

	public Converter<VisitDetailsResponse, LipidLoweringTherapyBean> getLipidLoweringTherapyBeanConverter() {
		return lipidLoweringTherapyBeanConverter;
	}

	public Converter<VisitDetailsResponse, AceInhibitorBean> getAceInhibitorBeanConverter() {
		return aceInhibitorBeanConverter;
	}

	public Converter<VisitDetailsResponse, AntiplateletAgentBean> getAntiplateletAgentBeanConverter() {
		return antiplateletAgentBeanConverter;
	}
	
	
	
}
