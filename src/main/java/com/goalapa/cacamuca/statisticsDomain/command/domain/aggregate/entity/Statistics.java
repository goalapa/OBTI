package com.goalapa.cacamuca.statisticsDomain.command.domain.aggregate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stat")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_no")
    private Integer statNo;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "review_cnt")
    private Integer reviewCnt;

    @Column(name = "food_rate")
    private float foodRate;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "report_type")
    private Integer reportType;

    @Column(name = "member_age_group")
    private Integer memberAgeGroup;
}
