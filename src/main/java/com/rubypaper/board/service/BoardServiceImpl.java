package com.rubypaper.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.board.domain.Bboard;
import com.rubypaper.board.domain.QBboard;
import com.rubypaper.board.domain.Search;
import com.rubypaper.board.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;

	@Override
	public void insert(Bboard board) {
		boardRepo.save(board);
	}

	@Override
	public void update(Bboard board) {
		Bboard findBoard = boardRepo.findById(board.getSeq()).get();

		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void delete(Bboard board) {
		boardRepo.deleteById(board.getSeq());
	}

	@Override
	public Bboard getBoard(Bboard board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public Page<Bboard> getBoardList(Search search) {
		BooleanBuilder builder = new BooleanBuilder();
		QBboard qboard = QBboard.bboard;
		if(search.getSearchCondition().equals("TITLE")) {
			builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%")); 
		} else if(search.getSearchCondition().equals("CONTENT")) {
			builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
		}
		 
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepo.findAll(builder, pageable);
	}
}
