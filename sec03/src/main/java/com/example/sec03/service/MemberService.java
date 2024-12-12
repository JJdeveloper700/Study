package com.example.sec03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sec03.dao.IMemberDao;
import com.example.sec03.entity.Member;

@Service
public class MemberService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IMemberDao memberDao;
	
	public void regist(Member member) {
		
		String encodedPassword = bCryptPasswordEncoder.encode(member.getPassword()); 
		member.setPassword(encodedPassword);
		
		
		
		member.setRole("ROLE_MEMBER");
		
		memberDao.regist(member);
		
		
		
	}
}
