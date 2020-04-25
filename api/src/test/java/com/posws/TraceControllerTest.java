package com.posws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posws.controller.TraceController;
import com.posws.dto.AvgPositionCountDto;
import com.posws.dto.WeekAvgPositionCountDto;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.enums.TimeTypes;
import com.posws.services.TraceService;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@WebMvcTest(TraceController.class)
public class TraceControllerTest {

    @MockBean
    private TraceService traceService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    public void shouldReturnStatusOk() {
        List<AvgPositionCountDto> list = new ArrayList<>();
        list.add(new WeekAvgPositionCountDto(100.0, new Date()));
        list.add(new WeekAvgPositionCountDto(90.0, new Date()));
        list.add(new WeekAvgPositionCountDto(110.0, new Date()));
        list.add(new WeekAvgPositionCountDto(120.0, new Date()));
        doReturn(list).when(traceService).findTraces(any(PositionTypes.class), any(CityNames.class), any(TimeTypes.class));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/traces/JAVA/SAMARA?timeTypes=DAY")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult perform = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = perform.getResponse();
        assertEquals(200, response.getStatus());
        String body = response.getContentAsString();
        String json = objectMapper.writeValueAsString(list);
        assertEquals(json, body);
    }
}
