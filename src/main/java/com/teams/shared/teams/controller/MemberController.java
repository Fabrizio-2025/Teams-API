package com.teams.shared.teams.controller;

import com.teams.shared.teams.domain.model.entity.Member;
import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.resource.create.CreateMemberResource;
import com.teams.shared.teams.resource.create.CreateTeamResource;
import com.teams.shared.teams.resource.show.MemberResource;
import com.teams.shared.teams.domain.service.MemberService;
import com.teams.shared.teams.mapping.mappers.MemberMapper;
import com.teams.shared.teams.resource.show.TeamResource;
import com.teams.shared.teams.resource.update.UpdateMemberResource;
import org.modelmapper.internal.bytebuddy.asm.MemberRemoval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public MemberResource createMemberNameIdOnUrl(@RequestBody CreateMemberResource createMemberResource) {
        Member newMember = memberMapper.toModel(createMemberResource);
        return memberMapper.toResource(memberService.saveMember(newMember));

    }

    @PutMapping("{memberId}")
    public MemberResource updateMember(@PathVariable Integer memberId,
                                         @RequestBody UpdateMemberResource resource) {
        return memberMapper.toResource(memberService.updateMember(memberId, memberMapper.toModel(resource)));
    }

}
