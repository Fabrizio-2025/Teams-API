package com.teams.shared.teams.service;

import com.teams.shared.mapping.exception.ResourceNotFoundException;
import com.teams.shared.teams.domain.model.entity.Member;
import com.teams.shared.teams.domain.repository.IMemberRepository;
import com.teams.shared.teams.domain.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final IMemberRepository imemberRepository;

    public MemberServiceImpl(IMemberRepository imemberRepository){
        this.imemberRepository = imemberRepository;
    }

    @Override
    public List<Member> getAll(){
        return imemberRepository.findAll();
    }

    @Override
    public Member getByMemberId(Integer memberId){
        return imemberRepository.findByMemberId(memberId).orElseThrow(
                () -> new ResourceNotFoundException("Member not Found")
        );

    }

}
