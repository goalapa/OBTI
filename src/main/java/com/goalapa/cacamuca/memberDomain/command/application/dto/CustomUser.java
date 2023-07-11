package com.goalapa.cacamuca.memberDomain.command.application.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private Integer memberNo;
    private String memberId;
    private String memberPwd;
    private String memberGrant;

    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getMemberPwd(), authorities);

        setDetails(member);
    }

    private void setDetails(MemberDTO member) {
        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPwd = member.getMemberPwd();
        this.memberGrant = member.getMemberGrant();
    }
}
