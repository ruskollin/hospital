package project.hospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;
import project.hospital.domain.User;
import project.hospital.domain.UserRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HospitalApplication {
	private static final Logger log = LoggerFactory.getLogger(HospitalApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PatientRepository prepository, UserRepository urepository) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			log.info("save info of patients");
			prepository.save(new Patient("Argus", "Filch", 22, "Male", "COVID-19 with Asthma", "International Travel"));
			prepository.save(new Patient("Filius", "Flitwick", 54, "Male", "COVID-19 with Diabetes", "Contact with Known Case"));
			prepository.save(new Patient("Poppy", "Pomfrey", 32, "Female", "COVID-19", "Workplace Transmission"));
			prepository.save(new Patient("Pomona", "Sprout", 42, "Female", "COVID-19", "Community Transmission"));     
			
			log.info("fetch all patients");
			for (Patient patient : prepository.findAll()) {
				log.info(patient.toString());
			}
			
			// Create users: admin/admin user/user
			User user1 = new User("cat", "$2y$12$REhu9711ZeCHEOImaNFLvOgYf5ZCVpQl3FJz8FU/NrAaRFQsu6.5C", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}	
}

