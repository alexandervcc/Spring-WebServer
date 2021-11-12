package acc.projman.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	@SequenceGenerator(name = "project_seq", allocationSize = 1) 
	private long project_id;
	private String name;
	private String stage;//NOSTARTED, COMPLETED, INPROGRESS
	private String description;
	 
	//@OneToMany(mappedBy = "fkProject")	//mapped by attribute at other table
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",joinColumns = @JoinColumn(name="project_id"),
			inverseJoinColumns = @JoinColumn(name="employee_id"))
	@JsonIgnore 
	private List<Employee> employees;	//A project has many employees 
	
	public Project() {
		 
	}
	
	public Project(String projectName, String projectStage, String projectDesc) {
		super();
		this.name = projectName;
		this.stage = projectStage;
		this.description = projectDesc;
	}

	public long getProjectId() {
		return project_id;
	}

	public void setProjectId(long projectId) {
		this.project_id = projectId;
	}

	public String getProjectName() {
		return name;
	}

	public void setProjectName(String projectName) {
		this.name = projectName;
	}

	public String getProjectStage() {
		return stage;
	}

	public void setProjectStage(String projectStage) {
		this.stage = projectStage;
	}

	public String getProjectDesc() {
		return description;
	}

	public void setProjectDesc(String projectDesc) {
		this.description = projectDesc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
