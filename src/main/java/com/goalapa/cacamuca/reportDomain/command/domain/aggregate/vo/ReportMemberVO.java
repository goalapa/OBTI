package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
public class ReportMemberVO {

    @Column(name = "report_member_no")
    private int reportMemberNo;

    public ReportMemberVO(int reportMemberNo) {
        this.reportMemberNo = reportMemberNo;
    }

    protected ReportMemberVO() {

    }
}
