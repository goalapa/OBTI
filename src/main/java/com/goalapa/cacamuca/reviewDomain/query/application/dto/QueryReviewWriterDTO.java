package com.goalapa.cacamuca.reviewDomain.query.application.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class QueryReviewWriterDTO {
    private int reviewNo;
    private String memberId;
    private String memberName;

    public QueryReviewWriterDTO() {
    }
}
