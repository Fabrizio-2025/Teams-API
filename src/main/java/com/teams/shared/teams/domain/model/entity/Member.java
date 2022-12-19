package com.teams.shared.teams.domain.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
    @Id
    private Integer memberId;
    private String memberName;

    @ManyToOne
    @JoinColumn(name = "teamId",nullable = false)
    private Team team;

//http - json
}
