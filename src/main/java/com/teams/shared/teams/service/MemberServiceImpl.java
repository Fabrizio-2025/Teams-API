package com.teams.shared.teams.service;

import com.teams.shared.mapping.exception.ResourceNotFoundException;
import com.teams.shared.mapping.exception.ResourceValidationException;
import com.teams.shared.teams.domain.model.entity.Member;
import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.domain.repository.IMemberRepository;
import com.teams.shared.teams.domain.service.MemberService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {

    private final IMemberRepository imemberRepository;

    private final String ENTITY;

    private final Validator validator;

    public MemberServiceImpl(IMemberRepository imemberRepository, Validator validator){
        this.imemberRepository = imemberRepository;
        ENTITY = "Members";
        this.validator = validator;
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

    @Override
    public Member saveMember(Member member) {
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return imemberRepository.save(member);
    }

}
