package com.posws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.posws.entities.TraceEntity;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.repositories.TraceRepository;
import lombok.RequiredArgsConstructor;
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
public class HeadHunterService {

    private final TraceRepository traceRepository;

    @Value("${headhunter.api.url}")
    private String BASE_URL;

    private HeadhunterSearchResponse findPositionsInHH(String searchText, int areaId) throws JsonProcessingException {
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

    @Scheduled(fixedRate = 86400000)
    public void findJavaInSamara() throws JsonProcessingException {
        String position = PositionTypes.JAVA.toString().toLowerCase();
        String city = CityNames.SAMARA.toString().toLowerCase();

        HeadhunterSearchResponse response = findPositionsInHH(position, CityNames.SAMARA.getId());
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
