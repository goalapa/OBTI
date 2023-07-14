//package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity;
//
//import org.hibernate.annotations.Comment;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "review_like")
//public class ReviewLike {
//    @Id()
//    @Column(name = "member_no")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int memberNo;
//
//    @Column(name = "review_no")
//    private int reviewNo;
//
//    public ReviewLike() {
//    }
//
//    public ReviewLike(int memberNo, int reviewNo) {
//        this.memberNo = memberNo;
//        this.reviewNo = reviewNo;
//    }
//
//    public int getMemberNo() {
//        return memberNo;
//    }
//
//    public void setMemberNo(int memberNo) {
//        this.memberNo = memberNo;
//    }
//
//    public int getReviewNo() {
//        return reviewNo;
//    }
//
//    public void setReviewNo(int reviewNo) {
//        this.reviewNo = reviewNo;
//    }
//
//    @Override
//    public String toString() {
//        return "ReviewLike{" +
//                "memberNo=" + memberNo +
//                ", reviewNo=" + reviewNo +
//                '}';
//    }
//}
