package com.springboot.blog.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.User;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
		
		User user = userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "email", username));
		
		
		return user;
	}

}
