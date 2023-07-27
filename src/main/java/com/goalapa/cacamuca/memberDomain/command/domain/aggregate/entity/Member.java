package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "member_id")
    @Nullable
    private String memberId;

    @Embedded
    private Password memberPwd;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_grant")
    private String memberGrant;

    @Column(name = "member_report_cnt", columnDefinition = "integer default 0")
    private Integer memberReportCnt;

    @Column(name = "member_country")
    private String memberCountry;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "blacklist_type", columnDefinition = "boolean default false")
    private Boolean blackListType;

    @Embedded
    private BirthDay birthDay;

    public Member(@Nullable String memberId, Password memberPwd, String memberNickname, String memberEmail, String memberGrant, Integer memberReportCnt, String memberCountry, String memberGender, Boolean blackListType, BirthDay birthDay) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberGrant = memberGrant;
        this.memberReportCnt = memberReportCnt;
        this.memberCountry = memberCountry;
        this.memberGender = memberGender;
        this.blackListType = blackListType;
        this.birthDay = birthDay;
    }
}