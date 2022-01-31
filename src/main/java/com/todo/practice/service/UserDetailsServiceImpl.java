package com.todo.practice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.practice.model.Usertable;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userservice;

	public UserDetails loadUserByUsername(String emailaddress) throws UsernameNotFoundException {

		System.out.println("emailaddress is :::\n\n" + emailaddress);

		Usertable loginuser = userservice.findUserbyemailaddress(emailaddress);

		if (loginuser == null) {
			throw new BadCredentialsException("Your ID or Password Is Not Correct.");
		}

		GrantedAuthority authority = new SimpleGrantedAuthority(loginuser.getRole());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				loginuser.getEmailaddress(), loginuser.getPassword(), authorities);

		return userDetails;
	}

}
