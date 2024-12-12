package com.example.sec02.secu;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sec02.entity.Member;

public class CustomUserDetails implements UserDetails {


	private static final long serialVersionUID = 1L;
	
	private Member member; 
	
	public CustomUserDetails(Member member) {     //생성자를 주입한다. 
		this.member=member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collection = new ArrayList<>(); 
		
		collection.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return member.getRole();
			}
		});
		return collection;
		
		//롤을 확인하는 용도
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	public String getRole() {
		return member.getRole();
	}

}
//인증된 사용자 정보를 가지고 있으려고 하는 용도로 클래스를 만들었다! 