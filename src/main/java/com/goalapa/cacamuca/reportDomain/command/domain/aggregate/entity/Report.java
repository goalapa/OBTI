package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;

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

}
