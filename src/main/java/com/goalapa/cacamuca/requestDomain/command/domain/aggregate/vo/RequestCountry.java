package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestCountry {

    @Column(name = "request_country")
    private String requestCountry;

    protected RequestCountry() {}

    public RequestCountry(String requestCountry) {
        this.requestCountry = requestCountry;
    }

    public String getRequestCountry() {
        return requestCountry;
    }

    @Override
    public String toString() {
        return requestCountry;
    }
}
