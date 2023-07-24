package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.DiabeticFootExamBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.NeuropathyBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("neuropathyBeanConverter")
public class NeuropathyBeanConverter implements Converter<VisitDetailsResponse, NeuropathyBean> {

	@Autowired
	@Qualifier("diabeticFootExamBeanConverter")
	private Converter<VisitDetailsResponse, DiabeticFootExamBean> diabeticFootExamBeanConverter;

	@Override
	public NeuropathyBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		NeuropathyBean target = new NeuropathyBean();
		target.setStrNeuropathySymptoms(source.getStrNeuropathySymptoms());
		
		target.setDiabeticFootExamBean(getDiabeticFootExamBeanConverter().convert(source));

		return target;
	}

	@Override
	public NeuropathyBean convert(VisitDetailsResponse source, NeuropathyBean target)
			throws ConversionException {

		return convert(source);
	}

	public Converter<VisitDetailsResponse, DiabeticFootExamBean> getDiabeticFootExamBeanConverter() {
		return diabeticFootExamBeanConverter;
	}

	
	
}
