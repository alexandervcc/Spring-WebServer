package acc.projman.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

<<<<<<< Updated upstream
=======
import com.fasterxml.jackson.annotation.JsonIgnore;

import acc.projman.validators.UniqueValue;

>>>>>>> Stashed changes
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(name = "employee_seq", allocationSize = 1) 
	private long employee_id;

	@NotNull
	@Size(min = 5,max = 15)
	private String first_name;
	
	@NotNull
	@Size(min = 5,max = 15)
	private String last_name;
	
	@NotNull
	@Email
	//@Column(unique = true,nullable = false)//no repeated emails
	@UniqueValue
	private String email;
	
	//@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	//@JoinColumn(name="fk_project")	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",joinColumns = @JoinColumn(name="employee_id"),
	inverseJoinColumns = @JoinColumn(name="project_id"))
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
