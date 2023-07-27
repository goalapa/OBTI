package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "food_pic")
public class FoodPicEntity {

    @Id
    @Column(name = "food_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodNo;

    @Column(name = "food_pic_url")
    private String foodPicUrl;
}
