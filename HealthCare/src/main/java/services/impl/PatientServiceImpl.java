package services.impl;

import javax.persistence.EntityManager;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.PatientDto;

import services.interfaces.PatientService;

public class PatientServiceImpl implements PatientService {

	protected EntityManager em;
	public PatientServiceImpl(){
		em = EntityManagerUtil.getEntityManager();
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
	public PatientDto findPatientById(int id) {
		// TODO Auto-generated method stub
		return (PatientDto)em.createNamedQuery("findPatientById")
				.setParameter("idPatient", id)
				.getSingleResult();
	}

}