package com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity;


import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "category_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryNo;

    @Column(name = "category_name")
    private String categoryName;
}