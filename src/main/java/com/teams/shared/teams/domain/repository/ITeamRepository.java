package com.teams.shared.teams.domain.repository;

import com.teams.shared.teams.domain.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITeamRepository extends JpaRepository<Team,Integer> {
    List<Team> findAll();
    Optional<Team> findByTeamId(Integer teamId);

}
