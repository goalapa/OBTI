package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import javax.persistence.Column;

public class ReportTypeVO {

    @Column(name = "report_type")
    private Integer reportType;

    public String getReportTypeToString(int reportType) {
        switch (reportType) {
            case 1:
                return "폭력적 또는 혐오스러운 리뷰";
            case 2:
                return "스팸 또는 광고성 리뷰";
            case 3:
                return "타인을 비방하는 리뷰";
            case 4:
                return "악의적인 리뷰";
            default:
                return "기타";
        }
    }
}
