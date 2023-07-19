package com.goalapa.cacamuca.requestDomain.command.domain.repository;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.RequestPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestPicRepository extends JpaRepository<RequestPic, Integer> {
}
