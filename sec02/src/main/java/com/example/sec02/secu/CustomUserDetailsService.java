package com.example.sec02.secu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec02.dao.IMemberDao;
import com.example.sec02.entity.Member;
@Service //누락 조심 꼭 어노테이션 써넣기 
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private IMemberDao memberDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Member member = memberDao.findByUsername(username);
		
		return new CustomUserDetails(member);
	} //loadUserByUsername의 의미: 
	// 기본 생성자가 있을때는 멤버 객체가 들어가 있어야 한다. 

}
