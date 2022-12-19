package com.teams.shared.teams.service;

import com.teams.shared.mapping.exception.ResourceNotFoundException;
import com.teams.shared.mapping.exception.ResourceValidationException;
import com.teams.shared.teams.domain.model.entity.Team;
import com.teams.shared.teams.domain.repository.ITeamRepository;
import com.teams.shared.teams.domain.service.TeamService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {

    private final ITeamRepository iteamRepository;
    private final String ENTITY;
    private final Validator validator;


    public TeamServiceImpl(ITeamRepository iteamRepository, Validator validator) {
        this.iteamRepository = iteamRepository;
        ENTITY = "Teams";
        this.validator = validator;
    }

    @Override
    public List<Team> getAll() {
        return iteamRepository.findAll();
    }

    @Override
    public Team getByTeamId(Integer teamId) {
        return iteamRepository.findByTeamId(teamId).orElseThrow(
                () -> new ResourceNotFoundException("Team not found")
        );
    }

    @Override
    public Team saveTeam(Team team) {
        Set<ConstraintViolation<Team>> violations = validator.validate(team);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return iteamRepository.save(team);
    }


}
