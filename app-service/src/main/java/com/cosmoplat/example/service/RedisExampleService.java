package com.cosmoplat.example.service;

/**
 * @author 27279
 */
public interface RedisExampleService {

    /**
     * @param rediskey
     * @return
     */
    Object andRedis(String rediskey);

    /**
     *
     * @param rediskey
     */
    void  removeRedis(String rediskey);
}
