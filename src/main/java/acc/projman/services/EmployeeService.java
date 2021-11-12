package acc.projman.services;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Employee> findById(Long idEmployee) {
		return this.emplRepo.findById(idEmployee);
	}
	
	public void deleteById(Long id) {
		this.emplRepo.deleteById(id);
	}
		
}
