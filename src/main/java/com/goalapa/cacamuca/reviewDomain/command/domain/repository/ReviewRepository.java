package com.goalapa.cacamuca.reviewDomain.command.domain.repository;


import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Review findByReviewNoAndReviewWriter_ReviewWriterMemberId(int reviewNo, int memberNo);
}
