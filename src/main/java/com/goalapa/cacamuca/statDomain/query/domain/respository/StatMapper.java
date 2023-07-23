package com.goalapa.cacamuca.statDomain.query.domain.respository;

@org.apache.ibatis.annotations.Mapper
public interface StatMapper {
    int countLikes(int foodNo);
}
