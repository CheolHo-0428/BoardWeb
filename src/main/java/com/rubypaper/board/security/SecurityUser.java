package com.rubypaper.board.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.board.domain.Bmember;

public class SecurityUser extends User {
	
	private static final long serialVersionUID = 1L;
	private Bmember member;
	
	public SecurityUser(Bmember member) {
		super(member.getId(), member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString())
			);
		this.member = member;
	}
	
	public Bmember getMember() {
		return member;
	}
}
