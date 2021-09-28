package com.rubypaper.board.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.board.domain.Bboard;

public interface BoardRepository extends CrudRepository<Bboard, Long>, 
										QuerydslPredicateExecutor<Bboard> {
		
		@Query("SELECT b FROM Bboard b")
		Page<Bboard> getBoardList(Pageable pageable);
}
