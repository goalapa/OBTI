package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
public class ReportedMemberVO {

    @Column(name = "reported_member_no")
    private int reportedMemberNo;

    public ReportedMemberVO(Integer reportedMemberNo) {
        this.reportedMemberNo = reportedMemberNo;
    }

    protected ReportedMemberVO() {

    }
}
