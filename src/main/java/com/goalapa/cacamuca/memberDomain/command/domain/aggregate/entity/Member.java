package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Table(name = "Member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_grant")
    private String memberGrant;

    @Column(name = "member_report_cnt")
    private String memberReportCnt;

    @Column(name = "member_country")
    private String memberCountry;

    @Column(name = "member_gender")
    private String memberGender;

    @Embedded
    private BirthDay birthDay;
}