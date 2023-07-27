package com.goalapa.cacamuca.requestDomain.query.domain.repository;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindRequestRepository extends JpaRepository<Request, Integer> {

}
