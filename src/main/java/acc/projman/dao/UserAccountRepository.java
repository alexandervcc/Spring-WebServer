package acc.projman.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import acc.projman.entity.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{
	@Override
	public List<UserAccount> findAll();
	
	
}
