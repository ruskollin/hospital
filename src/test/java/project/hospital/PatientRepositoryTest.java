package project.hospital;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.hospital.domain.CategoryRepository;
import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTest {
	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createPatient() {
		Patient patients = new Patient("Harry", "Potter", 31, "Male", "COVID-19", "International Travel", crepository.findByName("Ward").get(0));
		repository.save(patients);
		
		assertNotNull(patients);
	}
	
	@Test
	public void findByLastNameShouldReturnFirstName() {
		List<Patient> patients = repository.findByLastName("Filch");
		
		assertThat(patients).hasSize(1);
		assertThat(patients.get(0).getFirstName()).isEqualTo("Argus");
	}
	
	@Test
	public void deletePatient() {
		List<Patient> patients = repository.findByLastName("Pomfrey");
		
		repository.deleteById(patients.get(0).getId());
		assertThat(repository.count()).isEqualTo(3);
	}
}