package com.teams.shared.teams.controller;

import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.domain.service.TeamService;
import com.teams.shared.teams.mapping.mappers.TeamMapper;
import com.teams.shared.teams.resource.create.CreateTeamResource;
import com.teams.shared.teams.resource.show.TeamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController//link-local
@RequestMapping(value="/teams",produces = "application/json")
public class TeamController {
    private final TeamService teamService;

    private final TeamMapper teamMapper;

    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping
    public Page<TeamResource> getAll(Pageable pageable){
        return teamMapper.toListPageResource(teamService.getAll(), pageable);
    }

    @PostMapping
    public TeamResource createTeamNameIdOnUrl(@RequestBody CreateTeamResource createTeamResource) {
        Team newTeam = teamMapper.toModel(createTeamResource);
        return teamMapper.toResource(teamService.saveTeam(newTeam));

    }


}
