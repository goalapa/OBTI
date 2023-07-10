package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "Food")
public class Food {

    @Id
    @Column(name = "food_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodNo;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_rate")
    private Float foodRate;

    @Column(name = "food_price")
    private Integer foodPrice;

    @Column(name = "category_no")
    private Integer categoryNo;

}