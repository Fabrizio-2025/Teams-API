package com.teams.shared.teams.domain.repository;

import com.teams.shared.teams.domain.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMemberRepository extends JpaRepository<Member,Integer> {
    List<Member> findAllBy();

    Optional<Member> findByMemberId(Integer memberId);


}
