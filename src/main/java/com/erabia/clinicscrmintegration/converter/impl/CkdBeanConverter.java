package com.erabia.clinicscrmintegration.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.BgRecordBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.CkdBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.GlycemicControlBean;
import com.erabia.clinicscrmintegration.bean.visitdetails.SerumCreatinineBean;
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.exception.ConversionException;
import com.erabia.clinicscrmintegration.exception.DateFormattingException;

@Service("ckdBeanConverter")
public class CkdBeanConverter implements Converter<VisitDetailsResponse, CkdBean> {

	@Autowired
	@Qualifier("serumCreatinineBeanConverter")
	private Converter<VisitDetailsResponse, SerumCreatinineBean> serumCreatinineBeanConverter;

	@Override
	public CkdBean convert(VisitDetailsResponse source) throws ConversionException {
		if(source ==null)
		{
			throw new ConversionException("source must not be null!");
		}
		
		CkdBean target = new CkdBean();
		target.setStrCkd(source.getStrCkd());
		
		target.setSerumCreatinineBean(getSerumCreatinineBeanConverter().convert(source));

		return target;
	}

	@Override
	public CkdBean convert(VisitDetailsResponse source, CkdBean target)
			throws ConversionException {

		return convert(source);
	}

	public Converter<VisitDetailsResponse, SerumCreatinineBean> getSerumCreatinineBeanConverter() {
		return serumCreatinineBeanConverter;
	}

	
	
}
