package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.config.SecurityConfig;
import com.goalapa.cacamuca.memberDomain.query.domain.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * <pre>
 * Class : SecurityConfig.class
 * Comment : Spring Security Test
 * History
 * </pre>
 *
 * @author 박성준
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SecurityConfig.class)
@WebAppConfiguration
public class WithMockUserTests {

//    @Autowired
//    private MessageService messageService;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    @BeforeEach
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @Test
//    @DisplayName("인증 받지 않은 사용자 테스트")
//    public void getMessageUnauthenticated() {
//        Assertions.assertThrows(AuthenticationCredentialsNotFoundException.class, () -> {
//            messageService.getMessage();
//        });
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
//    @DisplayName("인증 받은 사용자 테스트")
//    public void getMessageAuthenticated() {
//        Assertions.assertDoesNotThrow(
//                () -> messageService.getMessage()
//        );
//    }
//
//    @Test
//    @DisplayName("로그인 성공")
//    @WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
//    void login_success() throws Exception {
//        mvc.perform(formLogin("/member/login").user("admin").password("pass"));
//    }
//
//    @Test
//    @DisplayName("로그인 실패")
//    void login_failed() throws Exception {
//
//        mvc.perform(formLogin("/member/login").user("admin").password("pass")).andExpect(unauthenticated());
//    }
//
//    @Test
//    @DisplayName("로그아웃")
//    @WithMockUser(username="admin",roles={"USER","ADMIN"})
//    void test_logout() throws Exception {
//        mvc.perform(logout("/logout"));
//    }
}
