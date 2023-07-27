package com.goalapa.cacamuca.memberDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import com.goalapa.cacamuca.memberDomain.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * Class : MemberServiceImpl.class
 * Comment : 회원 정보 입력, 변경, 삭제 서비스 메소드 테스트
 * History : 2023.07.24
 * </pre>
 *
 * @author 박성준
 */
@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static Stream<Arguments> getMemberInfo() {
        return Stream.of(
                Arguments.of(
                        "abc998"
                        , "pwd998"
                        , "박성준"
                        , "myrhymetre2@cacamuca.com"
                        , "MEMBER_ROLE"
                        , 1
                        , "한국"
                        , "남자"
                        , false
                        , new BirthDay(LocalDate.parse("2023-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("회원가입")
    void registMember(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt,
                      String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);

        //when
        memberRepository.save(member);

        //then
        Optional<Member> foundMember = memberRepository.findByMemberId(member.getMemberId());
        foundMember.ifPresent(Assertions::assertNotNull);
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("임시비밀번호변경")
    void changeTempPassword(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();
        String originPassword = foundMember.getMemberPwd().generateTemporalPassword();
        foundMember.setMemberPwd(new Password(passwordEncoder.encode(originPassword)));

        //then
        Member expectedMember =  memberRepository.findByMemberId(memberId).get();
        assertDoesNotThrow(
                () -> passwordEncoder.matches(originPassword, expectedMember.getMemberPwd().getMemberPwd())
        );
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("회원정보 닉네임 변경")
    void modifyMemberNickname(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);
        String nickname = "메롱";

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();
        foundMember.setMemberNickname(nickname);

        //then
        Member result = memberRepository.findByMemberId(memberId).get();
        assertEquals(nickname, result.getMemberNickname());
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("회원정보 이메일 변경")
    void modifyMemberEmail(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);
        String email = "spring@cacamuca.store";

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();
        foundMember.setMemberEmail(email);

        //then
        Member result = memberRepository.findByMemberId(memberId).get();
        assertEquals(email, result.getMemberEmail());
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("회원정보 국적 변경")
    void modifyMemberCountry(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);
        String country = "국적";

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();
        foundMember.setMemberCountry(country);

        //then
        Member result = memberRepository.findByMemberId(memberId).get();
        assertEquals(country, result.getMemberCountry());
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("비밀번호 변경")
    void modifyMemberPassword(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {
        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);
        String password = "pwd0001";

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();
        String encodedPassword =  passwordEncoder.encode(password);
        if(memberPwd != null) {
            foundMember.setMemberPwd(new Password(encodedPassword));
        }

        //then
        Member expectedMember =  memberRepository.findByMemberId(memberId).get();
        assertDoesNotThrow(
                () -> passwordEncoder.matches(encodedPassword, expectedMember.getMemberPwd().getMemberPwd())
        );
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("회원탈퇴")
    void secession(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blacklistType, BirthDay memberBirth) {

        //given
        Member member = new Member(memberId, new Password(passwordEncoder.encode(memberPwd)), memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, blacklistType, memberBirth);
        memberRepository.save(member);
        String userInputPassword = "pwd998";

        //when
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        Member foundMember = optionalMember.get();

        String encodedPassword = passwordEncoder.encode(userInputPassword);

        if(passwordEncoder.matches(userInputPassword, encodedPassword)) {
            foundMember.setMemberId(null);
            foundMember.setMemberEmail(null);
            foundMember.setMemberPwd(null);
        }

        //then
        Optional<Member> result = memberRepository.findByMemberId(memberId);
        assertFalse(result.isPresent());
    }
}