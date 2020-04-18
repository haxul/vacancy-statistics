package com.posws.repositories;

import com.posws.dto.AvgPositionCountDto;
import com.posws.entities.TraceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraceRepository extends JpaRepository<TraceEntity, Integer> {

    @Query(value = "SELECT  count, date FROM traces WHERE position=:position AND city=:city ORDER BY date DESC LIMIT 10"
            , nativeQuery = true)
    List<AvgPositionCountDto> getCountForEachDay(String position, String city);

    @Query(value = "SELECT avg(count) AS count, DATE(date_trunc( 'month', date )) AS date FROM traces " +
            "GROUP BY date_trunc ( 'month', date ), city, position " +
            "HAVING position=:position AND city=:city ORDER BY date LIMIT 10 ", nativeQuery = true)
    List<AvgPositionCountDto> getCountForEachMonth(String position, String city);


    @Query(value="SELECT count , date FROM traces WHERE position=:position AND city=:city ORDER BY date DESC LIMIT 70", nativeQuery=true)
    List<AvgPositionCountDto> getCountForEachWeek(String position, String city);
}
