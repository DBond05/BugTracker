package com.electratech.WebApp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.electratech.WebApp.bugTrackerModel.SecurityUser;
import com.electratech.WebApp.bugTrackerRepo.UserRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {
	private final UserRepository userRepo;
	
	public JpaUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return userRepo.findByUsername(username)
				.map(SecurityUser::new)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found: " + username));
		
	}

}
