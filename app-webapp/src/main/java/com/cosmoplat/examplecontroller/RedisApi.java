package com.cosmoplat.examplecontroller;


import com.alibaba.fastjson.JSON;
import com.cosmoplat.example.service.RedisExampleService;
import com.cosmoplat.model.RepStatus;
import com.cosmoplat.model.ResponseData;
import com.cosmoplat.model.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 27279
 */
@Slf4j
@RestController
@RequestMapping("redis")
@Api(value = "RedisApi",description = "redis测试!")
public class RedisApi {

    @Autowired
    RedisExampleService redisExampleService;

    @GetMapping("addRedis")
    @ApiOperation(httpMethod = "GET",value = "发送点对点消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",    dataType = "String",  value = "要保存到redis的信息!")
    })
    public ResponseData<Object> addRedis(String key) {
        log.debug("ADD REDIS 开始, param: key,{}",key);
        ResponseData<Object> responseData =  new ResponseData(RepStatus.SUCCESS, ResponseMsg.SUCCESS,null);
        Object o = redisExampleService.andRedis(key);

        responseData.setData(JSON.toJSON(o));
        log.debug("ADD REDIS 结束, param: responseData,{}",JSON.toJSON(responseData));
        return  responseData;
    }

    @GetMapping("removeRedis")
    @ApiOperation(httpMethod = "GET",value = "发送点对点消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",    dataType = "String",  value = "要删除redis的信息!")
    })
    public ResponseData<Boolean> removeRedis(String key) {
        log.debug("REMOVE REDIS 开始, param: key,{}",key);
        ResponseData<Boolean> responseData =  new ResponseData(RepStatus.SUCCESS, ResponseMsg.SUCCESS,null);
        redisExampleService.removeRedis(key);
        log.debug("REMOVE REDIS 结束, param: responseData,{}",JSON.toJSON(responseData));
        return  responseData;
    }

}
