package com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LikeId implements Serializable {

    @Column(name = "reviewNo")
    private Integer reviewNo;

    @Column(name = "member_no")
    private Integer memberNo;
}
