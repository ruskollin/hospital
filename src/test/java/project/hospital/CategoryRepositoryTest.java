package project.hospital;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.hospital.domain.Category;
import project.hospital.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewCategory() {
		Category categories = new Category("False Positive");
		crepository.save(categories);
		
		assertNotNull(categories);
	}
	
	@Test
	public void findCategoryByName() {
		List<Category> categories= crepository.findByName("Ward");

		assertThat(categories.get(0).getName()).isEqualTo("Ward");
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = crepository.findByName("Ward");
		
		crepository.deleteById(categories.get(0).getCategoryId());
		assertThat(crepository.count()).isEqualTo(5);
	}
}
