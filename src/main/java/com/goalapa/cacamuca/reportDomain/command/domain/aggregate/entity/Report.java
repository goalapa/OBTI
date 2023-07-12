package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import groovy.transform.builder.Builder;

import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_no")
    private int reportNo;

    @Column(name = "review_no")
    private Integer reviewNo;

    @Column(name = "report_member_no")
    private Integer reportMemberNo;

    @Column(name = "reported_member_no")
    private Integer reportedMemberNo;

    @Column(name = "report_type")
    private Integer reportType;

    public Report() {
    }

    public Report(Integer reviewNo, Integer reportMemberNo, Integer reportedMemberNo, Integer reportType) {
        this.reviewNo = reviewNo;
        this.reportMemberNo = reportMemberNo;
        this.reportedMemberNo = reportedMemberNo;
        this.reportType = reportType;
    }
}
