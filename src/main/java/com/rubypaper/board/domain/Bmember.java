package com.rubypaper.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "boardList")
@Entity
public class Bmember {
	
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	
	private String password;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
	
	@OneToMany(mappedBy="bmember", fetch=FetchType.EAGER)
	private List<Bboard> bboardList = new ArrayList<Bboard>();
}
