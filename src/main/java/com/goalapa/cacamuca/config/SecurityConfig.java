package com.goalapa.cacamuca.config;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.model.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfiguration  {

    private final AuthenticationService authenticationService;


}
