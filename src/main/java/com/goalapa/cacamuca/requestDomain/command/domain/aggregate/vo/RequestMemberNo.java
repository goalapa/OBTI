package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestMemberNo {

    @Column(name = "request_member_no")
    private int requestMemberNo;

    protected RequestMemberNo() {}

    public RequestMemberNo(int requestMemberNo) {
        this.requestMemberNo = requestMemberNo;
    }
}
