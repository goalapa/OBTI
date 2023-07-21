package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.Country;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
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

    @Embedded
    private Country country;

    @Embedded
    private FoodType foodType;

//    @Column(name = "category_no")
//    private Integer categoryNo;

}