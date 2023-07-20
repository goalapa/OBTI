package com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review_like")
@Getter
@Setter
@ToString
public class Like {

//    @EmbeddedId
//    private LikeId id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_no")
    private int likeNo;

    @Column(name = "review_no")
    private Integer reviewNo;

    @Column(name = "member_no")
    private Integer memberNo;

    public Like() {
    }

    public Like(Integer reviewNo, Integer memberNo) {
        this.reviewNo = reviewNo;
        this.memberNo = memberNo;
    }
}
