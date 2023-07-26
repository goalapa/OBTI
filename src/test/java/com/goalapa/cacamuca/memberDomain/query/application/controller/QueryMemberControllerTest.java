package com.goalapa.cacamuca.memberDomain.query.application.controller;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
class QueryMemberControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    private MockMvc mvc;

    private Member member;

    @BeforeTransaction
    public void accountSetup() {
        member = Member.builder()
               .memberId("abc9999")
               .memberPwd(new Password("pwd999"))
               .memberEmail("securityTest@cacamuca.store")
               .memberGrant("ROLE_MEMBER")
               .memberCountry("한국")
               .birthDay(new BirthDay(LocalDate.parse("2023-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
               .build();

        memberRepository.save(member);
    }

    @AfterTransaction
    public void clear() {
        memberRepository.delete(member);
    }

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("로그인 페이지 호출")
    void login() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/member/login"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 페이지 호출")
    void registration() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/member/registration"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("아이디 찾기 페이지 호출")
    void findIdPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/member/find-id-page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("비밀번호 찾기 페이지 호출")
    void findPasswordPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/member/find-password-page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("마이 페이지 호출")
    void findMyPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/my-page")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원목록 페이지 호출")
    void findAdminPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/admin-list")
                        .param("page","0")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("비밀번호 찾기")
    void findMyPasswordPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/my-password")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원탈퇴 페이지 호출")
    void secessionPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/secession")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("아이디 중복되는지 체크, 중복되지 않음")
    void checkIsDuplicatedId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/id/abc9998")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("아이디 중복되는지 체크, 중복됨")
    void checkIsDuplicatedIdFailed() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/id/abc9999")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("아이디 찾기")
    void findId() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/id/find-id")
                        .param("email", "securityTest@cacamuca.store")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("이메일 중복 체크, 중복되지않음")
    void checkDuplicatedEmail() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/email/security@cacamuca.store")
                )
                .andExpect(MockMvcResultMatchers.content().string("true"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("이메일 중복 체크, 중복됨")
    void checkDuplicatedEmailFailed() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/member/email/securityTest@cacamuca.store")
                )
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}