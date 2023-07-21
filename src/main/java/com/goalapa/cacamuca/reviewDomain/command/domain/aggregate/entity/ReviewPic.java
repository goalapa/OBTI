package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity;

import javax.persistence.*;

@Entity
@Table(name = "review_pic")
public class ReviewPic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_pic_no")
    private Integer reviewPicNo;

//    @Column(name = "review_no")
    @ManyToOne
    @JoinColumn(name = "review_no")
    private Review reviewNo;

    @Column(name = "review_pic_url")
    private String reviewPicUrl;

    public ReviewPic(String uploadPath) {
        this.reviewPicUrl = uploadPath;
    }

    public ReviewPic() {

    }
}
