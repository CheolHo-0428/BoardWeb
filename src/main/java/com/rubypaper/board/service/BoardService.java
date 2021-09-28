package com.rubypaper.board.service;

import org.springframework.data.domain.Page;

import com.rubypaper.board.domain.Bboard;
import com.rubypaper.board.domain.Search;

public interface BoardService {
	public void insert(Bboard board);
	public void update(Bboard board);
	public void delete(Bboard board);
	public Bboard getBoard(Bboard board);
	public Page<Bboard> getBoardList(Search search);
}
