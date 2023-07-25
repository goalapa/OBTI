package com.goalapa.cacamuca.config;

import com.goalapa.cacamuca.memberDomain.query.application.service.HelloMessageService;
import com.goalapa.cacamuca.memberDomain.query.domain.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public MessageService messageService() {
        return new HelloMessageService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("login").authenticated()
//                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/member/login")
//                    .failureHandler((request, response, exception) -> {
//                        response.addHeader( "content-Type", "application/json");
//                        response.sendError(400);
//                    })
                    .failureUrl("/member/login?error=true")
                    .defaultSuccessUrl("/")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }
}
