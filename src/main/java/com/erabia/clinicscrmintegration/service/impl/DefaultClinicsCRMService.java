package com.erabia.clinicscrmintegration.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erabia.clinicscrmintegration.bean.requests.CitiesRequest;
import com.erabia.clinicscrmintegration.bean.requests.CityAllPharmaciesFilterRequestData;
import com.erabia.clinicscrmintegration.bean.requests.CityPharmaciesRequest;
import com.erabia.clinicscrmintegration.bean.requests.CityPharmaciesSearchRequestData;
import com.erabia.clinicscrmintegration.bean.requests.DeleteAppointmentRequest;
import com.erabia.clinicscrmintegration.bean.requests.PatientAppointmentRequest;
import com.erabia.clinicscrmintegration.bean.requests.PatientVisitsRequest;
import com.erabia.clinicscrmintegration.bean.requests.PatientVisitsSearchRequestData;
import com.erabia.clinicscrmintegration.bean.requests.PharmacyScheduleRequest;
import com.erabia.clinicscrmintegration.bean.requests.SaveAppointmentRequest;
import com.erabia.clinicscrmintegration.bean.requests.SearchRequestData;
import com.erabia.clinicscrmintegration.bean.requests.UpdateAppointmentRequest;
import com.erabia.clinicscrmintegration.bean.requests.VisitDetailsRequest;
import com.erabia.clinicscrmintegration.bean.responses.AbstractResponse;
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
import com.erabia.clinicscrmintegration.converter.Converter;
import com.erabia.clinicscrmintegration.enums.Language;
import com.erabia.clinicscrmintegration.exception.ClinicsException;
import com.erabia.clinicscrmintegration.exception.WebServiceApiUnirestException;
import com.erabia.clinicscrmintegration.exception.enums.ClinicsExceptionType;
import com.erabia.clinicscrmintegration.service.ClinicsCRMService;
import com.erabia.clinicscrmintegration.util.WebServiceApiUnirestUtil;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * Author: Omar Hisham
 *
 */

@Service("clinicsCRMService")
public class DefaultClinicsCRMService implements ClinicsCRMService {

	private static final String BASEURL_IS_NULL = "baseURL is null";
	private static final String CLIENTKEY_IS_NULL = "clientKey is null";
	private static final String LANGUAGE_IS_NULL = "language is null";
	private static final String PAGE_NUMBER_IS_NULL = "pageNumber is null";
	private static final String PAGE_SIZE_IS_NULL = "pageSize is null";
	private static final String PHARMACY_ID_IS_NULL = "pharmacyId is null";
	private static final String APPOINTMENT_DATE_IS_NULL = "appointmentDate is null";
	private static final String PHONE_NUMBER_IS_NULL = "phoneNumber is null";
	private static final String IS_UPCOMING_IS_NULL = "isUpcoming is null";
	private static final String PATIENT_ID_IS_NULL = "patientId is null";
	private static final String APPOINTMENT_ID_IS_NULL = "appointmentId is null";
	private static final String VISIT_ID_IS_NULL = "visitId is null";

	private static final long INITIAL_PAGE_SIZE_FOR_GETALL_CITIES = 10;
	private static final long INITIAL_PAGE_SIZE_FOR_GETALL_PHARMACIES = 100;
	private static final long INITIAL_PAGE_SIZE_FOR_GETALL_VISIST = 150;

	private static final long OK_STATUS_CODE = 10;
	private static final Integer TIMEOUT = 20;
	
	private static final Gson GSON = (new GsonBuilder().setPrettyPrinting()).create();

	private static final Logger LOG = LoggerFactory.getLogger(DefaultClinicsCRMService.class);

	@Autowired
	@Qualifier("visitDetailsResponseConverter")
	private Converter<VisitDetailsResponse, VisitDetailsBean> visitDetailsResponseConverter;

