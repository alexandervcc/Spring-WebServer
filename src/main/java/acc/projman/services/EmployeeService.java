package acc.projman.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepositoryInterf emplRepo;

	public Employee save(Employee employee) {
		return this.emplRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return this.emplRepo.findAll();
	}
	
	public Employee findById(Long id) {
		return emplRepo.findById(id).get();
	}
	
	public void deleteById(Long id) {
		emplRepo.deleteById(id);
	}
		
}
