package com.goalapa.cacamuca.reviewDomain.command.domain.repository;

import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}