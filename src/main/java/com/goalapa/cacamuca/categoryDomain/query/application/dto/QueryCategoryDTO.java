package com.goalapa.cacamuca.categoryDomain.query.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class QueryCategoryDTO {

    private Integer categoryNo;
    private String country;
    private String foodType;
}
