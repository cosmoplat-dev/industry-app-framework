package com.cosmoplat.example.service.serviceimpl;

import com.cosmoplat.example.dao.AssetHealthDao;
import com.cosmoplat.example.domain.MessageEntity;
import com.cosmoplat.example.service.AssetHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 设备运行状态
 *
 * @Author: CRX
 * @Package: com.cosmoplat.appframe.business.service.impl
 * @Date: 2019/11/27
 */
@Service
public class AssetHealthImpl implements AssetHealthService {
    @Autowired
    AssetHealthDao assetHealthDao;

    /**
     * 根据设备号获取设备的运行状态
     *
     * @param machineNumber 设备号
     * @return
     */
    @Override
    public List<MessageEntity> getState(String machineNumber) {
        return assetHealthDao.getState(machineNumber);
    }

}
