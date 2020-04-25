package com.posws.services;

import com.posws.dto.AvgPositionCountDto;
import com.posws.dto.WeekAvgPositionCountDto;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.enums.TimeTypes;
import com.posws.repositories.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceService {

    private final TraceRepository traceRepository;

    public List<AvgPositionCountDto> findTraces(PositionTypes position, CityNames city, TimeTypes timeTypes) {
        switch (timeTypes) {
            case DAY:
                return traceRepository.getCountForEachDay(position.toString().toLowerCase(), city.toString().toLowerCase());
            case MONTH:
                return traceRepository.getCountForEachMonth(position.toString().toLowerCase(), city.toString().toLowerCase());
            case WEEK:
                List<AvgPositionCountDto> tracesFor70Days = traceRepository.getCountForEachWeek(position.toString().toLowerCase(), city.toString().toLowerCase());
                return computeWeekAvgCountForWeekTimeType(tracesFor70Days);
            default:
                throw new RuntimeException("findTraces error in TraceServices. Although it's impossible");
        }
    }

    private List<AvgPositionCountDto> computeWeekAvgCountForWeekTimeType(List<AvgPositionCountDto> inputList) {
        List<AvgPositionCountDto> resultList = new ArrayList<>(10);
        double avgCountValue = 0;
        for (int i = 0, count = 0; i < inputList.size(); i++, count++) {
            if (count > 6) {
                count = 0;
                resultList.add(new WeekAvgPositionCountDto((double) Math.round(avgCountValue / 7), inputList.get(i - 1).getDate()));
                avgCountValue = 0;
            }
            boolean isLastElement = (inputList.size() - 1) == i;
            avgCountValue += inputList.get(i).getCount();
            if (isLastElement && i != 0) {
                resultList.add(new WeekAvgPositionCountDto((double) Math.round(avgCountValue / (count + 1)), inputList.get(i).getDate()));
                return resultList;
            }
        }
        return resultList;
    }
}
