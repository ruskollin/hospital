package project.hospital.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientRepository extends PagingAndSortingRepository<Patient, Long> {

	List<Patient> findByCategory(Category category);
		
}