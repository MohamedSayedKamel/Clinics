package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@Service("visitDetailsResponseConverter")
public class VisitDetailsResponseConverter implements Converter<VisitDetailsResponse, VisitDetailsBean> {

	
	@Autowired
	@Qualifier("healthyBehaviourBeanConverter")
	private Converter<VisitDetailsResponse, HealthyBehaviourBean> healthyBehaviourBeanConverter;

	@Autowired
	@Qualifier("diabetesHistoryBeanConverter")
	private Converter<VisitDetailsResponse, DiabetesHistoryBean> diabetesHistoryBeanConverter;
	

	@Autowired
	@Qualifier("glycemicControlBeanConverter")
	private Converter<VisitDetailsResponse, GlycemicControlBean> glycemicControlBeanConverter;
	
	@Autowired
	@Qualifier("presenceOfAnemiaBeanConverter")
	private Converter<VisitDetailsResponse, PresenceOfAnemiaBean> presenceOfAnemiaBeanConverter;

	@Autowired
	@Qualifier("presenceOfGoutBeanConverter")
	private Converter<VisitDetailsResponse, PresenceOfGoutBean> presenceOfGoutBeanConverter;
	
	@Autowired
	@Qualifier("cvRiskAssessmentAndManagementBeanConverterConverter")
	private Converter<VisitDetailsResponse, CvRiskAssessmentAndManagementBean> cvRiskAssessmentAndManagementBeanConverterConverter;
	
	
	@Autowired
	@Qualifier("ckdBeanConverter")
	private Converter<VisitDetailsResponse, CkdBean> ckdBeanConverter;
	
	@Autowired
	@Qualifier("retinopathyBeanConverter")
	private Converter<VisitDetailsResponse, RetinopathyBean> retinopathyBeanConverter;
	

	@Autowired
	@Qualifier("neuropathyBeanConverter")
	private Converter<VisitDetailsResponse, NeuropathyBean> neuropathyBeanConverter;
	
	@Autowired
	@Qualifier("mentalHealthBeanConverter")
	private Converter<VisitDetailsResponse, MentalHealthBean> mentalHealthBeanConverter;
	
	@Autowired
	@Qualifier("influenzaVaccinationBeanConverter")
	private Converter<VisitDetailsResponse, InfluenzaVaccinationBean> influenzaVaccinationBeanConverter;
	
	

	@Override
	public VisitDetailsBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		VisitDetailsBean target=new VisitDetailsBean();

		target.setHealthyBeahviour(getHealthyBehaviourBeanConverter().convert(source));
		target.setDiabetesHistory(getDiabetesHistoryBeanConverter().convert(source));
		target.setGlycemicControl(getGlycemicControlBeanConverter().convert(source));
		target.setPresenceOfAnemia(getPresenceOfAnemiaBeanConverter().convert(source));
		target.setPresenceOfGout(getPresenceOfGoutBeanConverter().convert(source));
		target.setCvRiskAssessmentAndManagement(getCvRiskAssessmentAndManagementBeanConverterConverter().convert(source));
		target.setCkd(getCkdBeanConverter().convert(source));
		target.setRetinopathy(getRetinopathyBeanConverter().convert(source));
		target.setNeuropathy(getNeuropathyBeanConverter().convert(source));
		target.setMentalHealth(getMentalHealthBeanConverter().convert(source));
		target.setInfluenzaVaccination(getInfluenzaVaccinationBeanConverter().convert(source));

		return target;
	}

	@Override
	public VisitDetailsBean convert(VisitDetailsResponse source, VisitDetailsBean target)
			throws ConversionException {

		return convert(source);
	}

	
	protected final Converter<VisitDetailsResponse, HealthyBehaviourBean> getHealthyBehaviourBeanConverter() {
		return healthyBehaviourBeanConverter;
	}
	

	protected Converter<VisitDetailsResponse, DiabetesHistoryBean> getDiabetesHistoryBeanConverter() {
		return diabetesHistoryBeanConverter;
	}
	
	protected Converter<VisitDetailsResponse, GlycemicControlBean> getGlycemicControlBeanConverter() {
		return glycemicControlBeanConverter;
	}
	
	public Converter<VisitDetailsResponse, PresenceOfAnemiaBean> getPresenceOfAnemiaBeanConverter() {
		return presenceOfAnemiaBeanConverter;
	}
	public Converter<VisitDetailsResponse, PresenceOfGoutBean> getPresenceOfGoutBeanConverter() {
		return presenceOfGoutBeanConverter;
	}

	public Converter<VisitDetailsResponse, CvRiskAssessmentAndManagementBean> getCvRiskAssessmentAndManagementBeanConverterConverter() {
		return cvRiskAssessmentAndManagementBeanConverterConverter;
	}

	public Converter<VisitDetailsResponse, CkdBean> getCkdBeanConverter() {
		return ckdBeanConverter;
	}

	public Converter<VisitDetailsResponse, RetinopathyBean> getRetinopathyBeanConverter() {
		return retinopathyBeanConverter;
	}

	public Converter<VisitDetailsResponse, NeuropathyBean> getNeuropathyBeanConverter() {
		return neuropathyBeanConverter;
	}

	public Converter<VisitDetailsResponse, MentalHealthBean> getMentalHealthBeanConverter() {
		return mentalHealthBeanConverter;
	}

	public Converter<VisitDetailsResponse, InfluenzaVaccinationBean> getInfluenzaVaccinationBeanConverter() {
		return influenzaVaccinationBeanConverter;
	}
	
	
	
}
