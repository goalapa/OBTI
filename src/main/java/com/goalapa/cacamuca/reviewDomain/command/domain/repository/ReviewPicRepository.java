package com.goalapa.cacamuca.reviewDomain.command.domain.repository;

import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewPicRepository extends JpaRepository<ReviewPic, Integer> {
    ReviewPic findByReviewNo(Review reviewNo);
//    @Query("delete from ReviewPic p where p.reviewNo = :reviewNo")
    void deleteByReviewNo(Review review);

}
