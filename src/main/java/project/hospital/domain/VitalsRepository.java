package project.hospital.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VitalsRepository extends CrudRepository <Patient, Long> {
	
	public List <Patient> findByFirstName (String firstName);
}
