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

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	private String projectName;
	private String projectStage;//NOSTARTED, COMPLETED, INPROGRESS
	private String projectDesc;
	
	//@OneToMany(mappedBy = "fkProject")	//mapped by attribute at other table
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinTable(name="hist_proj_empl",joinColumns = @JoinColumn(name="fk_project"),
			inverseJoinColumns = @JoinColumn(name="fk_employee"))
	private List<Employee> employees;	//A project has many employees
	
	public Project() {
		 
	}
	
	public Project(String projectName, String projectStage, String projectDesc) {
		super();
		this.projectName = projectName;
		this.projectStage = projectStage;
		this.projectDesc = projectDesc;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
