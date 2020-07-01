package com.cosmoplat.example.service.serviceimpl;

import com.cosmoplat.common.CacheKey;
import com.cosmoplat.example.service.RedisExampleService;
import com.cosmoplat.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 27279
 */
@Service
public class RedisExampleServiceImpl implements RedisExampleService {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Object andRedis(String rediskey) {
        // 缓存锁key值
        String cacheKey = String.format(CacheKey.EXAMPLE_REDIS_KEY.getKey(),rediskey);
        redisUtil.set(cacheKey, rediskey);
        redisUtil.expire(cacheKey, CacheKey.EXAMPLE_REDIS_KEY.getTerm());
        return redisUtil.get(cacheKey);
    }

    @Override
    public void removeRedis(String rediskey) {
        String cacheKey = String.format(CacheKey.EXAMPLE_REDIS_KEY.getKey(),rediskey);
         redisUtil.del(cacheKey);
    }
}
