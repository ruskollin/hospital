package project.hospital.domain;

import java.util.List;


public interface PatientDAO {
	public void save(Patient patient);

	public Patient findOne(int id); 

	public List<Patient> findAll();
}