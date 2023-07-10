package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "request_pic")
public class RequestPic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_no")
    private Integer requestNo;

    @Column(name = "request_url")
    private String requestUrl;
}
