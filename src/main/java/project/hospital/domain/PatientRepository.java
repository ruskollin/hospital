package project.hospital.domain;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}