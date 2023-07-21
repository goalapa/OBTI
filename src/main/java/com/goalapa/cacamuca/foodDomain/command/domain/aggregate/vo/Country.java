package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Country {

    @Column(name = "country")
    private String country;

    protected Country() {}
    public Country(String country) {
        this.country = country;
    }
}
