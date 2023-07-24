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

@Service("influenzaVaccinationBeanConverter")
public class InfluenzaVaccinationBeanConverter implements Converter<VisitDetailsResponse, InfluenzaVaccinationBean> {

	@Override
	public InfluenzaVaccinationBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		InfluenzaVaccinationBean target =  new InfluenzaVaccinationBean();
		target.setStrInfluenzaVaccination(source.getStrInfluenzaVaccination());
		target.setInfluenzaVaccinationReason(source.getInfluenzaVaccinationReason());
		try {
			target.setInfluenzaVaccinationDate(source.getInfluenzaVaccinationDateFormat());
		} catch (DateFormattingException e) {
			throw new ConversionException(e.getMessage());
		}
		target.setStrInfluenzaVaccinationDate(source.getStrInfluenzaVaccinationDate());

		return target;
	}

	@Override
	public InfluenzaVaccinationBean convert(VisitDetailsResponse source, InfluenzaVaccinationBean target)
			throws ConversionException {

		return convert(source);
	}

}
