package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReportedMemberVO {

    @Column(name = "reported_member_no")
    private int reportedMemberNo;

    public ReportedMemberVO(Integer reportedMemberNo) {
        this.reportedMemberNo = reportedMemberNo;
    }

    protected ReportedMemberVO() {

    }
}
