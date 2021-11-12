package acc.projman.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import acc.projman.entity.Employee;
import acc.projman.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPIController {
	@Autowired
	EmployeeService emplServ;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return this.emplServ.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {		
		return emplServ.findById(id);
	}
	
	//POST = NEW RESOURCE
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee postCreateEmployee(@RequestBody @Valid Employee emp) {
		 return emplServ.save(emp);
	}
	
	//PUT = UPDATE RESOURCE
	@PutMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee putUpdateEmployee(@RequestBody @Valid Employee emp) {
		//if emp, has the ID it will UPDATE else it wont
		return emplServ.save(emp);
	}
	
	//PATCH: partial updates
	@PatchMapping(path="/{id}",consumes="application/json")
	public Employee patchPartialUpdate(@PathVariable Long id, @RequestBody @Valid Employee patchEmp) {
		Employee empl= emplServ.findById(id);
		if(patchEmp.getEmployeeEmail()!=null) {
			empl.setEmployeeEmail(patchEmp.getEmployeeEmail());
		}
		if(patchEmp.getEmployeeFirstName()!=null) {
			empl.setEmployeeFirstName(patchEmp.getEmployeeFirstName());
		}
		if(patchEmp.getEmployeeLastName()!=null) {
			empl.setEmployeeLastName(patchEmp.getEmployeeLastName());
		}
		return emplServ.save(empl);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id) {
		try {
			emplServ.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
		}
		
	}
	
	
	
	
	
}
