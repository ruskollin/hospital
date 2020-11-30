package project.hospital.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

	List<Patient> findByCategory(Category category);
	
	List<Patient> findByFirstName(String firstName);
	
}