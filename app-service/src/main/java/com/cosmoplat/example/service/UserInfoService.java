package com.cosmoplat.example.service;


import com.cosmoplat.example.domain.UserInfo;

public interface UserInfoService {

  /**
   * 全部字段查找
   * @param userInfo
   * @return UserInfo
   */
    UserInfo getUserInfo(UserInfo userInfo);
}
