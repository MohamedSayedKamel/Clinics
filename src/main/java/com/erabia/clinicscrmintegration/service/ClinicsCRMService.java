package com.erabia.clinicscrmintegration.service;


import java.util.List;
import java.util.Optional;

import com.erabia.clinicscrmintegration.bean.requests.CityAllPharmaciesFilterRequestData;
import com.erabia.clinicscrmintegration.bean.requests.CityPharmaciesSearchRequestData;
import com.erabia.clinicscrmintegration.bean.requests.PatientVisitsSearchRequestData;
import com.erabia.clinicscrmintegration.bean.requests.SearchRequestData;
import com.erabia.clinicscrmintegration.bean.responses.CitiesResponse;
import com.erabia.clinicscrmintegration.bean.responses.CityBean;
import com.erabia.clinicscrmintegration.bean.responses.CityPharmaciesResponse;
import com.erabia.clinicscrmintegration.bean.responses.DeleteAppointmentResponse;
import com.erabia.clinicscrmintegration.bean.responses.PatientAppointmentResponse;
import com.erabia.clinicscrmintegration.bean.responses.PatientVisitsBean;
import com.erabia.clinicscrmintegration.bean.responses.PatientVisitsResponse;
import com.erabia.clinicscrmintegration.bean.responses.PharmacyBean;
import com.erabia.clinicscrmintegration.bean.responses.SaveAppointmentResponse;
import com.erabia.clinicscrmintegration.bean.responses.ScheduleResponse;
import com.erabia.clinicscrmintegration.bean.responses.UpdateAppointmentResponse;
import com.erabia.clinicscrmintegration.bean.responses.VisitDetailsResponse;
import com.erabia.clinicscrmintegration.bean.visitdetails.VisitDetailsBean;
import com.erabia.clinicscrmintegration.enums.Language;
import com.erabia.clinicscrmintegration.exception.ClinicsException;


public interface ClinicsCRMService {
	
	public Optional<CitiesResponse> getCitiesWithPaging(String baseURL , String clientKey,SearchRequestData searchRequestData)throws ClinicsException;
	public List<CityBean> getAllCities(String baseURL , String clientKey, Language language )throws ClinicsException;
	
	public Optional<CityPharmaciesResponse> getCityPharmaciesWithPaging(String baseURL, String clientKey,CityPharmaciesSearchRequestData cityPharmaciesSearchRequestData )throws ClinicsException;
	public List<PharmacyBean> getAllCityPharmacies(String baseURL , String clientKey, CityAllPharmaciesFilterRequestData allPharmaciesFilterRequestData )throws ClinicsException;
	
	public Optional<ScheduleResponse> getPharmacySchedule(String baseURL, String clientKey,Language language,long pharmacyId,String appointmentDate )throws ClinicsException;
	
	public Optional<SaveAppointmentResponse> saveAppointment(String baseURL, String clientKey, Language language, String phoneNumber,long pharmacyId,String appointmentDate,String notes)throws ClinicsException;
	
	public Optional<PatientAppointmentResponse> getPatientAppointments(String baseURL, String clientKey, Language language,Boolean isUpcoming, String phoneNumber)throws ClinicsException;
	
	public Optional<UpdateAppointmentResponse> updateAppointment(String baseURL, String clientKey, Language language,long appointmentId,long patientId,String appointmentDate)throws ClinicsException;
	
	public Optional<DeleteAppointmentResponse> deleteAppointment(String baseURL, String clientKey, Language language,long appointmentId,long  patientId,String phoneNumber)throws ClinicsException;
	
	public Optional<PatientVisitsResponse> getPatientVisitsWithPaging(String baseURL, String clientKey,PatientVisitsSearchRequestData patientVisitsSearchRequestData)throws ClinicsException;
	
	public List<PatientVisitsBean> getAllPatientVisits(String baseURL, String clientKey,Language language,String phoneNumber)throws ClinicsException;
	
	public Optional<VisitDetailsResponse> getVisitDetails(String baseURL, String clientKey, long visitId,Language language)throws ClinicsException;
	
	public Optional<VisitDetailsBean> getVisitDetailsBean(String baseURL, String clientKey, long visitId,Language language)throws ClinicsException;
	
}
