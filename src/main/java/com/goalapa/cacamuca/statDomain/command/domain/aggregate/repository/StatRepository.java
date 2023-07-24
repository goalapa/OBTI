package com.goalapa.cacamuca.statDomain.command.domain.aggregate.repository;

import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {

}