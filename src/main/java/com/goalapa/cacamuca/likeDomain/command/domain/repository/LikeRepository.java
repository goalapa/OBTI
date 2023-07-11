package com.goalapa.cacamuca.likeDomain.command.domain.repository;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
