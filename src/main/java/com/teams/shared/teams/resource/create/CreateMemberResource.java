package com.teams.shared.teams.resource.create;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@With
@AllArgsConstructor
public class CreateMemberResource {

    private String memberName;
    private Integer teamId;

}
