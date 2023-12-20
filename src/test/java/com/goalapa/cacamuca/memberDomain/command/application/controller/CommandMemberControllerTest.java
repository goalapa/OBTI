package com.goalapa.cacamuca.memberDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
class CommandMemberControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private Member member;

    @Autowired
    private MemberRepository memberRepository;

    private static Stream<Arguments> getMemberInfo() {
        return Stream.of(
                Arguments.of(
                        "abc998"
                        , "pwd000"
                        , "박성준"
                        , "myrhymetre2@cacamuca.com"
                        , "MEMBER_ROLE"
                        , 1
                        , "한국"
                        , "남자"
                        , LocalDate.parse("2023-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                )
        );
    }

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

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @Transactional
    @DisplayName("회원가입")
    void registration(String memberId, String memberPwd, String memberNickName, String memberEmail,
                      String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/member/registration")
                        .param("memberId", memberId)
                        .param("memberPwd", memberPwd)
                        .param("memberNickname", memberNickName)
                        .param("memberEmail", memberEmail)
                        .param("memberCountry", memberCountry)
                        .param("memberGender", memberGender)
                        .param("memberBirth", "2023-07-01")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @Transactional
    @DisplayName("임시비밀번호로 변경")
    void changeTempPassword(String memberId, String memberPwd, String memberNickName, String memberEmail,
                            String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) throws Exception {
        registration(memberId, memberPwd, memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, memberBirth);
        mvc.perform(MockMvcRequestBuilders
                        .post("/member/temp-password")
                        .param("id", memberId)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("회원정보 닉네임 변경 성공")
    void modifyMemberInfoSuccess() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/member/modify")
                        .param("memberNo", String.valueOf(member.getMemberNo()))
                        .param("memberNickName", "바람개비")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.flash().attribute("result", "회원 정보 수정이 완료되었습니다."));
    }

    @Test
    @Transactional
    @DisplayName("회원정보 닉네임 변경 실패")
    void modifyMemberInfoFailed() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/member/modify")
                        .param("memberNickName", "바람개비")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.flash().attribute("result", "잘못된 회원정보 입니다."));
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("회원 비밀번호변경 성공")
    void modifyMemberPasswordSuccess() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/member/password")
                        .param("memberNo", String.valueOf(member.getMemberNo()))
                        .param("memberPwd", "pwd00000")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.flash().attribute("result", "비밀번호 변경이 완료되었습니다."));
    }

    @Test
    @Transactional
    @DisplayName("회원 비밀번호변경 실패")
    void modifyMemberPasswordFailed() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/member/password")
                        .param("memberPwd", "pwd00000")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.flash().attribute("result", "잘못된 회원정보 입니다."));
    }

    @Test
    @Transactional
    @WithUserDetails(value="abc9999", setupBefore = TestExecutionEvent.TEST_EXECUTION)
    @DisplayName("회원탈퇴")
    void secession() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/member/secession")
                )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.flash().attribute("result", "회원탈퇴가 완료되었습니다."));
    }
}