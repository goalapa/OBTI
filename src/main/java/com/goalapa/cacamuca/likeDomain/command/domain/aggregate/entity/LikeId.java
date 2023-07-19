package com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class LikeId implements Serializable {

    @Column(name = "reviewNo")
    private Integer reviewNo;

    @Column(name = "member_no")
    private Integer memberNo;
}
