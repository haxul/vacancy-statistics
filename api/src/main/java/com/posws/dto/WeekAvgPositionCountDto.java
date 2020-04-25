package com.posws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class WeekAvgPositionCountDto implements AvgPositionCountDto {
    private Double count;
    private Date date;
}
