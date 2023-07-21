package com.goalapa.cacamuca.reportDomain.command.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<Blacklist, Integer> {

}