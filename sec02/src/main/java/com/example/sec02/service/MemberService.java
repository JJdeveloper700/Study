package com.example.sec02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sec02.dao.IMemberDao;
import com.example.sec02.entity.Member;

@Service
public class MemberService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IMemberDao memberDao; 
	
	public void regist(Member member) {
		
		
		
		//폼으로 부터 패스워드 암호화
		String encodedPassword = bCryptPasswordEncoder.encode(member.getPassword());
			member.setPassword(encodedPassword);
			
		//역할부여	
		member.setRole("ROLE_MEMBER");
		
		memberDao.insert(member);
			
			
	}
		
	
		
		
	
}
