package com.cosmoplat.example.dao;

import com.alibaba.fastjson.JSONObject;
import com.cosmoplat.common.SysConstants;
import com.cosmoplat.example.domain.MessageEntity;
import com.cosmoplat.influx.util.InfluxDBUtils;
import com.cosmoplat.influx.util.QueryResultConvertUtil;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备运行状态
 *
 * @Author: CRX
 * @Package: com.cosmoplat.appframe.business.dao
 * @Date: 2019/11/27
 */
@Repository
public class AssetHealthDao {

    @Autowired(required = false)
    private InfluxDBUtils influxDBUtils;

    /**
     * 根据设备号获取设备的运行状态
     *
     * @param machineNumber 设备号
     * @return
     */
    public List<MessageEntity> getState(String machineNumber) {

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM machine_info WHERE (time > now() - ")
                .append(SysConstants.ASSET_HEALTH_TIME).append("m)  and machineNumber ='")
                .append(machineNumber).append("'");
        QueryResult results = influxDBUtils.query(sql.toString());
        List<List<Object>> valueList = QueryResultConvertUtil.getValueList(results);
        ArrayList<MessageEntity> messageEntities = new ArrayList<>();
        if (valueList != null && valueList.size() > 0) {
            for (List<Object> value : valueList) {
                String time = value.get(0) == null ? null : value.get(0).toString();
                String macNumber = value.get(1) == null ? null : value.get(1).toString();
                String message = value.get(2) == null ? null : value.get(2).toString();
                JSONObject messageJson= JSONObject.parseObject(message);
                MessageEntity messageEntity = messageJson.toJavaObject(MessageEntity.class);
                messageEntity.setTime(time);
                messageEntity.setMachineNumber(macNumber);
                messageEntity.setMessage(message);
                messageEntities.add(messageEntity);
            }
        }
        return messageEntities;
    }
}
