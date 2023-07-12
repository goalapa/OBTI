package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestFoodType {

    @Column
    private String requestFoodType;

    protected RequestFoodType() {}
}
