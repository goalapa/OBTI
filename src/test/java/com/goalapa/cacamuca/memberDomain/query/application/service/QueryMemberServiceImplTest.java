package com.goalapa.cacamuca.memberDomain.query.application.service;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.memberDomain.query.domain.repository.MemberMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * Class : QueryMemberServiceImpl.class
 * Comment : QueryMemberServiceImpl.class 메소드 단위테스트
 * History 2023.07.24
 * </pre>
 *
 * @author 박성준
 */
@SpringBootTest
@Transactional
class QueryMemberServiceImplTest {

    private static Stream<Arguments> getMemberInfo() {
        return Stream.of(
                Arguments.of(
                        "abc998"
                        , "uKNb4nk6g4RFUsxDYyZO6UTbdvotNsOJPmvUM/E2O7gMVguv7Cu"
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

    @Autowired
    private MemberMapper memberMapper;

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("아이디 중복체크")
    void checkIsDuplicatedId(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) {
        //given
        Member member1 = new Member(memberId, memberPwd, memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, memberBirth);
        memberMapper.insertMember(member1);
        Member member2 = new Member("abc998", "uKNb4nk6g4RFUsxDYyZO6UTbdvotNsOJPmvUM/E2O7gMVguv7Cu", "박성준", "myrhymetre1cacamuca.com", "MEMBER_ROLE"
                , 1, "한국", "남자", LocalDate.parse("2023-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //when
        Member foundMember = memberMapper.findByMemberId(member2.getMemberId());

        //then
        if(foundMember != null) {
            Assertions.assertEquals(member2.getMemberId(), foundMember.getMemberId());      //id 중복
        } else {
            Assertions.assertNull(foundMember);     //id 중복 x
        }
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("이메일 중복체크")
    void checkIsDuplicatedEmail(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) {
        //given
        Member member1 = new Member(memberId, memberPwd, memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, memberBirth);
        memberMapper.insertMember(member1);
        Member member2 = new Member("abc998", "uKNb4nk6g4RFUsxDYyZO6UTbdvotNsOJPmvUM/E2O7gMVguv7Cu", "박성준", "myrhymetre1cacamuca.com", "MEMBER_ROLE"
                , 1, "한국", "남자", LocalDate.parse("2023-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //when
        Member foundMember = memberMapper.findByMemberEmail(member2.getMemberEmail());

        //then
        if(foundMember != null) {
            Assertions.assertEquals(member2.getMemberId(), foundMember.getMemberId());      //email 중복
        } else {
            Assertions.assertNull(foundMember);     //email 중복 x
        }
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("아이디 조회")
    void findId(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) {
        //given
        Member member = new Member(memberId, memberPwd, memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, memberBirth);
        memberMapper.insertMember(member);

        //when
        Member foundMember = memberMapper.findByMemberId(memberId);

        //then
        Assertions.assertNotNull(foundMember);
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @DisplayName("아이디 목록 조회")
    void findMemberList(String memberId, String memberPwd, String memberNickName, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) {
        //given
        PageRequest pageable = PageRequest.of(0, 10);
        Member member = new Member(memberId, memberPwd, memberNickName, memberEmail, memberGrant, memberReportCnt, memberCountry, memberGender, memberBirth);
        memberMapper.insertMember(member);

        //when
        List<Member> members =  memberMapper.findMembers(pageable);

        //then
        Assertions.assertNotNull(members);
    }
}