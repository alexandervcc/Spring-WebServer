package acc.projman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acc.projman.dao.UserAccountRepository;
import acc.projman.entity.UserAccount;

@Service
public class UserAccountService {
	@Autowired
	UserAccountRepository userRepo;
	
	public UserAccount save(UserAccount user) {
		return this.userRepo.save(user);
	}
	
}
