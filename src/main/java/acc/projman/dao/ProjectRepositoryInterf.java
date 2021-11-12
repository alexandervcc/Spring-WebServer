package acc.projman.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import acc.projman.entity.Project;

public interface ProjectRepositoryInterf extends PagingAndSortingRepository<Project,Long>{
	/*@Override
	public List<Project> findAll();*/
	
}
