package com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@Setter
@Getter
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("상위카테고리와 하위카테고리를 포함한 고유번호")
    @Column(name = "category_no")
    private Integer categoryNo;

    @Column(name = "country")
    @Comment("국가명")
    private String country;

    @Column(name = "food_type")
    @Comment("식품 종류")
    private String foodType;


    public CategoryEntity() {

    }

}