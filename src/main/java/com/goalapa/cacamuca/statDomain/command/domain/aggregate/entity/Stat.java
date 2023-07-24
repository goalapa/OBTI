package com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "stat")
public class Stat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_no")
    private Integer statNo;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "food_no")
    private Integer foodNo;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "review_cnt")
    private Integer reviewCnt;

    @Column(name = "food_rate")
    private float foodRate;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "member_age_group")
    private Integer memberAgeGroup;

    @Column(name = "member_gender")
    private String memberGender;

    @Column(name = "country")
    private String country;

//    @Column(name = "report_type")
//    private Integer reportType;

}
