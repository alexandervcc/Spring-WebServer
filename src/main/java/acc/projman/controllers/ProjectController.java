package acc.projman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import acc.projman.dao.ProjectRepositoryInterf;
import acc.projman.entity.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepositoryInterf projRepo;
	
	@GetMapping("/new")
	public String getProjectForm(Model model) {
		Project p1 = new Project();
		model.addAttribute("project",p1);
		return "projects/new_project";
	}
	
	@PostMapping("/save")
	public String postProjectForm(Project project, Model model) {
		//Save to database
		projRepo.save(project);
		//Reedirect-> prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
	
}
