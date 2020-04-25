package com.posws.controller;

import com.posws.dto.AvgPositionCountDto;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.enums.TimeTypes;
import com.posws.services.TraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traces")
@RequiredArgsConstructor
public class TraceController {

    private final TraceService traceService;

    @GetMapping("/{position}/{city}")
    public List<AvgPositionCountDto> getTraces(
            @PathVariable PositionTypes position,
            @PathVariable CityNames city,
            @RequestParam TimeTypes timeTypes) {
        return traceService.findTraces(position, city, timeTypes);
    }
}
