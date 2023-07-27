package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.Password;
import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "member")
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
    @Nullable
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

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
}