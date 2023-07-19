package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReportMemberVO {

    @Column(name = "report_member_no")
    private int reportMemberNo;

    public ReportMemberVO(int reportMemberNo) {
        this.reportMemberNo = reportMemberNo;
    }

    protected ReportMemberVO() {

    }
}
