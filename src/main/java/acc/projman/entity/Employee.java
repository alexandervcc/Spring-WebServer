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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name = "employee_seq", allocationSize = 1) 
	private long employee_id;
	private String first_name;
	private String last_name;
	private String email;
	
	//@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	//@JoinColumn(name="fk_project")	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id"))
	@JsonIgnore 
	private List<Project> projects;	
	
	
	public Employee() {}
	
	public Employee(String employeeFirstName, String employeeLastName, String employeeEmail) {
		super();
		this.first_name = employeeFirstName;
		this.last_name = employeeLastName;
		this.email = employeeEmail;
	}

	public long getEmployeeId() {
		return employee_id;
	}

	public void setEmployeeId(long employeeId) {
		this.employee_id = employeeId;
	}

	public String getEmployeeFirstName() {
		return first_name;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.first_name = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return last_name;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.last_name = employeeLastName;
	}

	public String getEmployeeEmail() {
		return email;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.email = employeeEmail;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
	
}
