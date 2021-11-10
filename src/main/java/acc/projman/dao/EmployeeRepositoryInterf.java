package acc.projman.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import acc.projman.entity.Employee;

public interface EmployeeRepositoryInterf extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();
}
