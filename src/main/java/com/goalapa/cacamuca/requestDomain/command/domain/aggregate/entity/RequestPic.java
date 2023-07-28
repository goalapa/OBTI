package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "request_pic")
public class RequestPic {

    @Id
    @Column(name = "request_no")
    private Integer requestNo;

    @Column(name = "request_url")
    private String requestUrl;
}
