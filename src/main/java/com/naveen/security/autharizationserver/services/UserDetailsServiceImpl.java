package com.naveen.security.autharizationserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naveen.security.autharizationserver.models.AuthUserDetail;
import com.naveen.security.autharizationserver.models.Users;
import com.naveen.security.autharizationserver.repositories.UserDetailRepo;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDetailRepo userDetailsRepo;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<Users> optionalUser = userDetailsRepo.findByUsername(name);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
		
	}

	
	
}
