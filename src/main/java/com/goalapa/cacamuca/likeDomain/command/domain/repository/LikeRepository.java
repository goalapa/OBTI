package com.goalapa.cacamuca.likeDomain.command.domain.repository;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

}
