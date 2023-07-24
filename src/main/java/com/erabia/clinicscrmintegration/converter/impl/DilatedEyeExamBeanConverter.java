package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.AceInhibitorBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.AntiplateletAgentBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.CkdBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.CvRiskAssessmentAndManagementBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.DiabetesHistoryBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.DiabeticFootExamBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.DilatedEyeExamBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.HealthyBehaviourBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.InfluenzaVaccinationBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.LipidLoweringTherapyBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.LipidsBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.MentalHealthBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.NeuropathyBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.PresenceOfAnemiaBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.PresenceOfGoutBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.RetinopathyBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.SerumCreatinineBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.VisitDetailsBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("dilatedEyeExamBeanConverter")
public class DilatedEyeExamBeanConverter implements Converter<VisitDetailsResponse, DilatedEyeExamBean> {

	@Override
	public DilatedEyeExamBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		DilatedEyeExamBean target =  new DilatedEyeExamBean();
		try {
			target.setDilatedEyeExamDate(source.getDilatedEyeExamDateFormat());
		} catch (DateFormattingException e) {
			throw new ConversionException(e.getMessage());
		}
		target.setStrDilatedEyeExamReminded(source.getStrDilatedEyeExamReminded());
		target.setStrRetinopathy(source.getStrRetinopathy());
		target.setSeverityTherapies(source.getSeverityTherapies());
		target.setStrDilatedEyeExamDate(source.getStrDilatedEyeExamDate());
		return target;
	}

	@Override
	public DilatedEyeExamBean convert(VisitDetailsResponse source, DilatedEyeExamBean target)
			throws ConversionException {

		return convert(source);
	}

}
