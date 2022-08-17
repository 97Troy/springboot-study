package com.management.Vo;

import lombok.Data;

import java.util.List;

@Data
public class PageBeanVo<T> {
    private Long totalCount;
    private List<T> rows;
}
