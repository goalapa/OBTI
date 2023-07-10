package com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "review_like")
public class Like {

    @EmbeddedId
    private LikeId id;

}
