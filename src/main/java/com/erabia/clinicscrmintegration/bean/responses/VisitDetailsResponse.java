package com.erabia.clinicscrmintegration.bean.responses;

import java.beans.Transient;
import java.time.LocalDateTime;

import com.erabia.clinicscrmintegration.exception.DateFormattingException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitDetailsResponse extends AbstractResponse {

	
	@Expose
	@SerializedName("Id")
	private long id;

	@Expose
	@SerializedName("PatientId")
	private long patientId;

	@Expose
	@SerializedName("DiabetiesTypeId")
	private long diabetiesTypeId;

	@Expose
	@SerializedName("DiabetesType")
	private String diabetesType;

	@Expose
	@SerializedName("Weight")
	private float weight;

	@Expose
	@SerializedName("Height")
	private float height;

	@Expose
	@SerializedName("BMI")
	private float bmi;

	@Expose
	@SerializedName("WaistCircumference")
	private float waistCircumference;

	@Expose
	@SerializedName("NutritionTypeId")
	private long nutritionTypeId;

	@Expose
	@SerializedName("PhysicalActivityTypeId")
	private long physicalActivityTypeId;

	@Expose
	@SerializedName("SmokingStatusId")
	private long smokingStatusId;

	@Expose
	@SerializedName("Comorbidities")
	private String comorbidities;

	@Expose
	@SerializedName("OtherComorbidities")
	private String otherComorbidities;

	@Expose
	@SerializedName("CKDStage")
	private long ckdStage;

	@Expose
	@SerializedName("A1cTestDate")
	private String a1cTestDate;

	@Expose
	@SerializedName("StrA1cTestDate")
	private String strA1cTestDate;

	@Expose
	@SerializedName("A1cResult")
	private String a1cResult;

	@Expose
	@SerializedName("AntihyperglycemicMedications")
	private String antihyperglycemicMedications;

	@Expose
	@SerializedName("TherapyAdherence")
	private String therapyAdherence;

	@Expose
	@SerializedName("FastingBG")
	private float fastingBg;

	@Expose
	@SerializedName("PostPrandialBG")
	private float postPrandialBg;

	@Expose
	@SerializedName("HypoglycemicEpisodes")
	private String hypoglycemicEpisodes;

	@Expose
	@SerializedName("TotalHemoglobin")
	private float totalHemoglobin;

	@Expose
	@SerializedName("UricAcidMeasurement")
	private float uricAcidMeasurement;

	@Expose
	@SerializedName("BP1")
	private String bp1;

	@Expose
	@SerializedName("BP2")
	private String bp2;

	@Expose
	@SerializedName("BP3")
	private String bp3;

	@Expose
	@SerializedName("Pulse1")
	private long pulse1;

	@Expose
	@SerializedName("Pulse2")
	private long pulse2;

	@Expose
	@SerializedName("Pulse3")
	private long pulse3;

	@Expose
	@SerializedName("AntihypertensiveDrugs")
	private String antihypertensiveDrugs;

	@Expose
	@SerializedName("CVDSymptoms")
	private boolean cvdSymptoms;

	@Expose
	@SerializedName("LipidsTG")
	private float lipidsTg;

	@Expose
	@SerializedName("LipidsLDLC")
	private float lipidsLdlc;

	@Expose
	@SerializedName("LipidsNonHDLC")
	private float lipidsNonHdlc;

	@Expose
	@SerializedName("LidpidsTestDate")
	private String lidpidsTestDate;

	@Expose
	@SerializedName("StrLidpidsTestDate")
	private String strLidpidsTestDate;

	@Expose
	@SerializedName("LipidLoweringTherapyTypeId")
	private long lipidLoweringTherapyTypeId;

	@Expose
	@SerializedName("LipidLoweringTherapyReason")
	private String lipidLoweringTherapyReason;

	@Expose
	@SerializedName("LipidLoweringTherapyDrugs")
	private String lipidLoweringTherapyDrugs;

	@Expose
	@SerializedName("ACEInhibitorTypeId")
	private long aceInhibitorTypeId;

	@Expose
	@SerializedName("ACEInhibitorReason")
	private String aceInhibitorReason;

	@Expose
	@SerializedName("ACEInhibitorDrugs")
	private String aceInhibitorDrugs;

	@Expose
	@SerializedName("AntiplateletAgent")
	private boolean antiplateletAgent;

	@Expose
	@SerializedName("AntiplateletAgentDrugs")
	private String antiplateletAgentDrugs;

	@Expose
	@SerializedName("SerumCreatinineTestDate")
	private String serumCreatinineTestDate;

	@Expose
	@SerializedName("StrSerumCreatinineTestDate")
	private String strSerumCreatinineTestDate;

	@Expose
	@SerializedName("SerumCreatinine")
	private float serumCreatinine;

	@Expose
	@SerializedName("CKD")
	private boolean ckd;

	@Expose
	@SerializedName("DilatedEyeExamDate")
	private String dilatedEyeExamDate;

	@Expose
	@SerializedName("StrDilatedEyeExamDate")
	private String strDilatedEyeExamDate;

	@Expose
	@SerializedName("DilatedEyeExamReminded")
	private boolean dilatedEyeExamReminded;

	@Expose
	@SerializedName("Retinopathy")
	private boolean retinopathy;

	@Expose
	@SerializedName("SeverityTherapies")
	private String severityTherapies;

	@Expose
	@SerializedName("NeuropathySymptoms")
	private boolean neuropathySymptoms;

	@Expose
	@SerializedName("DiabeticFootExamSensation")
	private String diabeticFootExamSensation;

	@Expose
	@SerializedName("DiabeticFootExamPulses")
	private String diabeticFootExamPulses;

	@Expose
	@SerializedName("DiabeticFootExamSkin")
	private String diabeticFootExamSkin;

	@Expose
	@SerializedName("DiabeticFootExamOther")
	private String diabeticFootExamOther;

	@Expose
	@SerializedName("Neuropathy")
	private boolean neuropathy;

	@Expose
	@SerializedName("ScreenForDepressionAnxiety")
	private String screenForDepressionAnxiety;

	@Expose
	@SerializedName("InfluenzaVaccination")
	private boolean influenzaVaccination;

	@Expose
	@SerializedName("InfluenzaVaccinationReason")
	private String influenzaVaccinationReason;

	@Expose
	@SerializedName("InfluenzaVaccinationDate")
	private String influenzaVaccinationDate;

	@Expose
	@SerializedName("StrInfluenzaVaccinationDate")
	private String strInfluenzaVaccinationDate;

	@Expose
	@SerializedName("RecallAppointmentGiven")
	private boolean recallAppointmentGiven;

	@Expose
	@SerializedName("NotedInRecallSystem")
	private boolean notedInRecallSystem;

	@Expose
	@SerializedName("CreatedOn")
	private String createdOn;

	@Expose
	@SerializedName("CreatedBy")
	private long createdBy;

	@Expose
	@SerializedName("PharmacyCode")
	private String pharmacyCode;

	@Expose
	@SerializedName("NutritionType")
	private String nutritionType;

	@Expose
	@SerializedName("PhysicalActivityType")
	private String physicalActivityType;

	@Expose
	@SerializedName("SmokingStatus")
	private String smokingStatus;

	@Expose
	@SerializedName("StrCVDSymptoms")
	private String strCvdSymptoms;

	@Expose
	@SerializedName("StrComorbidities")
	private String strComorbidities;

	@Expose
	@SerializedName("LipidLoweringTherapyType")
	private String lipidLoweringTherapyType;

	@Expose
	@SerializedName("ACEInhibitorType")
	private String aceInhibitorType;

	@Expose
	@SerializedName("StrAntiplateletAgent")
	private String strAntiplateletAgent;

	@Expose
	@SerializedName("StrCKD")
	private String strCkd;

	@Expose
	@SerializedName("StrDilatedEyeExamReminded")
	private String strDilatedEyeExamReminded;

	@Expose
	@SerializedName("StrRetinopathy")
	private String strRetinopathy;

	@Expose
	@SerializedName("StrNeuropathySymptoms")
	private String strNeuropathySymptoms;

	@Expose
	@SerializedName("StrNeuropathy")
	private String strNeuropathy;

	@Expose
	@SerializedName("StrInfluenzaVaccination")
	private String strInfluenzaVaccination;

	@Expose
	@SerializedName("StrRecallAppointmentGiven")
	private String strRecallAppointmentGiven;

	@Expose
	@SerializedName("StrNotedInRecallSystem")
	private String strNotedInRecallSystem;

	@Expose
	@SerializedName("DiabetesDateDiagnosed")
	private String diabetesDateDiagnosed;

	@Expose
	@SerializedName("StrDiabetesDateDiagnosed")
	private String strDiabetesDateDiagnosed;

	
	
	
	public VisitDetailsResponse() {
		super();
	}

	public final long getId() {
		return id;
	}

	public final long getPatientId() {
		return patientId;
	}

	public final long getDiabetiesTypeId() {
		return diabetiesTypeId;
	}

	public final String getDiabetesType() {
		return diabetesType;
	}

	public final float getWeight() {
		return weight;
	}

	public final float getHeight() {
		return height;
	}

	public final float getBmi() {
		return bmi;
	}

	public final float getWaistCircumference() {
		return waistCircumference;
	}

	public final long getNutritionTypeId() {
		return nutritionTypeId;
	}

	public final long getPhysicalActivityTypeId() {
		return physicalActivityTypeId;
	}

	public final long getSmokingStatusId() {
		return smokingStatusId;
	}

	public final String getComorbidities() {
		return comorbidities;
	}

	public final String getOtherComorbidities() {
		return otherComorbidities;
	}

	public final long getCkdStage() {
		return ckdStage;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getA1cTestFormat() throws DateFormattingException {

		if (a1cTestDate == null) {
			return null;
		} else {
			LocalDateTime date = LocalDateTime.parse(a1cTestDate);
			return date;
		}


	}

	@Transient
	public final String getA1cTestDate() {
		return a1cTestDate;
	}
	@Transient
	public final String getStrA1cTestDate() {
		return strA1cTestDate;
	}

	public final String getA1cResult() {
		return a1cResult;
	}

	public final String getAntihyperglycemicMedications() {
		return antihyperglycemicMedications;
	}

	public final String getTherapyAdherence() {
		return therapyAdherence;
	}

	public final float getFastingBg() {
		return fastingBg;
	}

	public final float getPostPrandialBg() {
		return postPrandialBg;
	}

	public final String getHypoglycemicEpisodes() {
		return hypoglycemicEpisodes;
	}

	public final float getTotalHemoglobin() {
		return totalHemoglobin;
	}

	public final float getUricAcidMeasurement() {
		return uricAcidMeasurement;
	}

	public final String getBp1() {
		return bp1;
	}

	public final String getBp2() {
		return bp2;
	}

	public final String getBp3() {
		return bp3;
	}

	public final long getPulse1() {
		return pulse1;
	}

	public final long getPulse2() {
		return pulse2;
	}

	public final long getPulse3() {
		return pulse3;
	}

	public final String getAntihypertensiveDrugs() {
		return antihypertensiveDrugs;
	}

	public final boolean isCvdSymptoms() {
		return cvdSymptoms;
	}

	public final float getLipidsTg() {
		return lipidsTg;
	}

	public final float getLipidsLdlc() {
		return lipidsLdlc;
	}

	public final float getLipidsNonHdlc() {
		return lipidsNonHdlc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getLidpidsTestDateFormat() throws DateFormattingException {

		if (lidpidsTestDate == null) {
			return null;
		} else {

			return LocalDateTime.parse(lidpidsTestDate);
		}
	}

	@Transient
	public final String getLidpidsTestDate() {
		return lidpidsTestDate;
	}

	@Transient
	public final String getStrLidpidsTestDate() {
		return strLidpidsTestDate;
	}

	public final long getLipidLoweringTherapyTypeId() {
		return lipidLoweringTherapyTypeId;
	}

	public final String getLipidLoweringTherapyReason() {
		return lipidLoweringTherapyReason;
	}

	public final String getLipidLoweringTherapyDrugs() {
		return lipidLoweringTherapyDrugs;
	}

	public final long getAceInhibitorTypeId() {
		return aceInhibitorTypeId;
	}

	public final String getAceInhibitorReason() {
		return aceInhibitorReason;
	}

	public final String getAceInhibitorDrugs() {
		return aceInhibitorDrugs;
	}

	public final boolean isAntiplateletAgent() {
		return antiplateletAgent;
	}

	public final String getAntiplateletAgentDrugs() {
		return antiplateletAgentDrugs;
	}
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getSerumCreatinineTestDateFormat() throws DateFormattingException {

		if (serumCreatinineTestDate == null) {
			return null;
		} else {

			return LocalDateTime.parse(serumCreatinineTestDate);
		}
	}

	@Transient
	public final String getSerumCreatinineTestDate() {
		return serumCreatinineTestDate;
	}

	@Transient
	public final String getStrSerumCreatinineTestDate() {
		return strSerumCreatinineTestDate;
	}

	public final float getSerumCreatinine() {
		return serumCreatinine;
	}

	public final boolean isCkd() {
		return ckd;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getDilatedEyeExamDateFormat() throws DateFormattingException {

		if (dilatedEyeExamDate == null) {
			return null;
		} else {
			return LocalDateTime.parse(dilatedEyeExamDate);
		}
	}

	@Transient
	public final String getDilatedEyeExamDate() {
		return dilatedEyeExamDate;
	}

	@Transient
	public final String getStrDilatedEyeExamDate() {
		return strDilatedEyeExamDate;
	}

	public final boolean isDilatedEyeExamReminded() {
		return dilatedEyeExamReminded;
	}

	public final boolean isRetinopathy() {
		return retinopathy;
	}

	public final String getSeverityTherapies() {
		return severityTherapies;
	}

	public final boolean isNeuropathySymptoms() {
		return neuropathySymptoms;
	}

	public final String getDiabeticFootExamSensation() {
		return diabeticFootExamSensation;
	}

	public final String getDiabeticFootExamPulses() {
		return diabeticFootExamPulses;
	}

	public final String getDiabeticFootExamSkin() {
		return diabeticFootExamSkin;
	}

	public final String getDiabeticFootExamOther() {
		return diabeticFootExamOther;
	}

	public final boolean isNeuropathy() {
		return neuropathy;
	}

	public final String getScreenForDepressionAnxiety() {
		return screenForDepressionAnxiety;
	}

	public final boolean isInfluenzaVaccination() {
		return influenzaVaccination;
	}

	public final String getInfluenzaVaccinationReason() {
		return influenzaVaccinationReason;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getInfluenzaVaccinationDateFormat() throws DateFormattingException {

		if (influenzaVaccinationDate == null) {
			return null;
		} else {

			return LocalDateTime.parse(influenzaVaccinationDate);
		}
	}

	@Transient
	public final String getInfluenzaVaccinationDate() {
		return influenzaVaccinationDate;
	}

	@Transient
	public final String getStrInfluenzaVaccinationDate() {
		return strInfluenzaVaccinationDate;
	}

	public final boolean isRecallAppointmentGiven() {
		return recallAppointmentGiven;
	}

	public final boolean isNotedInRecallSystem() {
		return notedInRecallSystem;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getCreatedOnFormat() throws DateFormattingException {

		if (createdOn == null) {
			return null;
		} else {

			return LocalDateTime.parse(createdOn);
		}
	}

	@Transient
	public final String getCreatedOn() {
		return createdOn;
	}

	public final long getCreatedBy() {
		return createdBy;
	}

	public final String getPharmacyCode() {
		return pharmacyCode;
	}

	public final String getNutritionType() {
		return nutritionType;
	}

	public final String getPhysicalActivityType() {
		return physicalActivityType;
	}

	public final String getSmokingStatus() {
		return smokingStatus;
	}

	public final String getStrCvdSymptoms() {
		return strCvdSymptoms;
	}

	public final String getStrComorbidities() {
		return strComorbidities;
	}

	public final String getLipidLoweringTherapyType() {
		return lipidLoweringTherapyType;
	}

	public final String getAceInhibitorType() {
		return aceInhibitorType;
	}

	public final String getStrAntiplateletAgent() {
		return strAntiplateletAgent;
	}

	public final String getStrCkd() {
		return strCkd;
	}

	public final String getStrDilatedEyeExamReminded() {
		return strDilatedEyeExamReminded;
	}

	public final String getStrRetinopathy() {
		return strRetinopathy;
	}

	public final String getStrNeuropathySymptoms() {
		return strNeuropathySymptoms;
	}

	public final String getStrNeuropathy() {
		return strNeuropathy;
	}

	public final String getStrInfluenzaVaccination() {
		return strInfluenzaVaccination;
	}

	public final String getStrRecallAppointmentGiven() {
		return strRecallAppointmentGiven;
	}

	public final String getStrNotedInRecallSystem() {
		return strNotedInRecallSystem;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MM,hh:mm a") 
	public LocalDateTime getDiabetesDateDiagnosedFormat() throws DateFormattingException {

		if (diabetesDateDiagnosed == null) {

			return null;
		} else {
			return LocalDateTime.parse(diabetesDateDiagnosed);
		}
	}

	@Transient
	public final String getDiabetesDateDiagnosed() {
		return diabetesDateDiagnosed;
	}

	@Transient
	public final String getStrDiabetesDateDiagnosed() {
		return strDiabetesDateDiagnosed;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public final void setDiabetiesTypeId(long diabetiesTypeId) {
		this.diabetiesTypeId = diabetiesTypeId;
	}

	public final void setDiabetesType(String diabetesType) {
		this.diabetesType = diabetesType;
	}

	public final void setWeight(float weight) {
		this.weight = weight;
	}

	public final void setHeight(float height) {
		this.height = height;
	}

	public final void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public final void setWaistCircumference(float waistCircumference) {
		this.waistCircumference = waistCircumference;
	}

	public final void setNutritionTypeId(long nutritionTypeId) {
		this.nutritionTypeId = nutritionTypeId;
	}

	public final void setPhysicalActivityTypeId(long physicalActivityTypeId) {
		this.physicalActivityTypeId = physicalActivityTypeId;
	}

	public final void setSmokingStatusId(long smokingStatusId) {
		this.smokingStatusId = smokingStatusId;
	}

	public final void setComorbidities(String comorbidities) {
		this.comorbidities = comorbidities;
	}

	public final void setOtherComorbidities(String otherComorbidities) {
		this.otherComorbidities = otherComorbidities;
	}

	public final void setCkdStage(long ckdStage) {
		this.ckdStage = ckdStage;
	}

	public final void setA1cTestDate(String a1cTestDate) {
		this.a1cTestDate = a1cTestDate;
	}

	public final void setStrA1cTestDate(String strA1cTestDate) {
		this.strA1cTestDate = strA1cTestDate;
	}

	public final void setA1cResult(String a1cResult) {
		this.a1cResult = a1cResult;
	}

	public final void setAntihyperglycemicMedications(String antihyperglycemicMedications) {
		this.antihyperglycemicMedications = antihyperglycemicMedications;
	}

	public final void setTherapyAdherence(String therapyAdherence) {
		this.therapyAdherence = therapyAdherence;
	}

	public final void setFastingBg(float fastingBg) {
		this.fastingBg = fastingBg;
	}

	public final void setPostPrandialBg(float postPrandialBg) {
		this.postPrandialBg = postPrandialBg;
	}

	public final void setHypoglycemicEpisodes(String hypoglycemicEpisodes) {
		this.hypoglycemicEpisodes = hypoglycemicEpisodes;
	}

	public final void setTotalHemoglobin(float totalHemoglobin) {
		this.totalHemoglobin = totalHemoglobin;
	}

	public final void setUricAcidMeasurement(float uricAcidMeasurement) {
		this.uricAcidMeasurement = uricAcidMeasurement;
	}

	public final void setBp1(String bp1) {
		this.bp1 = bp1;
	}

	public final void setBp2(String bp2) {
		this.bp2 = bp2;
	}

	public final void setBp3(String bp3) {
		this.bp3 = bp3;
	}

	public final void setPulse1(long pulse1) {
		this.pulse1 = pulse1;
	}

	public final void setPulse2(long pulse2) {
		this.pulse2 = pulse2;
	}

	public final void setPulse3(long pulse3) {
		this.pulse3 = pulse3;
	}

	public final void setAntihypertensiveDrugs(String antihypertensiveDrugs) {
		this.antihypertensiveDrugs = antihypertensiveDrugs;
	}

	public final void setCvdSymptoms(boolean cvdSymptoms) {
		this.cvdSymptoms = cvdSymptoms;
	}

	public final void setLipidsTg(float lipidsTg) {
		this.lipidsTg = lipidsTg;
	}

	public final void setLipidsLdlc(float lipidsLdlc) {
		this.lipidsLdlc = lipidsLdlc;
	}

	public final void setLipidsNonHdlc(float lipidsNonHdlc) {
		this.lipidsNonHdlc = lipidsNonHdlc;
	}

	public final void setLidpidsTestDate(String lidpidsTestDate) {
		this.lidpidsTestDate = lidpidsTestDate;
	}

	public final void setStrLidpidsTestDate(String strLidpidsTestDate) {
		this.strLidpidsTestDate = strLidpidsTestDate;
	}

	public final void setLipidLoweringTherapyTypeId(long lipidLoweringTherapyTypeId) {
		this.lipidLoweringTherapyTypeId = lipidLoweringTherapyTypeId;
	}

	public final void setLipidLoweringTherapyReason(String lipidLoweringTherapyReason) {
		this.lipidLoweringTherapyReason = lipidLoweringTherapyReason;
	}

	public final void setLipidLoweringTherapyDrugs(String lipidLoweringTherapyDrugs) {
		this.lipidLoweringTherapyDrugs = lipidLoweringTherapyDrugs;
	}

	public final void setAceInhibitorTypeId(long aceInhibitorTypeId) {
		this.aceInhibitorTypeId = aceInhibitorTypeId;
	}

	public final void setAceInhibitorReason(String aceInhibitorReason) {
		this.aceInhibitorReason = aceInhibitorReason;
	}

	public final void setAceInhibitorDrugs(String aceInhibitorDrugs) {
		this.aceInhibitorDrugs = aceInhibitorDrugs;
	}

	public final void setAntiplateletAgent(boolean antiplateletAgent) {
		this.antiplateletAgent = antiplateletAgent;
	}

	public final void setAntiplateletAgentDrugs(String antiplateletAgentDrugs) {
		this.antiplateletAgentDrugs = antiplateletAgentDrugs;
	}

	public final void setSerumCreatinineTestDate(String serumCreatinineTestDate) {
		this.serumCreatinineTestDate = serumCreatinineTestDate;
	}

	public final void setStrSerumCreatinineTestDate(String strSerumCreatinineTestDate) {
		this.strSerumCreatinineTestDate = strSerumCreatinineTestDate;
	}

	public final void setSerumCreatinine(float serumCreatinine) {
		this.serumCreatinine = serumCreatinine;
	}

	public final void setCkd(boolean ckd) {
		this.ckd = ckd;
	}

	public final void setDilatedEyeExamDate(String dilatedEyeExamDate) {
		this.dilatedEyeExamDate = dilatedEyeExamDate;
	}

	public final void setStrDilatedEyeExamDate(String strDilatedEyeExamDate) {
		this.strDilatedEyeExamDate = strDilatedEyeExamDate;
	}

	public final void setDilatedEyeExamReminded(boolean dilatedEyeExamReminded) {
		this.dilatedEyeExamReminded = dilatedEyeExamReminded;
	}

	public final void setRetinopathy(boolean retinopathy) {
		this.retinopathy = retinopathy;
	}

	public final void setSeverityTherapies(String severityTherapies) {
		this.severityTherapies = severityTherapies;
	}

	public final void setNeuropathySymptoms(boolean neuropathySymptoms) {
		this.neuropathySymptoms = neuropathySymptoms;
	}

	public final void setDiabeticFootExamSensation(String diabeticFootExamSensation) {
		this.diabeticFootExamSensation = diabeticFootExamSensation;
	}

	public final void setDiabeticFootExamPulses(String diabeticFootExamPulses) {
		this.diabeticFootExamPulses = diabeticFootExamPulses;
	}

	public final void setDiabeticFootExamSkin(String diabeticFootExamSkin) {
		this.diabeticFootExamSkin = diabeticFootExamSkin;
	}

	public final void setDiabeticFootExamOther(String diabeticFootExamOther) {
		this.diabeticFootExamOther = diabeticFootExamOther;
	}

	public final void setNeuropathy(boolean neuropathy) {
		this.neuropathy = neuropathy;
	}

	public final void setScreenForDepressionAnxiety(String screenForDepressionAnxiety) {
		this.screenForDepressionAnxiety = screenForDepressionAnxiety;
	}

	public final void setInfluenzaVaccination(boolean influenzaVaccination) {
		this.influenzaVaccination = influenzaVaccination;
	}

	public final void setInfluenzaVaccinationReason(String influenzaVaccinationReason) {
		this.influenzaVaccinationReason = influenzaVaccinationReason;
	}

	public final void setInfluenzaVaccinationDate(String influenzaVaccinationDate) {
		this.influenzaVaccinationDate = influenzaVaccinationDate;
	}

	public final void setStrInfluenzaVaccinationDate(String strInfluenzaVaccinationDate) {
		this.strInfluenzaVaccinationDate = strInfluenzaVaccinationDate;
	}

	public final void setRecallAppointmentGiven(boolean recallAppointmentGiven) {
		this.recallAppointmentGiven = recallAppointmentGiven;
	}

	public final void setNotedInRecallSystem(boolean notedInRecallSystem) {
		this.notedInRecallSystem = notedInRecallSystem;
	}

	public final void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public final void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public final void setPharmacyCode(String pharmacyCode) {
		this.pharmacyCode = pharmacyCode;
	}

	public final void setNutritionType(String nutritionType) {
		this.nutritionType = nutritionType;
	}

	public final void setPhysicalActivityType(String physicalActivityType) {
		this.physicalActivityType = physicalActivityType;
	}

	public final void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	public final void setStrCvdSymptoms(String strCvdSymptoms) {
		this.strCvdSymptoms = strCvdSymptoms;
	}

	public final void setStrComorbidities(String strComorbidities) {
		this.strComorbidities = strComorbidities;
	}

	public final void setLipidLoweringTherapyType(String lipidLoweringTherapyType) {
		this.lipidLoweringTherapyType = lipidLoweringTherapyType;
	}

	public final void setAceInhibitorType(String aceInhibitorType) {
		this.aceInhibitorType = aceInhibitorType;
	}

	public final void setStrAntiplateletAgent(String strAntiplateletAgent) {
		this.strAntiplateletAgent = strAntiplateletAgent;
	}

	public final void setStrCkd(String strCkd) {
		this.strCkd = strCkd;
	}

	public final void setStrDilatedEyeExamReminded(String strDilatedEyeExamReminded) {
		this.strDilatedEyeExamReminded = strDilatedEyeExamReminded;
	}

	public final void setStrRetinopathy(String strRetinopathy) {
		this.strRetinopathy = strRetinopathy;
	}

	public final void setStrNeuropathySymptoms(String strNeuropathySymptoms) {
		this.strNeuropathySymptoms = strNeuropathySymptoms;
	}

	public final void setStrNeuropathy(String strNeuropathy) {
		this.strNeuropathy = strNeuropathy;
	}

	public final void setStrInfluenzaVaccination(String strInfluenzaVaccination) {
		this.strInfluenzaVaccination = strInfluenzaVaccination;
	}

	public final void setStrRecallAppointmentGiven(String strRecallAppointmentGiven) {
		this.strRecallAppointmentGiven = strRecallAppointmentGiven;
	}

	public final void setStrNotedInRecallSystem(String strNotedInRecallSystem) {
		this.strNotedInRecallSystem = strNotedInRecallSystem;
	}

	public final void setDiabetesDateDiagnosed(String diabetesDateDiagnosed) {
		this.diabetesDateDiagnosed = diabetesDateDiagnosed;
	}

	public final void setStrDiabetesDateDiagnosed(String strDiabetesDateDiagnosed) {
		this.strDiabetesDateDiagnosed = strDiabetesDateDiagnosed;
	}

}
