package com.rubypaper.board.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.board.domain.Bmember;

public interface MemberRepository extends CrudRepository<Bmember, String> {

}
