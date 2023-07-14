package com.goalapa.cacamuca.reportDomain.query.domain.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "report")
public class ReportQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_no")
    private int reportNo;

    @Column(name = "review_no")
    private Integer reviewNo;

    @Column(name = "reported_member_no")
    private Integer reportedMemberNo;

    @Column(name = "report_member_no")
    private Integer reportMemberNo;

    @Column(name = "report_type")
    private Integer reportType;

    public ReportQuery() {
    }

    public ReportQuery(Integer reviewNo, Integer reportMemberNo,
                       Integer reportedMemberNo, Integer reportType) {
        this.reportMemberNo = reportMemberNo;
        this.reportedMemberNo = reportedMemberNo;
        this.reviewNo = reviewNo;
        this.reportType = reportType;
    }
}