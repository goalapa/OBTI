package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestMemberNo {

    @Column
    private int requestMemberNo;

    protected RequestMemberNo() {}
}
