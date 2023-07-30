package com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Food")
public class Food {


    @Id
    @Column(name = "food_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodNo;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_rate")
    private double foodRate;

    @Column(name = "food_price")
    private Integer foodPrice;

    @Column(name = "country")
    private String country;

    @Column(name = "food_type")
    private String foodType;
}
