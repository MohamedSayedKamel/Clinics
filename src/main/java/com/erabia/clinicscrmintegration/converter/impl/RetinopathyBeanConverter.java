package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.DilatedEyeExamBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.RetinopathyBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("retinopathyBeanConverter")
public class RetinopathyBeanConverter implements Converter<VisitDetailsResponse, RetinopathyBean> {

	@Autowired
	@Qualifier("dilatedEyeExamBeanConverter")
	private Converter<VisitDetailsResponse, DilatedEyeExamBean> dilatedEyeExamBeanConverter;

	@Override
	public RetinopathyBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		RetinopathyBean target = new RetinopathyBean();
		target.setDilatedEyeExamBean(getDilatedEyeExamBeanConverter().convert(source));

		return target;
	}

	@Override
	public RetinopathyBean convert(VisitDetailsResponse source, RetinopathyBean target)
			throws ConversionException {

		return convert(source);
	}

	public Converter<VisitDetailsResponse, DilatedEyeExamBean> getDilatedEyeExamBeanConverter() {
		return dilatedEyeExamBeanConverter;
	}

	
}
