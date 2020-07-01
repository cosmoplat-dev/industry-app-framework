package com.cosmoplat.example.service;

import com.cosmoplat.example.domain.MessageEntity;

import java.util.List;

/**
 * 设备的运行状态
 *
 * @Author: CRX
 * @Package: com.cosmoplat.appframe.business.service
 * @Date: 2019/11/27
 */
public interface AssetHealthService {
    /**
     * 根据设备号获取设备的运行状态
     *
     * @param machineNumber 设备号
     * @return
     */
    List<MessageEntity> getState(String machineNumber);
}
