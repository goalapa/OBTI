package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;

import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report {
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

//    @Column(name = "review_no")
//    private Integer reviewNo;
//
//    @Column(name = "report_member_no")
//    private Integer reportMemberNo;
//
//    @Column(name = "reported_member_no")
//    private Integer reportedMemberNo;

    @Column(name = "report_type")
    private Integer reportType;

    public Report() {
    }

    public Report(ReviewVO reviewVO, ReportMemberVO reportMemberVO,
                  ReportedMemberVO reportedMemberVO, Integer reportType) {
        this.reportMemberVO = reportMemberVO;
        this.reportedMemberVO = reportedMemberVO;
        this.reviewVO = reviewVO;
        this.reportType = reportType;
    }
}
