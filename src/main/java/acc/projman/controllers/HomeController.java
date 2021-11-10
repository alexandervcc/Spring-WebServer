package acc.projman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Employee;
import acc.projman.entity.Project;
import acc.projman.springExamples.Car;

@Controller

public class HomeController {
	@Value("${version}")
	String ver;
	Car car;
	ProjectRepositoryInterf projRepo;
	EmployeeRepositoryInterf emplRepo;
	
	public HomeController(Car car, ProjectRepositoryInterf projRepo, EmployeeRepositoryInterf emplRepo) {
		this.car=car;
		this.projRepo=projRepo;
		this.emplRepo=emplRepo;
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Project> projList= projRepo.findAll();
		List<Employee> emplList= emplRepo.findAll();
		
		model.addAttribute("ver", ver);
		model.addAttribute("projects", projList);
		model.addAttribute("employees", emplList);
		return "main/home";
	}
}
