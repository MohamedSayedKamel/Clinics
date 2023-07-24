package com.erabia.clinicscrmintegration.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.erabia.clinicscrmintegration.exception.ConversionException;

public interface Converter<SOURCE, TARGET> extends org.springframework.core.convert.converter.Converter<SOURCE, TARGET> {
    TARGET convert(SOURCE var1) throws ConversionException;
 
    TARGET convert(SOURCE var1, TARGET var2) throws ConversionException;
 
    default List<TARGET> convertAll(Collection<? extends SOURCE> sources) throws ConversionException {
       if (CollectionUtils.isEmpty(sources)) {
 
          return Collections.emptyList();
 
       } else {
          List<TARGET> result = new ArrayList<>(sources.size());
          Iterator<? extends SOURCE> var3 = sources.iterator();
          while(var3.hasNext()) {
             SOURCE source = (SOURCE) var3.next();
             result.add(this.convert(source));
          }
          return result;
       }
    }
}