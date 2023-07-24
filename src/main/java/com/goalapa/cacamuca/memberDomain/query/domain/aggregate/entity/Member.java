package com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {

    private Integer memberNo;

    private String memberId;

    private String memberPwd;

    private String memberNickname;

    private String memberEmail;

    private String memberGrant;

    private Integer memberReportCnt;

    private String memberCountry;

    private String memberGender;

    private LocalDate memberBirth;

    public Member(String memberId, String memberPwd, String memberNickname, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, LocalDate memberBirth) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberGrant = memberGrant;
        this.memberReportCnt = memberReportCnt;
        this.memberCountry = memberCountry;
        this.memberGender = memberGender;
        this.memberBirth = memberBirth;
    }
}
