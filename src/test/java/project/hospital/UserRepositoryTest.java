package project.hospital;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.hospital.domain.UserClass;
import project.hospital.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository urepository;

	@Test
	public void createNewUser() {
		UserClass users = new UserClass("lion", "$2y$12$REhu9711ZeCHEOImaNFLvOgYf5ZCVpQl3FJz8FU/NrAaRFQsu6.5C", "USER", "lion@lion.fi");
		urepository.save(users);
		assertNotNull(users);
	}
	
	@Test
	public void findUserByEmail() {
		UserClass users = urepository.findByUsername("user");

		assertThat(users.getEmail()).isEqualTo("user@gmail.com");
	}
	
	@Test
	public void deleteUser() {
		UserClass users = urepository.findByUsername("cat");
		
		urepository.deleteById(users.getUserId());
		assertThat(urepository.count()).isEqualTo(1);
	}
	
}
