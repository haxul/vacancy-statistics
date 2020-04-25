package com.posws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.posws.entities.TraceEntity;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.repositories.TraceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.posws.models.*;
import kong.unirest.Unirest;

import java.util.Date;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class HeadHunterService {

    private final TraceRepository traceRepository;

    @Value("${headhunter.api.url}")
    private String BASE_URL;

    private HeadhunterSearchResponse requirePositionsInHeadHunter(String searchText, int areaId) throws JsonProcessingException {
        StringBuilder requestUrl = new StringBuilder(BASE_URL);
        requestUrl.append("vacancies/?area=").
                append(areaId).
                append("&text=").
                append(searchText);

        String responseBody = Unirest.get(requestUrl.toString())
                .header("Accept", "application/json")
                .asString().getBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, HeadhunterSearchResponse.class);
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void findTracesInRemoteHeadHunter() throws JsonProcessingException {
        for (var positionType : PositionTypes.values()) {
            for (var cityName : CityNames.values()) {
                findCountByPositionAndCity(positionType, cityName);
            }
        }
        log.info("Traces were updated with headhunter.com at {}", new Date());
    }

    private void findCountByPositionAndCity(PositionTypes positionType, CityNames cityName) throws JsonProcessingException {
        String position = positionType.toString().toLowerCase();
        String city = cityName.toString().toLowerCase();

        HeadhunterSearchResponse response = requirePositionsInHeadHunter(position, cityName.getId());
        TraceEntity curTrace = traceRepository.findByPositionAndCityAndDate(position, city, new Date());
        if (curTrace != null) return;

        TraceEntity trace = new TraceEntity();
        trace.setCity(city);
        trace.setCount(response.getFound());
        trace.setDate(new Date());
        trace.setPosition(position);
        traceRepository.save(trace);
    }
}
