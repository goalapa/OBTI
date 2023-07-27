package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Collection;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        Member member = new Member();
        member.setMemberId(customUser.username());
        member.setMemberPwd(customUser.password());
        member.setMemberGrant("ROLE_MEMBER");

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_MEMBER");

        CustomUser principal =
                new CustomUser(member, (Collection<? extends GrantedAuthority>) authority);

        Authentication auth =
                UsernamePasswordAuthenticationToken.authenticated(principal, "password", principal.getAuthorities());

        context.setAuthentication(auth);
        return context;
    }
}
