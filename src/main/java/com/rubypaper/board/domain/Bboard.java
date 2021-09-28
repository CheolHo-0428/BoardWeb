package com.rubypaper.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(exclude = "bmember")
@Entity
public class Bboard {
	
	@Id
	@GeneratedValue
	private Long seq;
	
	private String title;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();
	
	@Column(updatable = false)
	private Long cnt = 0L;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable = false, updatable = false)
	private Bmember bmember;
	
	public void setBmember(Bmember bmember) {
		this.bmember = bmember;
		bmember.getBboardList().add(this);
	}
	
}
