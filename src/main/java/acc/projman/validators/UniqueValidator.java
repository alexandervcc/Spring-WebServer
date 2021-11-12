package acc.projman.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acc.projman.dao.EmployeeRepositoryInterf;
import acc.projman.entity.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{
	
	@Autowired
	private EmployeeRepositoryInterf emplRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Employee empl=emplRepo.findByEmail(value);
		
		if(empl!=null) {
			return false;
		}else {
			return true;
		}
	}

}
