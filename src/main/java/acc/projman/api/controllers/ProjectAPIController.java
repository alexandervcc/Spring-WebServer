package acc.projman.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import acc.projman.entity.Project;
import acc.projman.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectAPIController {
	@Autowired
	ProjectService proyServ;
	

	@GetMapping
	public List<Project> getEmployees(){
		return this.proyServ.getAll();
	}
	
	@GetMapping("/{id}")
	public Project getEmployee(@PathVariable("id") Long id) {		
		return proyServ.findById(id);
		//return emplServ.findById(id).get() -> for no OPTIONAL
	}
	
	//POST = NEW RESOURCE
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project postCreateEmployee(@RequestBody @Valid Project proy) {
		 return proyServ.save(proy);
	}
	
	//PUT = UPDATE RESOURCE
	@PutMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project putUpdateEmployee(@RequestBody @Valid Project proy) {
		//if emp, has the ID it will UPDATE else it wont
		return proyServ.save(proy);
	}
	
	//PATCH: partial updates
	@PatchMapping(path="/{id}",consumes="application/json")
	public Project patchPartialUpdate(@PathVariable Long id, @RequestBody @Valid Project patchProy) {
		Project proy= proyServ.findById(id);
		if(patchProy.getProjectDesc()!=null) {
			proy.setProjectDesc(patchProy.getProjectDesc());
		}
		if(patchProy.getProjectName()!=null) {
			proy.setProjectName(patchProy.getProjectName());
		}
		if(patchProy.getProjectStage()!=null) {
			proy.setProjectStage(patchProy.getProjectStage());
		}
		return proyServ.save(proy);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProject(@PathVariable Long id) {
		try {
			proyServ.delete(id);
		} catch (EmptyResultDataAccessException e) {
			
		}
	}
	
	
	
}
