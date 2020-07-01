package com.cosmoplat.example.service.serviceimpl;

import com.cosmoplat.example.domain.UserInfo;
import com.cosmoplat.example.mapper.ExampleUserInfoMapper;
import com.cosmoplat.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    ExampleUserInfoMapper userInfoDao;
    @Override
    public UserInfo getUserInfo(UserInfo userInfo) {
        return userInfoDao.getByModel(userInfo);
    }
}
