package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CountryVO {

    @Column(name = "country")
    private String country;

    public CountryVO(String country) { this.country = country; }

    public CountryVO() {}
}
