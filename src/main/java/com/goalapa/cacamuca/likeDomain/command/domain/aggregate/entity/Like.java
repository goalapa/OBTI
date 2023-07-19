package com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "review_like")
@Getter
public class Like {

    @EmbeddedId
    private LikeId id;

}
