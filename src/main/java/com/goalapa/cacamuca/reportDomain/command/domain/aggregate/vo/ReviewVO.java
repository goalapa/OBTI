package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewVO {

    @Column(name = "review_no")
    private int reviewNo;

    public ReviewVO(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    protected ReviewVO() {

    }
}
