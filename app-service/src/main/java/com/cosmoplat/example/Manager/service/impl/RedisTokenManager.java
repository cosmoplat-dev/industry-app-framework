package com.cosmoplat.example.Manager.service.impl;

import com.cosmoplat.example.Manager.service.TokenManager;
import com.cosmoplat.example.domain.UserInfo;
import com.cosmoplat.redis.util.RedisUtil;
import com.cosmoplat.sonstant.TokenConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class RedisTokenManager implements TokenManager {
    @Autowired
    RedisUtil redisUtil;

    @Override
    public void initToken(UserInfo userInfo) {
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();
        redisUtil.set(token, userId);
        redisUtil.expire(token, TokenConstant.TOKEN_EXPIRE_TIME);
        Long currentTime = System.currentTimeMillis();
        redisUtil.set(token + userId, currentTime.toString());
    }

    @Override
    public void refreshUserToken(String token) {
        String userId = "";
        if (null != token && token.length() != 0) {
            userId = redisUtil.get(token).toString();
            log.info("用户名{}", userId);
        }
        if (!StringUtils.isEmpty(userId)) {
            Long tokeBirthTime = Long.valueOf(redisUtil.get(token + userId).toString());
            log.info("用户令牌起始生效期: {}", tokeBirthTime);
            Long diff = System.currentTimeMillis() - tokeBirthTime;
            log.info("用户令牌已生效 : {} ms", diff);
            if (diff > TokenConstant.TOKEN_RESET_TIME) {
                redisUtil.expire(token, TokenConstant.TOKEN_EXPIRE_TIME);
                log.info("刷新令牌成功");
                long newBirthTime = System.currentTimeMillis();
                redisUtil.set(token + userId, Long.toString(newBirthTime));
            }
            return;
        }
        log.info("刷新token失败");
        throw new RuntimeException("token已过期或不存在");
    }

    @Override
    public void loginOff(UserInfo userInfo) {
        if (!ObjectUtils.isEmpty(userInfo)) {
            log.info("清空用户令牌:user:{}", userInfo);
            redisUtil.del(userInfo.getToken(),userInfo.getToken()+userInfo.getUserId());
        }
    }

    @Override
    public UserInfo getUserInfoByToken(String token) {
        return null;
    }
}
