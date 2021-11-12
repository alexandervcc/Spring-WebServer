package acc.projman.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Project;

@Service
public class ProjectService {
	@Autowired
	public ProjectRepositoryInterf projRepo;
	
	public Project save(Project project) {
		return projRepo.save(project);
	}
	
	public List<Project> getAll(){
		List<Project> projects = new ArrayList<Project>();
		projRepo.findAll().forEach(proj->{
			projects.add(proj);
		});
		return projects;
	}

	public Project findById(Long id) {
		return this.projRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		this.projRepo.deleteById(id);
	}
	
}
