package com.goalapa.cacamuca.reportDomain.command.application.dto;

public class ReportDTO {
    private int reportNo;
    private Integer reviewNo;
    private Integer reportMemberNo;
    private Integer reportedMemberNo;
    private Integer reportType;

    public ReportDTO() {}

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

    public Integer getReportType() {
        return reportType;
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
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "reportNo=" + reportNo +
                ", reviewNo=" + reviewNo +
                ", reportMemberNo=" + reportMemberNo +
                ", reportedMemberNo=" + reportedMemberNo +
                ", reportType=" + reportType +
                '}';
    }
}
