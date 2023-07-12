package com.goalapa.cacamuca.memberDomain.query.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {

    Map<String, Object> findById(Integer no);
}
