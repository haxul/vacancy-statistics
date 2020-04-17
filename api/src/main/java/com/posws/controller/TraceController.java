package com.posws.controller;

import com.posws.entities.TraceEntity;
import com.posws.services.TraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/traces")
@RequiredArgsConstructor
public class TraceController {

    private final TraceService traceService;

    @GetMapping
    private int get() {
        return 10;
    }
    @GetMapping("/{position}/{city}")
    private List<TraceEntity> getTraces(@PathVariable String position, @PathVariable String city, @RequestParam(required = false) Date date) {
        return date == null ? traceService.findTraces(position, city) : traceService.findTraces(position, city, date);
    }
}
