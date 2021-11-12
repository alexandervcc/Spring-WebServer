package acc.projman.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import acc.projman.entity.Employee;
import acc.projman.entity.Project;
import acc.projman.services.EmployeeService;
import acc.projman.services.ProjectService;
import acc.projman.springExamples.Car;

@CrossOrigin(maxAge = 3600)
@Controller
public class HomeController {
	@Value("${version}")
	String ver;
	Car car;
	ProjectService proyServ;
	EmployeeService emplServ;
	

	//Constructor DI
	public HomeController(@Value("${version}") String ver, Car car, ProjectService proyServ, EmployeeService emplServ) {
		super();
		this.ver = ver;
		this.car = car;
		this.proyServ = proyServ;
		this.emplServ = emplServ;
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Project> projList = proyServ.getAll();
		List<Employee> emplList= emplServ.getAll();
		
		model.addAttribute("ver", ver);
		model.addAttribute("projects", projList);
		model.addAttribute("employees", emplList);
		return "main/home";
	}


	
}
