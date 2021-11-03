package acc.projman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import acc.projman.dao.EmployeeRepositoryInterf;

@Service
public class EmployeeService {
	EmployeeRepositoryInterf emplRepo;
	IStaffRepository stafRepo;
	
	public EmployeeService(EmployeeRepositoryInterf emplRepo, @Qualifier("staffRepositoryImpl1") IStaffRepository stafRepo) {
		super();
		this.emplRepo=emplRepo;
		this.stafRepo=stafRepo;
	}
	
	/*
	@Autowired
	public void setEmplRepo(@Autowired EmployeeRepositoryInterf emplRepo) {
		this.emplRepo=emplRepo;
	}
	*/
}
