package acc.projman.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.PagingAndSortingRepository;

import acc.projman.entity.Employee;

@Primary
<<<<<<< Updated upstream
public interface EmployeeRepositoryInterf extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();
}
=======
public interface EmployeeRepositoryInterf extends PagingAndSortingRepository<Employee, Long>{
	
	@Override
	public List<Employee> findAll();
	
	public Employee findByEmail(String value);
	
}
>>>>>>> Stashed changes
