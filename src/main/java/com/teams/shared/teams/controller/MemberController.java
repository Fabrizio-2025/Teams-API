package com.teams.shared.teams.controller;

import com.teams.shared.teams.resource.show.MemberResource;
import com.teams.shared.teams.domain.service.MemberService;
import com.teams.shared.teams.mapping.mappers.MemberMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Members",produces = "application/json")
public class MemberController {

    private final MemberService memberService;

    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,MemberMapper memberMapper){
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    @GetMapping
    public Page<MemberResource> getAll(Pageable pageable){
        return memberMapper.toListPageResource(memberService.getAll(), pageable);
    }

}
