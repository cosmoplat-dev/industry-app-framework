package com.cosmoplat.example.Manager.service;


import com.cosmoplat.example.domain.UserInfo;

public interface TokenManager {

    /**
     * @Description: 初始化token
     */
    void initToken(UserInfo userInfo);

    /**
     * @Description: 刷新token
     */
    void refreshUserToken(String token);


    /**
     * @Description: 用户退出登录
     */
    void loginOff(UserInfo userInfo);


    /**
     * @Description: 根据token获取用户信息
     */
    UserInfo getUserInfoByToken(String token);



}
