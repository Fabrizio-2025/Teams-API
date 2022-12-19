package com.teams.shared.mapping;

import com.teams.shared.teams.mapping.mappers.MemberMapper;
import com.teams.shared.teams.mapping.mappers.TeamMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//¿FUNCIONAMIENTO CORRECTO DE UN BEAN?
@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }

}