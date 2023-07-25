package com.goalapa.cacamuca.reportDomain.query.application.dto;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportTypeVO;

public class ReportQueryDTO {
    private int reportNo;
    private Integer reviewNo;
    private Integer reportMemberNo;
    private Integer reportedMemberNo;
    private String reportType;
    private String reviewContent;
    private String reportedMemberId;
    private String reportMemberId;
    public void ReportQueryDTO() {}

    public void setReportedMemberId(String reportedMemberId) {
        this.reportedMemberId = reportedMemberId;
    }

    public void setReportMemberId(String reportMemberId) {
        this.reportMemberId = reportMemberId;
    }

    public String getReportedMemberId() {
        return reportedMemberId;
    }

    public String getReportMemberId() {
        return reportMemberId;
    }

    public int getReportNo() {
        return reportNo;
    }

    public Integer getReviewNo() {
        return reviewNo;
    }

    public Integer getReportMemberNo() {
        return reportMemberNo;
    }

    public Integer getReportedMemberNo() {
        return reportedMemberNo;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReportNo(int reportNo) {
        this.reportNo = reportNo;
    }

    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    public void setReportMemberNo(Integer reportMemberNo) {
        this.reportMemberNo = reportMemberNo;
    }

    public void setReportedMemberNo(Integer reportedMemberNo) {
        this.reportedMemberNo = reportedMemberNo;
    }

    public void setReportType(Integer reportType) {
        this.reportType = new ReportTypeVO().getReportTypeToString(reportType);
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReportQueryDTO{" +
                "reportNo=" + reportNo +
                ", reviewNo=" + reviewNo +
                ", reportMemberNo=" + reportMemberNo +
                ", reportedMemberNo=" + reportedMemberNo +
                ", reportType='" + reportType + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                ", reportedMemberId='" + reportedMemberId + '\'' +
                ", reportMemberId='" + reportMemberId + '\'' +
                '}';
    }
}
