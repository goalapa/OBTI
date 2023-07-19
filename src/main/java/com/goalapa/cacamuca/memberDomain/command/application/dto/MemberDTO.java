package com.goalapa.cacamuca.memberDomain.command.application.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MemberDTO {

    private Integer memberNo;

    private String memberId;

    private String memberPwd;

    private String memberNickname;

    private String memberEmail;

    private String memberGrant;

    private String memberReportCnt;

    private String memberCountry;

    private String memberGender;

    private String memberBirth;
}
