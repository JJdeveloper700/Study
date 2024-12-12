package com.example.sec03.secu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec03.dao.IMemberDao;
import com.example.sec03.entity.Member;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private IMemberDao memberDao ;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberDao.findByUsername(username);
		
		return new CustomUserDetails(member);
	}

}
