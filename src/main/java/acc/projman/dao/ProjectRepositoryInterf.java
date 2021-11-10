package acc.projman.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import acc.projman.entity.Project;

public interface ProjectRepositoryInterf extends CrudRepository<Project,Long>{
	@Override
	public List<Project> findAll();
	
}
