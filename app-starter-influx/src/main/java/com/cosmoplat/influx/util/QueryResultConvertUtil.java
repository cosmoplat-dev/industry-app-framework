package com.cosmoplat.influx.util;

import org.influxdb.dto.QueryResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: CRX
 * @Package: com.cosmoplat.appframe.business.util
 * @Date: 2019/11/27
 */
public class QueryResultConvertUtil {
    /**
     * influxDB查询结果转换
     *
     * @param results query方法的结果
     * @return
     */
    public static List<List<Object>> getValueList(QueryResult results) {
        QueryResult.Result oneResult = results.getResults().get(0);
        List<List<Object>> valueList = new ArrayList<>();
        if (oneResult.getSeries() != null) {
            valueList = oneResult.getSeries().stream().map(QueryResult.Series::getValues)
                    .collect(Collectors.toList()).get(0);
        }
        return valueList;
    }
}