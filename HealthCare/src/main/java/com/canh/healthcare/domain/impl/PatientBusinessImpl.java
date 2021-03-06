package com.canh.healthcare.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.entity.PatientBillDetails;
import com.canh.healthcare.jpa.entity.PatientRecord;
import com.canh.healthcare.model.PatientBillDetailsDto;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;
import com.canh.healthcare.services.impl.PatientServiceImpl;
import com.canh.healthcare.services.interfaces.PatientService;

public class PatientBusinessImpl implements PatientBusiness {
	PatientService service = new PatientServiceImpl();

	@Override
	public void create(PatientDto patient) {
		// TODO Auto-generated method stub

		service.create(patient);

	}

	@Override
	public void update(PatientDto patientDto) {
		Patient patient = populateDateForPatient(patientDto);
		service.update(patient);

	}

	@Override
	public PatientDto searchPatientById(int id) {
		Patient patient = service.findPatientById(id);
		return populateData(patient);
	}

	@Override
	public List<PatientDto> searchAll() {
		List<Patient> patientLst = service.findAll();
		List<PatientDto> patientDtoLst = new ArrayList<PatientDto>();
		for (Patient patient : patientLst) {
			PatientDto patientDto = populateData(patient);
			patientDtoLst.add(patientDto);
		}
		return patientDtoLst;
	}

	@Override
	public List<PatientDto> searchByName(String name) {
		List<Patient> patientLst = service.findByName(name);
		List<PatientDto> patientDtoLst = new ArrayList<PatientDto>();
		for (Patient patient : patientLst) {
			PatientDto patientDto = populateData(patient);
			patientDtoLst.add(patientDto);
		}
		return patientDtoLst;
	}

	@Override
	public void createPatientRecord(PatientRecordDto patientRecordDto, PatientBillDto patientBillDto) {
		service.createPatientRecord(patientRecordDto, patientBillDto);

	}

	public PatientBillDetails convertToPatientDetail(PatientBillDetailsDto patientDetailDto) {
		PatientBillDetails billDetail = new PatientBillDetails();
		Medicine medicine = new Medicine(patientDetailDto.getMedicine());
		PatientBill patientBill = new PatientBill();
		billDetail.setMedicine(medicine);
		billDetail.setPatientBill(patientBill);
		billDetail.setQuantity(patientDetailDto.getQuantity());
		return billDetail;

	}

	@Override
	public PatientDto searchPatientByMobile(String mobile) {
		Patient patient = service.findPatientByMobile(mobile);
		return populateData(patient);
	}

	public PatientDto populateData(Patient patient) {
		PatientDto patientDto = new PatientDto();
		patientDto.setAddress(patient.getAddress());
		patientDto.setBirthDay(patient.getBirthDay());
		patientDto.setFamilyContact(patient.getFamilyContact());
		patientDto.setFirstDateJoin(patient.getFirstDateJoin());
		patientDto.setId(patient.getId());
		patientDto.setMale(patient.isMale());
		patientDto.setMobile(patient.getMobile());
		patientDto.setName(patient.getName());
		patientDto.setUrgentContact(patient.getUrgentContact());

		return patientDto;
	}

	public Patient populateDateForPatient(PatientDto patientDto) {
		Patient patient = new Patient(patientDto);
		Patient patientRef = new Patient(patientDto);
		for (PatientRecordDto patientRecordDto : patientDto.getPattientRecords()) {
			PatientRecord patientRecord = new PatientRecord(patientRecordDto);
			patientRecord.setPatient(patientRef);
			patient.getPattientRecords().add(patientRecord);
		}

		for (PatientBillDto patientBillDto : patientDto.getPatientBill()) {
			PatientBill patientBill = new PatientBill(patientBillDto);
			patientBill.setPatient(patientRef);
			// PatientBillDetails billDetails = new PatientBillDetails();
			// for(PatientBillDetailsDto patientBillDetailsDto :
			// patientBillDto.getPatientBillDetails()) {
			// billDetails = convertToPatientDetail(patientBillDetailsDto);
			// patientBill.getPatientBillDetails().add(billDetails);
			// }

			patient.getPatientBill().add(patientBill);
		}
		return patient;
	}

}
