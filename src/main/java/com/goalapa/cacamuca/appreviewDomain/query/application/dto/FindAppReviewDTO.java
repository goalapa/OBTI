package com.goalapa.cacamuca.appreviewDomain.query.application.dto;

public class FindAppReviewDTO {

    private Integer AppReviewNo;
    private Integer memberNo;
    private String memberNickName;
    private Float appReviewRate;
    private String appReviewContent;

    public FindAppReviewDTO() {}

    public FindAppReviewDTO(Integer appReviewNo, Integer memberNo, String memberNickName, Float appReviewRate, String appReviewContent) {
        AppReviewNo = appReviewNo;
        this.memberNo = memberNo;
        this.memberNickName = memberNickName;
        this.appReviewRate = appReviewRate;
        this.appReviewContent = appReviewContent;
    }

    public Integer getAppReviewNo() {
        return AppReviewNo;
    }

    public void setAppReviewNo(Integer appReviewNo) {
        AppReviewNo = appReviewNo;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public Float getAppReviewRate() {
        return appReviewRate;
    }

    public void setAppReviewRate(Float appReviewRate) {
        this.appReviewRate = appReviewRate;
    }

    public String getAppReviewContent() {
        return appReviewContent;
    }

    public void setAppReviewContent(String appReviewContent) {
        this.appReviewContent = appReviewContent;
    }

    @Override
    public String toString() {
        return "FindAppReviewDTO{" +
                "AppReviewNo=" + AppReviewNo +
                ", memberNo=" + memberNo +
                ", memberNickName='" + memberNickName + '\'' +
                ", appReviewRate=" + appReviewRate +
                ", appReviewContent='" + appReviewContent + '\'' +
                '}';
    }

}
