package acc.projman.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import acc.projman.ProjManApplication;
import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Project;

//@ContextConfiguration(classes=ProjManApplication.class)
@SpringBootTest
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)	//Needed for JUnit5 Tests
//@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql","classpath:data.sql"}),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class ProjectRepoIntegrationTest {

	@Autowired
	ProjectRepositoryInterf projRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("Project 01","COMPLETE","Project 01");
		projRepo.save(newProject);
		
		assertEquals(5, projRepo.findAll().size());
	}
	
	
}
