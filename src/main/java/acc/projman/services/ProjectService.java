package acc.projman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Project;

@Service
public class ProjectService {
	@Autowired
	public ProjectRepositoryInterf projRepo;
	
	public Project save(Project project) {
		return this.projRepo.save(project);
	}
	
	public List<Project> getAll(){
		return this.projRepo.findAll();
	}
}
