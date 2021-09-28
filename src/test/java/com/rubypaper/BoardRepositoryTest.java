package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rubypaper.board.domain.Bboard;
import com.rubypaper.board.domain.Bmember;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.BoardRepository;
import com.rubypaper.board.persistence.MemberRepository;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	  @Test public void testInsert() { Bmember member1 = new Bmember();
	  member1.setId("member"); member1.setPassword(encoder.encode("member123"));
	  member1.setName("둘리"); member1.setRole(Role.ROLE_MEMBER);
	  member1.setEnabled(true); memberRepo.save(member1);
	  
	  Bmember member2 = new Bmember(); member2.setId("admin");
	  member2.setPassword(encoder.encode("admin123")); member2.setName("도우너");
	  member2.setRole(Role.ROLE_ADMIN); member2.setEnabled(true);
	  memberRepo.save(member2);
	  
	  for (int i = 1; i <= 13; i++) { Bboard board = new Bboard();
	  board.setBmember(member1); board.setTitle(member1.getName() + "가 등록한 게시글" +
	  i); board.setContent(member1.getName() + "가 등록한 게시글" + i);
	  boardRepo.save(board); }
	  
	  for (int i = 1; i <= 3; i++) { Bboard board = new Bboard();
	  board.setBmember(member2); board.setTitle(member2.getName() + "가 등록한 게시글" +
	  i); board.setContent(member2.getName() + "가 등록한 게시글" + i);
	  boardRepo.save(board); } }
	 
	
	/*
	@Test
	public void testGetBoard() {
		Bboard board = boardRepo.findById(1L).get();

		System.out.println(board.getSeq());
		System.out.println(board.getTitle());
		System.out.println(board.getBmember().getName());
		System.out.println(board.getContent());
		System.out.println(board.getCreateDate());
		System.out.println(board.getCnt());
	}
	*/
	
	/*
	 * @Test public void testGetBoardList() { Bmember member =
	 * memberRepo.findById("member").get();
	 * 
	 * System.out.println("[ " + member.getName() + "가 등록한 게시글 ]"); for(Bboard board
	 * : member.getBboardList()) { System.out.println("---> " + board.toString()); }
	 * }
	 */
	
}
