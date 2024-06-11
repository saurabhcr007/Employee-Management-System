package ltts.com.jpa;


import org.springframework.data.repository.CrudRepository;

import ltts.com.model.admin;

public interface AdminJPARepository extends CrudRepository<admin, String> {

	admin findByEmail(String username);
	
}
