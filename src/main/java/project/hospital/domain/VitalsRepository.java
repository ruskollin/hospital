package project.hospital.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VitalsRepository extends CrudRepository<Vitals, Long>{
	List<Vitals> findByTemp(int temp);
}
