package com.management.domain.query;

import lombok.Data;

@Data
public class StatisticsQuery {
    private String className;
    private String subject;
    private String exam;
    private String statisticsType;
}
