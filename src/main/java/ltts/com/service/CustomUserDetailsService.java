package ltts.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ltts.com.jpa.AdminJPARepository;
import ltts.com.model.admin;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminJPARepository adjpa;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		admin ad = adjpa.findByEmail(username);
//				.orElseThrow(() -> new RuntimeException("Employee Not Found!"));
		return ad;
	}

}