package acc.projman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepositoryInterf emplRepo;
	
	@GetMapping("/new")
	public String getEmployeeForm(Model model) {
		Employee e1=new Employee();
		model.addAttribute("employee",e1 );
		return "employees/new_employee";
	}

	@PostMapping("/save")
	public String postProjectForm(Employee employee, Model model) {
		//Save to database
		System.out.print(employee.getEmployeeEmail());
		emplRepo.save(employee);
		//Reedirect-> prevent duplicate submissions
		return "redirect:/employees/new";
	}
	
}
