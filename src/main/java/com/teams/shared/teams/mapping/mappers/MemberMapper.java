package com.teams.shared.teams.mapping.mappers;

import com.teams.shared.mapping.EnhancedModelMapper;
import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.resource.create.CreateMemberResource;
import com.teams.shared.teams.resource.create.CreateTeamResource;
import com.teams.shared.teams.resource.show.MemberResource;
import com.teams.shared.teams.domain.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.io.Serializable;
import java.util.List;



public class MemberMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public MemberResource toResource(Member memberModel){
        return mapper.map(memberModel,MemberResource.class);
    }

    public Page<MemberResource> toListPageResource(List<Member> MemberModels, Pageable pageable){
        return new PageImpl<>(mapper.mapList(MemberModels,MemberResource.class),pageable,MemberModels.size());
    }

    public Member toModel(CreateMemberResource createMemberResource) {
        return mapper.map(createMemberResource, Member.class);
    }

}
