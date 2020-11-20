package com.cosmoplat.bussiness.controller;

import com.cosmoplat.common.bysiness.ResponseVo;
import com.cosmoplat.example.domain.UserInfo;
import com.cosmoplat.example.service.UserInfoService;
import com.cosmoplat.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/getUser")
    public ResponseVo getUserInfoByToken(@RequestParam String token) {
        String userId = String.valueOf(redisUtil.get(token));
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        try {
            userInfo = userInfoService.getUserInfo(userInfo);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("服务器错误：" + e.getMessage());
        }
        return ResponseVo.ok(userInfo);
    }
}
