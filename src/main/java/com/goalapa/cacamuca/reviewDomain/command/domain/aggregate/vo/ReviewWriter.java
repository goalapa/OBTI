package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewWriter {

    @Column(name = "member_no")
    private Integer reviewWriterMemberId;

    public ReviewWriter() {
    }

    public ReviewWriter(int loginMemberNo) {
        this.reviewWriterMemberId = loginMemberNo;
    }

    public void setReviewWriterMemberId(Integer reviewWriterMemberId) {
        this.reviewWriterMemberId = reviewWriterMemberId;
    }

    public Integer getReviewWriterMemberId() {
        return reviewWriterMemberId;
    }

    @Override
    public String toString() {
        return "ReviewWriter{" +
                "reviewWriterMemberId=" + reviewWriterMemberId +
                '}';
    }
}
