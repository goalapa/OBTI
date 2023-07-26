package com.goalapa.cacamuca.memberDomain.query.application.service;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {

    String username() default "abc999";

    String name() default "박성준";

    String password() default "pwd000";

    String authority() default "ROLE_MEMBER";
}
