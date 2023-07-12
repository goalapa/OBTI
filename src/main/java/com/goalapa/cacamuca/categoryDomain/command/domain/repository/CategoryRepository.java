package com.goalapa.cacamuca.categoryDomain.command.domain.repository;

import com.goalapa.cacamuca.blackListDomain.command.domain.aggregate.entity.Blacklist;
import com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}