package com.teams.shared.teams.domain.service;

import com.teams.shared.teams.domain.model.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAll();

    Member getByMemberId(Integer memberId);

    Member saveMember(Member member);


}
