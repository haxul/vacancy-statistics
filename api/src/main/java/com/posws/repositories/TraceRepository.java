package com.posws.repositories;

import com.posws.entities.TraceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceRepository extends JpaRepository<TraceEntity, Integer> {
    List<TraceEntity> findFirst10ByPositionAndCityOrderByDate(String position, String city);
}
