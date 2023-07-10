package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {

    @Id()
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;

    @Comment("리뷰 내용")
    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_rate")
    private double reviewRate;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "food_no")
    private Integer foodNo;

    @Column(name = "review_keyword")
    private String reviewKeyword;

    @Column(name = "review_price")
    private String reviewPrice;

    @Column(name = "review_link")
    private String reviewLink;

    @Column(name = "likeCnt")
    private Integer likeCnt;
}
