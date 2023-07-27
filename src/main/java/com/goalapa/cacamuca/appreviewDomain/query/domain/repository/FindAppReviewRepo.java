package com.goalapa.cacamuca.appreviewDomain.query.domain.repository;

import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindAppReviewRepo extends JpaRepository<AppReview, Integer> {
}
