package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_pic")
public class FoodPic {

    @Id
    @Column(name = "food_no")
    private Integer foodNo;

    @Column(name = "food_pic_url")
    private String foodPicUrl;
}
