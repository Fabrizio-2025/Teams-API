package com.teams.shared.teams.resource.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberResource {

    private Integer memberId;

    @NotNull
    @NotBlank
    private String memberName;
    private Integer teamId;
}
