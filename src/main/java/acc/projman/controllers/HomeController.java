package acc.projman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Employee;
import acc.projman.entity.Project;

@Controller

public class HomeController {
	@Autowired
	ProjectRepositoryInterf projRepo;
	@Autowired
	EmployeeRepositoryInterf emplRepo;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Project> projList= projRepo.findAll();
		List<Employee> emplList= emplRepo.findAll();
		
		model.addAttribute("projects", projList);
		model.addAttribute("employees", emplList);
		return "main/home";
	}
}
