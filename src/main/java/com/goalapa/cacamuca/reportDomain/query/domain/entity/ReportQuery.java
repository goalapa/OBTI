package com.goalapa.cacamuca.reportDomain.query.domain.entity;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "report")
public class ReportQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_no")
    private int reportNo;

    @Embedded
    private ReviewVO reviewVO;

    @Embedded
    private ReportedMemberVO reportedMemberVO;

    @Embedded
    private ReportMemberVO reportMemberVO;

    @Column(name = "report_type")
    private Integer reportType;

    public ReportQuery() {
    }

    public ReportQuery(ReviewVO reviewVO, ReportMemberVO reportMemberVO,
                       ReportedMemberVO reportedMemberVO, Integer reportType) {
        this.reportMemberVO = reportMemberVO;
        this.reportedMemberVO = reportedMemberVO;
        this.reviewVO = reviewVO;
        this.reportType = reportType;
    }
}
