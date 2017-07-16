package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.PatientService;

public class PatientServiceImpl extends BaseSercvices implements PatientService {

	public PatientServiceImpl() {
		// em = EntityManagerUtil.getEntityManager();
	}

	public PatientServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void create(PatientDto patient) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Patient patientEnt = new Patient(patient);
		em.persist(patientEnt);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(PatientDto patient) {
		// TODO Auto-generated method stub
		Patient patientEnt = new Patient(patient);
		patientEnt = em.merge(patientEnt);

	}

	@Override
	public Patient findPatientById(int id) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Patient patientDto = (Patient) em.createNamedQuery("findPatientById").setParameter("idPatient", id)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return patientDto;

	}

	@Override
	public List<Patient> findAll() {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		List<Patient> patientLst = (ArrayList<Patient>)em.createQuery("Select p from Patient p").getResultList();
		em.getTransaction().commit();
		em.close();
		return patientLst;
	}

}
