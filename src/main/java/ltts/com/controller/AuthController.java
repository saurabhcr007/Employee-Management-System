package ltts.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import ltts.com.model.JwtRequest;
import ltts.com.model.JwtResponse;
import ltts.com.model.admin;
import ltts.com.security.JwtHelper;
import ltts.com.service.EMSService;
import ltts.com.service.EMSServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AuthController {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private EMSServiceImpl service;

	@Autowired
	private JwtHelper helper;

//	private Logger loginuser = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

		this.doAuthenticate(request.getEmail(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = new JwtResponse(token, userDetails.getUsername());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}
	
	@PostMapping("/add")
	public boolean AddAdmin(@RequestBody admin ad) {
		if(service.addadmin(ad)) {
			return true;
		}
		
		return false;
	}
	
}
