package acc.projman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Employee;
import acc.projman.entity.Project;
import acc.projman.services.EmployeeService;
import acc.projman.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/new")
	public String getProjectForm(Model model) {
		Project p1 = new Project();
		List<Employee> listEmpl=employeeService.getAll();
		model.addAttribute("project",p1);
		model.addAttribute("allEmployees", listEmpl);
		
		return "projects/new_project";
	}
	
	@PostMapping("/save/one_to_many")
	public String postProjectFormOneToMany(Project project, @RequestParam List<Long> employees, Model model) {
		projectService.save(project);
		
		/*
		CODE FOR ONE TO MABY RELATIONSHIP
 		Iterable<Employee> chosenEmpl=emplRepo.findAllById(employees);
		for(Employee emp:chosenEmpl) {
			emp.setFkProject(project);
			emplRepo.save(emp);
		}
		 */
		
		
		//Reedirect-> prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
	@PostMapping("/save")
	public String postProjectForm(Project project, Model model) {
		projectService.save(project);
		//Reedirect-> prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
}
