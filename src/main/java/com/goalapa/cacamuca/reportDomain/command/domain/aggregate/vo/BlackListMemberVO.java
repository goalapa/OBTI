package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BlackListMemberVO {

    @Column(name = "member_no")
    private Integer blackListMemberNo;

    public BlackListMemberVO(Integer blackListMemberNo) {
        this.blackListMemberNo = blackListMemberNo;
    }

    protected BlackListMemberVO() {}
}
