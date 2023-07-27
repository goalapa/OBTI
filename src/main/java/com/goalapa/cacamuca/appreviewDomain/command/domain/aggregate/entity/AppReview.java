package com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "app_review")
public class AppReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_review_no")
    private Integer appReviewNo;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "app_review_rate")
    private Float appReviewRate;

    @Column(name = "app_review_content")
    private String appReviewContent;


}
