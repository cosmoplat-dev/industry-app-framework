package com.cosmoplat.example.service.serviceimpl;

import com.cosmoplat.example.domain.RegisterInfo;
import com.cosmoplat.example.mapper.IRegisterInfoMapper;
import com.cosmoplat.example.service.MyAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAssetsServiceImpl implements MyAssetsService {

    @Autowired
    private IRegisterInfoMapper iRegisterInfoMapper;

    /**
     * 资产列表
     *
     * @return
     */
    @Override
    public List<RegisterInfo> searchList(RegisterInfo registerInfo) {
        return iRegisterInfoMapper.searchList(registerInfo);
    }
}
