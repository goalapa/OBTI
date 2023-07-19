package com.goalapa.cacamuca.reviewDomain.query.domain.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "review_pic")
public class QueryReviewPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_pic_no")
    private Integer reviewPicNo;

    @Column(name = "review_no")
    @JoinColumn(name = "review_no")
    private Integer reviewNo;

    @Column(name = "review_pic_url")
    private String reviewPicUrl;

    public QueryReviewPic(String uploadPath, int review_no) {
        this.reviewPicUrl = uploadPath;
        this.reviewNo = review_no;
    }

    public QueryReviewPic(String uploadPath) {
        this.reviewPicUrl = uploadPath;
    }

    public QueryReviewPic() {

    }
}
