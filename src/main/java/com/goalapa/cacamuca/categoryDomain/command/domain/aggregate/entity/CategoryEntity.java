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

    @Column(name = "category_name")
    @Comment("상위카테고리(국가)")
    private String categoryName;

    @Column(name = "sub_category_name")
    @Comment("하위카테고리(식품 종류)")
    private String subCategoryName;


    public CategoryEntity() {

    }
}