package com.posws;


import com.posws.dto.AvgPositionCountDto;
import com.posws.dto.WeekAvgPositionCountDto;
import com.posws.enums.CityNames;
import com.posws.enums.PositionTypes;
import com.posws.enums.TimeTypes;
import com.posws.repositories.TraceRepository;
import com.posws.services.TraceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class TraceServiceTest {

    @Autowired
    private TraceService traceService;

    @MockBean
    private TraceRepository traceRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Before
    public void executedBeforeEach() {
        initMocks(this);
    }

    @Test
    public void shouldComputeWeek() {
        List<AvgPositionCountDto> list = new ArrayList<>();
        list.add(new WeekAvgPositionCountDto(100.0, new Date()));
        list.add(new WeekAvgPositionCountDto(120.0, new Date()));
        list.add(new WeekAvgPositionCountDto(140.0, new Date()));

        doReturn(list).when(traceRepository).getCountForEachDay(anyString(), anyString());
        List<AvgPositionCountDto> traces = traceService.findTraces(PositionTypes.JAVA, CityNames.MOSCOW, TimeTypes.DAY);
        for (int i = 0; i <traces.size() ; i++) {
            assertEquals(list.get(i).getCount(), traces.get(i).getCount());
        }
    }
}
