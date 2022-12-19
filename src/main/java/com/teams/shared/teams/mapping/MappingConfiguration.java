package com.teams.shared.teams.mapping;

import com.teams.shared.teams.mapping.mappers.MemberMapper;
import com.teams.shared.teams.mapping.mappers.TeamMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("teamsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TeamMapper teamMapper(){
        return new TeamMapper();
    }

    @Bean
    public MemberMapper memberMapper(){
        return new MemberMapper();
    }
}
