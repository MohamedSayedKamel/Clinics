package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("glycemicControlBeanConverter")
public class GlycemicControlBeanConverter implements Converter<VisitDetailsResponse, GlycemicControlBean> {

	@Autowired
	@Qualifier("bgRecordBeanConverter")
	private Converter<VisitDetailsResponse, BgRecordBean> bgRecordBeanConverter;

	@Override
	public GlycemicControlBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		GlycemicControlBean target=new GlycemicControlBean();

		target.setA1cResult(source.getA1cResult());
		try {
			
			target.setA1cTestDate(source.getA1cTestFormat());
		} catch (DateFormattingException e) {

		}
		target.setStrA1cTestDate(source.getStrA1cTestDate());
		target.setAntihyperglycemicMedications(source.getAntihyperglycemicMedications());
		target.setTherapyAdherence(source.getTherapyAdherence());
	
		target.setBgRecordBean(getBgRecordBeanConverter().convert(source));

		return target;
	}

	@Override
	public GlycemicControlBean convert(VisitDetailsResponse source, GlycemicControlBean target)
			throws ConversionException {

		return convert(source);
	}

	
	protected Converter<VisitDetailsResponse, BgRecordBean> getBgRecordBeanConverter() {
		return bgRecordBeanConverter;
	}
}
