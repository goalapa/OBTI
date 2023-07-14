package com.goalapa.cacamuca.reviewDomain.command.domain.repository;


import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Modifying
    @Query(value = "update Review r set r.likeCnt = r.likeCnt + 1 where r.reviewNo = :no")
    int plusLike(int no);
}
