package com.teams.shared.teams.mapping.mappers;

import com.teams.shared.mapping.EnhancedModelMapper;
import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.resource.create.CreateTeamResource;
import com.teams.shared.teams.resource.show.TeamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TeamMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public TeamResource toResource(Team teamModel){
    return mapper.map(teamModel,TeamResource.class);
    }

    public Page<TeamResource> toListPageResource(List<Team> TeamModels, Pageable pageable){
        return new PageImpl<>(mapper.mapList(TeamModels,TeamResource.class),pageable,TeamModels.size());
    }

    public Team toModel(CreateTeamResource createTeamResource) {
        return mapper.map(createTeamResource, Team.class);
    }

}
