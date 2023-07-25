package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.query.domain.service.MessageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class :
 * Comment :
 * History
 * </pre>
 *
 * @author 박성준
 */
public class HelloMessageService implements MessageService {

    @PreAuthorize("authenticated")
    public Authentication getMessage() throws AuthenticationCredentialsNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if(authentication == null) {
            throw new AuthenticationCredentialsNotFoundException("인증받지 않은 사용자입니다.");
        } else {
            return authentication;
        }
    }
}

