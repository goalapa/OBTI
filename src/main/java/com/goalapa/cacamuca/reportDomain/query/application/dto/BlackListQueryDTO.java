package com.goalapa.cacamuca.reportDomain.query.application.dto;

import java.time.LocalDate;

public class BlackListQueryDTO {
    private Integer blackListNo;
    private LocalDate blackListRegDate;
    private LocalDate blackListRelDate;
    private Integer memberNo;
    private String memberId;

    @Override
    public String toString() {
        return "BlackListQueryDTO{" +
                "blackListNo=" + blackListNo +
                ", blackListRegDate=" + blackListRegDate +
                ", blackListRelDate=" + blackListRelDate +
                ", memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setBlackListNo(Integer blackListNo) {
        this.blackListNo = blackListNo;
    }

    public void setBlackListRegDate(LocalDate blackListRegDate) {
        this.blackListRegDate = blackListRegDate;
    }

    public void setBlackListRelDate(LocalDate blackListRelDate) {
        this.blackListRelDate = blackListRelDate;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getBlackListNo() {
        return blackListNo;
    }

    public LocalDate getBlackListRegDate() {
        return blackListRegDate;
    }

    public LocalDate getBlackListRelDate() {
        return blackListRelDate;
    }

    public Integer getMemberNo() {
        return memberNo;
    }
}
