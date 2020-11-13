package project.hospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;
import project.hospital.domain.UserClass;
import project.hospital.domain.UserRepository;
import project.hospital.domain.Vitals;
import project.hospital.domain.VitalsRepository;

@SpringBootApplication
public class HospitalApplication {
	private static final Logger log = LoggerFactory.getLogger(HospitalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PatientRepository prepository, VitalsRepository vrepository, UserRepository urepository) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			log.info("save info of patients");
			
			prepository.save(new Patient("Argus", "Filch", 22, "Male", "COVID-19 with Asthma", "International Travel"));
			prepository.save(new Patient("Filius", "Flitwick", 54, "Male", "COVID-19 with Diabetes", "Contact with Known Case"));
			prepository.save(new Patient("Poppy", "Pomfrey", 32, "Female", "COVID-19", "Workplace Transmission"));
			prepository.save(new Patient("Pomona", "Sprout", 42, "Female", "COVID-19", "Community Transmission"));     
			
			log.info("vital signs of patients");
			
			vrepository.save(new Vitals("Argus", "Filch", 37.2, 13, 70, 120, 80));
			vrepository.save(new Vitals("Filius", "Flitwick", 36.6, 23, 79, 130, 90));
			vrepository.save(new Vitals("Poppy", "Pomfrey", 37.7, 20, 90, 110, 70));
			vrepository.save(new Vitals("Pomona", "Sprout", 37.5, 17, 85, 100, 70));     
			
			log.info("fetch all patients");
			for (Patient patient : prepository.findAll()) {
				log.info(patient.toString());
			}
			
			// Create users: admin/admin user/user
			urepository.deleteAll();
			UserClass user1 = new UserClass("cat", "$2y$12$REhu9711ZeCHEOImaNFLvOgYf5ZCVpQl3FJz8FU/NrAaRFQsu6.5C", "USER");
			UserClass user2 = new UserClass("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}	
}

