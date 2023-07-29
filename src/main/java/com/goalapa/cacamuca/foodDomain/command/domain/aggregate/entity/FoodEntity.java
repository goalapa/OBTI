package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodTypeVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "Food")
public class FoodEntity {

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
    private CountryVO countryVO;

    @Embedded
    private FoodTypeVO foodTypeVO;
}