package com.example.sec03.secu;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sec03.entity.Member;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Member member;

	public CustomUserDetails(Member member) {
		this.member = member;
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
