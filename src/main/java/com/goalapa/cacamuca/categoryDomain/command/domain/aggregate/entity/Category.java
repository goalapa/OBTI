package com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity;


import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_no")
    private Integer categoryNo;

    @Column(name = "category_name")
    @Comment("상위카테고리(국가)")
    private String categoryName;

    @Column(name = "sub_category_name")
    @Comment("하위카테고리(식품 종류)")
    private String subCategoryName;
}