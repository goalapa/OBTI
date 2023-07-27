package com.goalapa.cacamuca.appreviewDomain.command.domain.repository;

import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppReviewRepository extends JpaRepository<AppReview, Integer> {

}
