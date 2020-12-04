package project.hospital.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
	List<Medicine> findByMedicine(String medicine);
}
