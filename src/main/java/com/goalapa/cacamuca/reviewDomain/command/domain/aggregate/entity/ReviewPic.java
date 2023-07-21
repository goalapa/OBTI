package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "review_pic")
@Getter
public class ReviewPic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_pic_no")
    private Integer reviewPicNo;

//    @Column(name = "review_no")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "review_no")
    private Review reviewNo;

    @Column(name = "review_pic_url")
    private String reviewPicUrl;

    public ReviewPic(String uploadPath) {
        this.reviewPicUrl = uploadPath;
    }

    public ReviewPic() {

    }

    public void setReviewNo(Review review) {
        this.reviewNo = review;
    }

    @Override
    public String toString() {
        return "ReviewPic{" +
                "reviewPicNo=" + reviewPicNo +
                ", reviewNo=" + reviewNo +
                ", reviewPicUrl='" + reviewPicUrl + '\'' +
                '}';
    }
}
