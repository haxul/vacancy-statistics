package com.posws.services;

import com.posws.entities.TraceEntity;
import com.posws.repositories.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceService {

    private final TraceRepository traceRepository;

    public List<TraceEntity> findTraces(String position, String city, Date date) {
        return traceRepository.findFirst10ByPositionAndCityOrderByDate(position, city);
    }

    public List<TraceEntity> findTraces(String position, String city) {
        return traceRepository.findFirst10ByPositionAndCityOrderByDate(position, city);
    }
}
