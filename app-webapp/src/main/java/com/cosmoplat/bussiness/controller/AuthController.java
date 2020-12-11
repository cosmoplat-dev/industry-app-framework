package com.cosmoplat.bussiness.controller;

import com.cosmoplat.auth.anno.DisableToken;
import com.cosmoplat.common.bysiness.ResponseVo;
import com.cosmoplat.example.Manager.service.TokenManager;
import com.cosmoplat.example.domain.UserInfo;
import com.cosmoplat.example.service.UserInfoService;
import com.cosmoplat.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    TokenManager tokenManager;
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/login")
    @DisableToken
    public ResponseVo login(@RequestBody UserInfo userInfo) {
        //重新赋值
        userInfo=userInfoService.getUserInfo(userInfo);
        //验证通过
        if (null != userInfo) {
            String token = JwtUtil.sign(userInfo.getUserId());
            userInfo.setToken(token);
            tokenManager.initToken(userInfo);
            return ResponseVo.ok(userInfo);
        } else {
            return ResponseVo.fail("帐号或密码错误");
        }
    }

    @PostMapping("/logoff")
    @DisableToken
    public ResponseVo logoff(HttpServletRequest request){
        try{
            String token = request.getHeader("bear_token");
            UserInfo userInfo=new UserInfo();
            userInfo.setToken(token);
            tokenManager.loginOff(userInfo);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return  ResponseVo.ok();
    }

}
