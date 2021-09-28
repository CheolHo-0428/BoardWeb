package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.Bboard;
import com.rubypaper.board.domain.Search;
import com.rubypaper.board.security.SecurityUser;
import com.rubypaper.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Search search, Model model) {
		if(search.getSearchCondition() == null){
			search.setSearchCondition("TITLE");
		}
		if(search.getSearchKeyword() == null) {
			search.setSearchKeyword("");
		}
		
		Page<Bboard> getBoardList = boardService.getBoardList(search);
		model.addAttribute("boardList", getBoardList);
		return "board/getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Bboard board, Model model) {
		Bboard getBoard =  boardService.getBoard(board);
		model.addAttribute("board", getBoard);
		return "board/getBoard";
	  }
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Bboard board,
								@AuthenticationPrincipal SecurityUser principal) {
		board.setBmember(principal.getMember());
		boardService.insert(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Bboard board) {
		boardService.update(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Bboard board) {
		boardService.delete(board);
		return "forward:getBoardList";
	}
	
}
