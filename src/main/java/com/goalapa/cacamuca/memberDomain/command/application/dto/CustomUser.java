package com.goalapa.cacamuca.memberDomain.command.application.dto;

import com.goalapa.cacamuca.memberDomain.query.domain.aggregate.entity.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;

@Getter
public class CustomUser extends User {

    private Integer memberNo;
    private String memberId;
    private String memberPwd;
    private String memberGrant;
    private String memberNickname;
    private String memberEmail;
    private String memberCountry;
    private LocalDate memberBirth;


    public CustomUser(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getMemberPwd(), authorities);

        setDetails(member);
    }

    private void setDetails(Member member) {
        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPwd = member.getMemberPwd();
        this.memberGrant = member.getMemberGrant();
        this.memberNickname = member.getMemberNickname();
        this.memberEmail = member.getMemberEmail();
        this.memberCountry = member.getMemberCountry();
        this.memberBirth = member.getMemberBirth();
    }
}
