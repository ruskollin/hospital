package project.hospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.hospital.domain.Category;
import project.hospital.domain.CategoryRepository;
import project.hospital.domain.Patient;
import project.hospital.domain.PatientRepository;
import project.hospital.domain.UserClass;
import project.hospital.domain.UserRepository;

@SpringBootApplication
public class HospitalApplication {
	private static final Logger log = LoggerFactory.getLogger(HospitalApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PatientRepository prepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {

			log.info("save a couple of categories");
			crepository.deleteAll();
			crepository.save(new Category(" "));
			crepository.save(new Category("Ward"));
			crepository.save(new Category("ICU"));
			crepository.save(new Category("Recovered"));
			crepository.save(new Category("Dead"));
			crepository.save(new Category("Home Quarantine"));

			
			log.info("save info of patients");
			prepository.deleteAll();
			prepository.save(new Patient("Argus", "Filch", 22, "Male", "COVID-19 with Asthma", "International Travel", crepository.findByName("Ward").get(0)));
			prepository.save(new Patient("Filius", "Flitwick", 54, "Male", "COVID-19 with Diabetes", "Contact with Known Case", crepository.findByName("ICU").get(0)));
			prepository.save(new Patient("Poppy", "Pomfrey", 32, "Female", "COVID-19", "Workplace Transmission", crepository.findByName("Recovered").get(0)));
			prepository.save(new Patient("Pomona", "Sprout", 42, "Female", "COVID-19", "Community Transmission", crepository.findByName("Dead").get(0)));    
			
		
			log.info("fetch all patients");
			for (Patient patient : prepository.findAll()) {
				log.info(patient.toString());
			}
			
			// Create users: admin/admin user/user
			urepository.deleteAll();
			UserClass user1 = new UserClass("user", "$2b$10$z.dSdN/Yfy.B07U5Qdnh1udOep7FsDTpFca8t9t2SJ/wCHG6VRn/2", "USER", "user@gmail.com");
			UserClass user2 = new UserClass("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@gmail.com");
			urepository.save(user1);
			urepository.save(user2);
		};
	}	
}

