package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.service.MemberServiceImpl;
import com.goalapa.cacamuca.memberDomain.query.domain.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;

/**
 * <pre>
 * Class :
 * Comment :
 * History
 * </pre>
 *
 * @author 박성준
 */
@SpringBootTest
@ContextConfiguration
@WithMockUser(username="admin",roles={"USER","ADMIN"})
@Transactional
public class WithMockUserTests {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    void init() {}

    @Test()
    public void getMessageUnauthenticated() {
        messageService.getMessage();

        Assertions.assertDoesNotThrow(
                () -> AuthenticationCredentialsNotFoundException.class
        );
    }

    @Test
    @WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
    public void getMessageWithMockUserCustomUser() {
        String message = messageService.getMessage();
    }

    @Test
    @DisplayName("로그인 성공")
    @WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
    void login_success() throws Exception {

        mvc.perform(formLogin("/member/login").user("admin").password("pass"));
    }

    @Test
    @DisplayName("로그인 실패")
    void login_failed() throws Exception {

        mvc.perform(formLogin("/member/login").user("admin").password("pass")).andExpect(unauthenticated());
    }

    @Test
    @DisplayName("로그아웃")
    void test_logout() throws Exception {
        mvc.perform(logout("/logout"));
    }

}
