package com.goalapa.cacamuca.likeDomain.command.domain.repository;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

    Optional<Object> findByReviewNoAndMemberNo(Integer no, int loginMemberNo);
}
