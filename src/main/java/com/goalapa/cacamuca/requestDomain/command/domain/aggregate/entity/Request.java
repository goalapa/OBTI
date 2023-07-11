package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_no")
    private Integer requestNo;

    @Column(name = "request_food")
    private String requestedFood;

    @Column(name = "request_price")
    private Integer requestPrice;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "country")
    private String country;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "request_content")
    private String requestContent;  //추가 - commit전, data.sql 수정

    public Request(String requestedFood, Integer requestPrice, Integer memberNo, String country, String foodType, String requestContent) {
        this.requestedFood = requestedFood;
        this.requestPrice = requestPrice;
        this.memberNo = memberNo;
        this.country = country;
        this.foodType = foodType;
        this.requestContent = requestContent;
    }
}
