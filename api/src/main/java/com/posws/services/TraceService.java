package com.posws.services;

import com.posws.entities.TraceEntity;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.enums.TimeTypes;
import com.posws.repositories.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceService {

    private final TraceRepository traceRepository;

    public List<TraceEntity> findTraces(PositionTypes position, CityNames city, Date date, TimeTypes timeTypes) {
        return traceRepository.findFirst10ByPositionAndCityOrderByDate(position.toString().toLowerCase(), city.toString().toLowerCase());
    }

    public List<TraceEntity> findTraces(PositionTypes position, CityNames city, TimeTypes timeTypes) {
        return traceRepository.findFirst10ByPositionAndCityOrderByDate(position.toString().toLowerCase(), city.toString().toLowerCase());
    }
}
