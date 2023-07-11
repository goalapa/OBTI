package com.goalapa.cacamuca.reviewDomain.query.application.dto;

import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class QueryReviewDTO {
    private int reviewNo;

    private String reviewContent;


    private String country;


    private String foodType;


    private String foodName;


    private LocalDate reviewDate;


    private double reviewRate;


    private Integer memberNo;


    private Integer foodNo;


    private String reviewKeyword;

    private int reviewPrice;

    private String reviewLink;

    private Integer likeCnt;
}
