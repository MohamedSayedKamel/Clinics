package com.erabia.clinicscrmintegration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.erabia.clinicscrmintegration.service.ClinicsCRMService;



@RestController
@RequestMapping(path = "/clinics")
public class ClinicsController {
	

	private static final String BASE_URL = "http://178.20.147.67:9090";
	private static final String CLIENT_KEY = "ZYDPLLBWSK3MVQJSIYHB1OR2JXCY0X2C5UJ2QAR2MAAIT5Q00";
	
	
	@Autowired
	@Qualifier("clinicsCRMService")
	private ClinicsCRMService clinicsCRMService;

	
	
	
	@PostMapping(path = "/cities/cities-paging")
	public CitiesResponse getCitiesWithPaging(@RequestBody(required = true) SearchRequestData searchRequestData, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<CitiesResponse> citiesWithPaging = clinicsCRMService.getCitiesWithPaging(BASE_URL, CLIENT_KEY, searchRequestData);
		return citiesWithPaging.isPresent() ? citiesWithPaging.get() : null;
	}
	
	
	
	@GetMapping(path = "/cities/all-cities")
	public List<CityBean> getAllCities(@RequestParam(required = true) Language language, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<List<CityBean>> cities = Optional.ofNullable(clinicsCRMService.getAllCities(BASE_URL, CLIENT_KEY,language));
		return cities.isPresent() ? cities.get() : null;
	}
	
	
	
	@PostMapping(path = "/pharmacies/city-pharmacies-paging")
	public CityPharmaciesResponse getCityPharmaciesWithPaging(@RequestBody(required = true) CityPharmaciesSearchRequestData cityPharmaciesSearchRequestData, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<CityPharmaciesResponse> pharmaciesWithPaging = clinicsCRMService.getCityPharmaciesWithPaging(BASE_URL, CLIENT_KEY,cityPharmaciesSearchRequestData);
		return pharmaciesWithPaging.isPresent() ? pharmaciesWithPaging.get() : null;
	}
	
	
	
	@PostMapping(path = "/pharmacies/all-pharmacies")
	public List<PharmacyBean> getAllCityPharmacies(@RequestBody(required = true) CityAllPharmaciesFilterRequestData cityAllPharmaciesFilterRequestData, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<List<PharmacyBean>> pharmacies = Optional.ofNullable(clinicsCRMService.getAllCityPharmacies(BASE_URL, CLIENT_KEY,cityAllPharmaciesFilterRequestData));
		return pharmacies.isPresent() ? pharmacies.get() : null;
	}
	
	
	
	 
	@GetMapping(path = "/pharmacies/pharmacy-schedule")
	public ScheduleResponse getPharmacySchedule(@RequestParam(required = true) Language language,@RequestParam(required = true) long pharmacyId,@RequestParam(required = true) 	 String appointmentDate, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {

		
		Optional<ScheduleResponse> schedule = clinicsCRMService.getPharmacySchedule(BASE_URL, CLIENT_KEY,language,pharmacyId,appointmentDate);
		return schedule.isPresent() ? schedule.get() : null;
	}
	
	

	@PostMapping(path = "/patient/save-appointment")
	public SaveAppointmentResponse saveAppointment(@RequestParam(required = true) Language language,@RequestParam(required = true) String phoneNumber,@RequestParam(required = true) long pharmacyId,@RequestParam(required = true) String appointmentDate, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey,@RequestParam(required = false) String notes) throws ClinicsException  {

		Optional<SaveAppointmentResponse> appointmentSaved = clinicsCRMService.saveAppointment(BASE_URL, CLIENT_KEY,language,phoneNumber,pharmacyId,appointmentDate,notes);
			
		
		return appointmentSaved.isPresent() ? appointmentSaved.get() : null;
	}
	
	
	

	@GetMapping(path = "/patient/patient-appointments")
	public PatientAppointmentResponse getPatientAppointments(@RequestParam(required = true) Language language,@RequestParam(required = true) boolean isUpcoming,@RequestParam(required = true) String phoneNumber, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<PatientAppointmentResponse> appointments = clinicsCRMService.getPatientAppointments(BASE_URL, CLIENT_KEY,language,isUpcoming,phoneNumber);
		return appointments.isPresent() ? appointments.get() : null;
	}
	
	
	
	
	@PutMapping(path = "/patient/update-appointment")
	public UpdateAppointmentResponse updateAppointment(@RequestParam(required = true) Language language,@RequestParam(required = true) long appointmentId,@RequestParam(required = true) long patientId,@RequestParam(required = true) String appointmentDate, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<UpdateAppointmentResponse> updateAppointment = clinicsCRMService.updateAppointment(BASE_URL, CLIENT_KEY,language,appointmentId,patientId,appointmentDate);
		return updateAppointment.isPresent() ? updateAppointment.get() : null;
	}
	
	
	
	@DeleteMapping(path = "/patient/delete-appointment")
	public DeleteAppointmentResponse deleteAppointment(@RequestParam(required = true) Language language,@RequestParam(required = true) long appointmentId,@RequestParam(required = true) long patientId,@RequestParam(required = false) String phoneNumber, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<DeleteAppointmentResponse> deleteAppointment = clinicsCRMService.deleteAppointment(BASE_URL, CLIENT_KEY,language,appointmentId,patientId,phoneNumber);
		return deleteAppointment.isPresent() ? deleteAppointment.get() : null;
	}
	
	
	
	@PostMapping(path = "/patient/patient-visits-paging")
	public PatientVisitsResponse getPatientVisitsWithPaging(@RequestBody(required = true) PatientVisitsSearchRequestData patientVisitsSearchRequestData, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<PatientVisitsResponse> patientsvisitsPage = clinicsCRMService.getPatientVisitsWithPaging(BASE_URL, CLIENT_KEY,patientVisitsSearchRequestData);
		return patientsvisitsPage.isPresent() ? patientsvisitsPage.get() : null;
	}
	
	
	@GetMapping(path = "/patient/all-patient-visits")
	public List<PatientVisitsBean> getAllPatientVisits(@RequestParam(required = true) Language language,@RequestParam(required = true)String phoneNumber, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<List<PatientVisitsBean>> getAllPatientVisits = Optional.ofNullable(clinicsCRMService.getAllPatientVisits(BASE_URL, CLIENT_KEY,language,phoneNumber));
		return getAllPatientVisits.isPresent() ? getAllPatientVisits.get() : null;
	}
	
	
	
	@GetMapping(path = "/patient/visit-details")
	public VisitDetailsResponse getVisitDetails(@RequestParam(required = true) long visitId,@RequestParam(required = true) Language language, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<VisitDetailsResponse> getVisitDetails = clinicsCRMService.getVisitDetails(BASE_URL, CLIENT_KEY,visitId,language);
		return getVisitDetails.isPresent() ? getVisitDetails.get() : null;
	}
	
	@GetMapping(path = "/patient/visit-details-bean")
	public VisitDetailsBean getVisitDetails2(@RequestParam(required = true) long visitId,@RequestParam(required = true) Language language, @RequestParam(defaultValue = BASE_URL,required = true) String baseUrl,
			@RequestParam(defaultValue = CLIENT_KEY,required = true) String clientKey) throws ClinicsException  {
		
		Optional<VisitDetailsBean> getVisitDetails = clinicsCRMService.getVisitDetailsBean(BASE_URL, CLIENT_KEY,visitId,language);
		return getVisitDetails.isPresent() ? getVisitDetails.get() : null;
	}

}
