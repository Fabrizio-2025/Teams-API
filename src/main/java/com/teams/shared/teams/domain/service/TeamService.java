package com.teams.shared.teams.domain.service;

import com.teams.shared.teams.domain.model.entity.Team;

import java.util.List;


public interface TeamService {
List<Team> getAll();

Team getByTeamId(Integer teamId);

Team saveTeam(Team team);



}