	@Override
	public List<CityBean> getAllCities(String baseURL, String clientKey, Language language) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);

		LOG.info("getAllCities ->sending request");

		CitiesResponse citiesWithPaging = getCitiesWithPaging(baseURL, clientKey,
				new SearchRequestData(0, INITIAL_PAGE_SIZE_FOR_GETALL_CITIES, language)).orElse(null);

		if (citiesWithPaging == null) {
			LOG.info("getAllCities ->Response is empty");
			
			return Collections.emptyList();
		}

		List<CityBean> cities = new ArrayList<>();
		cities.addAll(citiesWithPaging.getCities());

		long totalCount = citiesWithPaging.getTotalCount();
		LOG.info("getAllCities ->total count of cities "+totalCount); 
		if (totalCount <= INITIAL_PAGE_SIZE_FOR_GETALL_CITIES) {
			return cities;
		}
		
		int size = (int) Math.ceil(totalCount / INITIAL_PAGE_SIZE_FOR_GETALL_CITIES);
		LOG.info("getAllCities ->Number of pages is equal "+size);
		for (int pageNumber = 1; pageNumber < size; pageNumber++) {
			citiesWithPaging = getCitiesWithPaging(baseURL, clientKey,
					new SearchRequestData(pageNumber, INITIAL_PAGE_SIZE_FOR_GETALL_CITIES, language)).orElse(null);
			if (citiesWithPaging != null) {
				cities.addAll(citiesWithPaging.getCities());
			}
		}

		return cities;
	}



	@Override
	public Optional<CitiesResponse> getCitiesWithPaging(String baseURL, String clientKey,
			SearchRequestData searchRequestData) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(searchRequestData.getLanguage().toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(searchRequestData.getPageNumber())),
				PAGE_NUMBER_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(searchRequestData.getPageSize())),
				PAGE_SIZE_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/GetCities";

		

		CitiesRequest request = new CitiesRequest(searchRequestData.getPageNumber(), searchRequestData.getPageSize(),
				searchRequestData.getLanguage().getValue());
		request.setLanguage(searchRequestData.getLanguage().getValue());
		
		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);

		LOG.info("start getting cities' page : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);

		CitiesResponse response = null;
		try {
			
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request), CitiesResponse.class);

		} catch (WebServiceApiUnirestException e) {
			
			LOG.error(
					"getCitiesWithPaging  is Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		
		LOG.info("Validating get citiess pages");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);

	}

	@Override
	public Optional<CityPharmaciesResponse> getCityPharmaciesWithPaging(String baseURL, String clientKey,
			CityPharmaciesSearchRequestData cityPharmaciesSearchRequestData) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(cityPharmaciesSearchRequestData.getLanguage().toString()),
				LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(cityPharmaciesSearchRequestData.getPageNumber())),
				PAGE_NUMBER_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(cityPharmaciesSearchRequestData.getPageSize())),
				PAGE_SIZE_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/GetPharamciesCity";

		LOG.info("getting city pharmacies' page");

		CityPharmaciesRequest request = new CityPharmaciesRequest(cityPharmaciesSearchRequestData.getPageNumber(),
				cityPharmaciesSearchRequestData.getPageSize(),
				cityPharmaciesSearchRequestData.getLanguage().getValue());

		if (!cityPharmaciesSearchRequestData.getCityId().isBlank()
				&& !cityPharmaciesSearchRequestData.getCityId().equals("string")) {
			request.setCityId(cityPharmaciesSearchRequestData.getCityId());
		}
		if (!cityPharmaciesSearchRequestData.getPharmacyCode().isBlank()
				&& !cityPharmaciesSearchRequestData.getPharmacyCode().equals("string")) {
			request.setPharmacyCode(cityPharmaciesSearchRequestData.getPharmacyCode());
		}
		if (!cityPharmaciesSearchRequestData.getPharmacyName().isBlank()
				&& !cityPharmaciesSearchRequestData.getPharmacyName().equals("string")) {
			request.setPharmacyName(cityPharmaciesSearchRequestData.getPharmacyName());
		}
		
		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start getting city pharmacies pages : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);

		CityPharmaciesResponse response = null;
		try {
			LOG.info("getCityPharmaciesWithPaging ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),
					CityPharmaciesResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("getCityPharmaciesWithPaging ->bad request");
			
			LOG.error(
					"getCityPharmaciesWithPaging  has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("getCityPharmaciesWithPaging -> Request has been sent successfully.");
		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);

		LOG.info("getCityPharmaciesWithPaging ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);

	}
	@Override
	public List<PharmacyBean> getAllCityPharmacies(String baseURL, String clientKey, CityAllPharmaciesFilterRequestData allPharmaciesFilterRequestData) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(allPharmaciesFilterRequestData.getLanguage().toString()), LANGUAGE_IS_NULL);

		LOG.info("getAllPharmacies ->sending request");
		
		CityPharmaciesSearchRequestData data = new CityPharmaciesSearchRequestData(0, INITIAL_PAGE_SIZE_FOR_GETALL_PHARMACIES, allPharmaciesFilterRequestData.getLanguage());

		data.setCityId(allPharmaciesFilterRequestData.getCityId());
		data.setPharmacyCode(allPharmaciesFilterRequestData.getPharmacyCode());
		data.setPharmacyName(allPharmaciesFilterRequestData.getPharmacyName());
		
		
		CityPharmaciesResponse cityPharmaciesResponse = getCityPharmaciesWithPaging(baseURL, clientKey,data).orElse(null);

		if (cityPharmaciesResponse == null) {
			LOG.info("getAllPharmacies ->Response is empty");
			return Collections.emptyList();
		}

		List<PharmacyBean> pharmacies = new ArrayList<>();
		pharmacies.addAll(cityPharmaciesResponse.getPharmacies());

		long totalCount = cityPharmaciesResponse.getTotalCount();
		LOG.info("getAllPharmacies ->pharmacies total count is "+ totalCount);
		if (totalCount <= INITIAL_PAGE_SIZE_FOR_GETALL_PHARMACIES) {
			return pharmacies;
		}
		
		int size =  (int) Math.ceil(totalCount / INITIAL_PAGE_SIZE_FOR_GETALL_PHARMACIES);
		LOG.info("getAllPharmacies ->pharmacies number of pages is "+ size);
		for (int pageNumber = 1; pageNumber < size; pageNumber++) {
			cityPharmaciesResponse = getCityPharmaciesWithPaging(baseURL, clientKey,
					new CityPharmaciesSearchRequestData(0, INITIAL_PAGE_SIZE_FOR_GETALL_PHARMACIES,allPharmaciesFilterRequestData.getLanguage() )).orElse(null);
			if (cityPharmaciesResponse != null) {
				pharmacies.addAll(cityPharmaciesResponse.getPharmacies());
			}
		}

		return pharmacies;
	}



	@Override
	public Optional<ScheduleResponse> getPharmacySchedule(String baseURL, String clientKey, Language language,
			long pharmacyId, String appointmentDate) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(pharmacyId)), PHARMACY_ID_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(appointmentDate)), APPOINTMENT_DATE_IS_NULL);

		LOG.info("getting pharmacy schedule");

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/GetPharmacySchedule";

		PharmacyScheduleRequest request = new PharmacyScheduleRequest();
		request.setLanguage(language.getValue());
		request.setAppointmentDate(appointmentDate);
		request.setPharmacyId(pharmacyId);

		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start get Pharmacy Schedule : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);
		
		ScheduleResponse response = null;
		try {
			LOG.info("getPharmacySchedule -->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request), ScheduleResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("getPharmacySchedule -> ->bad request");
			LOG.error(
					"get Pharmacy Schedule has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());
		}

		LOG.info("getPharmacySchedule -> ->Request has been sent successfulty.");
		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		LOG.info("getPharmacySchedule -> ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);
	}

	@Override
	public Optional<SaveAppointmentResponse> saveAppointment(String baseURL, String clientKey, Language language,
			String phoneNumber, long pharmacyId, String appointmentDate, String notes) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(pharmacyId)), PHARMACY_ID_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(appointmentDate)), APPOINTMENT_DATE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(phoneNumber)), PHONE_NUMBER_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/SaveAppointment";

		LOG.info(" saving Appointment");

		SaveAppointmentRequest request = new SaveAppointmentRequest(appointmentDate, language.getValue(), pharmacyId,
				phoneNumber);

		if (notes != null) {
			if (!notes.isBlank()) {
				request.setNotes(notes);
			}
		}
		
		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start saving Appointment : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);

		SaveAppointmentResponse response = null;
		try {
			LOG.info("saveAppointment ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),
					SaveAppointmentResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("saveAppointment ->bad request");
			LOG.error(
					"save Appointment has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("saveAppointment -> Request has been sent successfully.");

		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		LOG.info("saveAppointment ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);

	}

	@Override
	public Optional<PatientAppointmentResponse> getPatientAppointments(String baseURL, String clientKey,
			Language language, Boolean isUpcoming, String phoneNumber) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(isUpcoming)), IS_UPCOMING_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(phoneNumber)), PHONE_NUMBER_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/GetPatientAppointment";

		LOG.info("getting patient appointments");

		PatientAppointmentRequest request = new PatientAppointmentRequest();
		request.setLanguage(language.getValue());
		request.setUpcoming(isUpcoming);
		request.setPhoneNumber(phoneNumber);

		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start getting patient appointments : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);
		
		PatientAppointmentResponse response = null;
		try {
			LOG.info("getPatientAppointments ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),
					PatientAppointmentResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("getPatientAppointments ->bad request");
			LOG.error(
					"getting patient appointments has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("getPatientAppointments -> Request has been sent successfully.");

		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		
		LOG.info("getPatientAppointments ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);

	}

	@Override
	public Optional<UpdateAppointmentResponse> updateAppointment(String baseURL, String clientKey, Language language,
			long appointmentId, long patientId, String appointmentDate) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(appointmentId)), APPOINTMENT_ID_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(appointmentDate)), APPOINTMENT_DATE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientId)), PATIENT_ID_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/UpdateAppointment";

		LOG.info("updating patient appointment");

		UpdateAppointmentRequest request = new UpdateAppointmentRequest(appointmentId, patientId, appointmentDate,
				language.getValue());
		
		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start updating patient appointment : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);
		

		UpdateAppointmentResponse response = null;
		try {
			LOG.info("updateAppointment ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),
					UpdateAppointmentResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("updateAppointment ->bad request");
			LOG.error(
					"getting patient appointments has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("updateAppointment -> Request has been sent successfully.");
		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);

		LOG.info("updateAppointment ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);
	}

	@Override
	public Optional<DeleteAppointmentResponse> deleteAppointment(String baseURL, String clientKey, Language language,
			long appointmentId, long patientId, String phoneNumber) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(language.toString()), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(appointmentId)), APPOINTMENT_ID_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(phoneNumber)), PHONE_NUMBER_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientId)), PATIENT_ID_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/DeleteAppointment";

		LOG.info("Deleteing Appointment");

		DeleteAppointmentRequest request = new DeleteAppointmentRequest(appointmentId, patientId, language.getValue());

		if (phoneNumber != null) {
			if (!phoneNumber.isBlank()) {
				request.setPhoneNumber(phoneNumber);
			}
		}
		
		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start Deleteing  appointment : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);

		DeleteAppointmentResponse response = null;
		try {
			LOG.info("deleteAppointment ->sending request");
			response = WebServiceApiUnirestUtil.delete(baseURL, header, GSON.toJson(request),
					DeleteAppointmentResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("deleteAppointment ->bad request");
			LOG.error(
					"Deleteing patient appointments has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("deleteAppointment -> Request has been sent successfully.");
		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		
		LOG.info("deleteAppointment ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);
	}

	@Override
	public Optional<PatientVisitsResponse> getPatientVisitsWithPaging(String baseURL, String clientKey,
			PatientVisitsSearchRequestData patientVisitsSearchRequestData) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientVisitsSearchRequestData.getLanguage())),
				LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientVisitsSearchRequestData.getPageSize())),
				PAGE_SIZE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientVisitsSearchRequestData.getPageNumber())),
				PAGE_NUMBER_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(patientVisitsSearchRequestData.getPhoneNumber())),
				PHONE_NUMBER_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/PatientVisits";

		LOG.info("getting patient visits' page");

		PatientVisitsRequest request = new PatientVisitsRequest(patientVisitsSearchRequestData.getPageNumber(),
				patientVisitsSearchRequestData.getPageSize(), patientVisitsSearchRequestData.getLanguage().getValue(),
				patientVisitsSearchRequestData.getPhoneNumber());

		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start getting patient visits' page : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);
		
		PatientVisitsResponse response = null;
		try {
			LOG.info("getPatientVisitsWithPaging ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),
					PatientVisitsResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("getPatientVisitsWithPaging ->bad request");
			LOG.error(
					"getting patient visits' page has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());

		}

		LOG.info("getPatientVisitsWithPaging -> Request has been sent successfully.");
		
		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);

		LOG.info("getPatientVisitsWithPaging ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);
	}
	@Override
	public List<PatientVisitsBean> getAllPatientVisits(String baseURL, String clientKey, Language language,
			String phoneNumber) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(language)), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(phoneNumber), PHONE_NUMBER_IS_NULL);

		LOG.info("getAllPatientVisits ->sending request");
		
		PatientVisitsSearchRequestData data = new PatientVisitsSearchRequestData(0, INITIAL_PAGE_SIZE_FOR_GETALL_VISIST, language);

		data.setPhoneNumber(phoneNumber);
		
		
		PatientVisitsResponse patientVisitsResponse = getPatientVisitsWithPaging(baseURL, clientKey,data).orElse(null);

		if (patientVisitsResponse == null) {
			LOG.info("getAllPatientVisits ->Response is empty");
			return Collections.emptyList();
		}

		List<PatientVisitsBean> visits = new ArrayList<>();
		visits.addAll(patientVisitsResponse.getVisits());

		long totalCount = patientVisitsResponse.getTotalCount();
		LOG.info("getAllPatientVisits -> visits total count is "+totalCount);
		if (totalCount <= INITIAL_PAGE_SIZE_FOR_GETALL_VISIST) {
			return visits;
		}
		

		int size = (int) Math.ceil(totalCount / INITIAL_PAGE_SIZE_FOR_GETALL_VISIST);
		LOG.info("getAllPatientVisits -> number of pages is  "+size);
		for (int pageNumber = 1; pageNumber < size; pageNumber++) {
			PatientVisitsSearchRequestData requestData=new PatientVisitsSearchRequestData(0, INITIAL_PAGE_SIZE_FOR_GETALL_VISIST,language);
			requestData.setPhoneNumber(phoneNumber);
			patientVisitsResponse = getPatientVisitsWithPaging(baseURL, clientKey,requestData
					).orElse(null);
			if (patientVisitsResponse != null) {
				visits.addAll(patientVisitsResponse.getVisits());
			}
		}

		return visits;
	}



	@Override
	public Optional<VisitDetailsResponse> getVisitDetails(String baseURL, String clientKey, long visitId,
			Language language) throws ClinicsException {

		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(clientKey), CLIENTKEY_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(language)), LANGUAGE_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(String.valueOf(visitId)), VISIT_ID_IS_NULL);

		final Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("ClientKey", clientKey);
		baseURL += "/api/VisitDetails";

		LOG.info("getting patient visit details");

		VisitDetailsRequest request = new VisitDetailsRequest(visitId, language.getValue());

		final String requestData = GSON.toJson(request);
		final String headerData = GSON.toJson(header);
		
		LOG.info("start getting patient visits' details : baseURL[{}],clientKey[{}],headerData[{}],requestData[{}]",
				baseURL, clientKey, headerData, requestData);
		
		VisitDetailsResponse response = null;
		try {
			LOG.info("getVisitDetails ->sending request");
			response = WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request), VisitDetailsResponse.class);

		} catch (WebServiceApiUnirestException e) {
			LOG.info("getVisitDetails ->Bad Request");
			LOG.error(
					"getting patient visits' details has Failed : baseURL[{}],clientKey[{}], headerData[{}],requestData[{}],errorType[{}],errorMsg[{}]",
					baseURL, clientKey, headerData, requestData, ClinicsExceptionType.BAD_REQUEST, e.getMessage());
			
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(),
					e.getResponseData(), e.getHeaders(), e.getBaseURL());
		}

		LOG.info("getVisitDetails -> Request has been sent successfully.");

		final String responseData = GSON.toJson(response);
		
		setAbstractResponseBean(response, baseURL, headerData, requestData, responseData);
		
		LOG.info("getVisitDetails ->validation");

		validateStatus(response, GSON.toJson(request), GSON.toJson(response), GSON.toJson(header), baseURL);

		return Optional.ofNullable(response);

	}

	@Override
	public Optional<VisitDetailsBean> getVisitDetailsBean(String baseURL, String clientKey, long visitId,
			Language language) throws ClinicsException {

		LOG.info("getVisitDetailsBean ->getting visit details");
		final VisitDetailsResponse visitDetails = getVisitDetails(baseURL, clientKey, visitId, language).orElse(null);
		LOG.info("getVisitDetailsBean ->converting visit details");
		return visitDetails == null ? Optional.empty()
				: Optional.ofNullable(getVisitDetailsResponseConverter().convert(visitDetails));
	}

	protected final Converter<VisitDetailsResponse, VisitDetailsBean> getVisitDetailsResponseConverter() {
		return visitDetailsResponseConverter;
	}

	private void validateStatus(AbstractResponse abstractResponse, String request, String response, String header,
			String url) throws ClinicsException {

		if (abstractResponse == null || abstractResponse.getStatusCode() <= 0) {
			
			LOG.info(
					" Result Failed [{}] : baseURL[{}],headerData[{}],requestData[{}],responseData[{}]",
					"bad request", abstractResponse.getBaseUrl(), abstractResponse.getHeaders(), abstractResponse.getRequestData(), abstractResponse.getResponseData());
			throw new ClinicsException(ClinicsExceptionType.BAD_REQUEST, abstractResponse.getMessage(), request,
					response, header, url);
		}
		long statusCode = abstractResponse.getStatusCode();

		if (statusCode ==OK_STATUS_CODE) {
			
			LOG.info(
					"Result  [{}] : baseURL[{}],headerData[{}],requestData[{}],responseData[{}]",
					"success", abstractResponse.getBaseUrl(), abstractResponse.getHeaders(), abstractResponse.getRequestData(), abstractResponse.getResponseData());
			return;
		} else if (ClinicsExceptionType.INVALID_PARAMETERS.getErrorCode() == statusCode) {
			
			LOG.error(
					" Result Failed [{}] : baseURL[{}],headerData[{}],requestData[{}],responseData[{}]",
					"INVALID_PARAMETERS", abstractResponse.getBaseUrl(), abstractResponse.getHeaders(), abstractResponse.getRequestData(), abstractResponse.getResponseData());
			throw new ClinicsException(ClinicsExceptionType.INVALID_PARAMETERS, abstractResponse.getMessage(), request,
					response, header, url);

		} else if (ClinicsExceptionType.INVALID_CLIENT_KEY.getErrorCode() == statusCode) {
			LOG.error(
					" Result  Failed [{}] : baseURL[{}],headerData[{}],requestData[{}],responseData[{}]",
					"INVALID CLIENT KEY", abstractResponse.getBaseUrl(), abstractResponse.getHeaders(), abstractResponse.getRequestData(), abstractResponse.getResponseData());
			throw new ClinicsException(ClinicsExceptionType.INVALID_CLIENT_KEY, abstractResponse.getMessage(), request,
					response, header, url);
		} else {
			LOG.error(
					" Result  Failed [{}] : baseURL[{}],headerData[{}],requestData[{}],responseData[{}]",
					"General error", abstractResponse.getBaseUrl(), abstractResponse.getHeaders(), abstractResponse.getRequestData(), abstractResponse.getResponseData());
			throw new ClinicsException(ClinicsExceptionType.GENERAL_ERROR, abstractResponse.getMessage(), request,
					response, header, url);
		}

	}
	
	
	
	private void setAbstractResponseBean(final AbstractResponse bean, final String baseURL, final String header,
			final String request, final String response)
	{
		bean.setBaseUrl(baseURL);
		bean.setRequestData(request);
		bean.setResponseData(response);
		bean.setHeaders(header);
	}

}
