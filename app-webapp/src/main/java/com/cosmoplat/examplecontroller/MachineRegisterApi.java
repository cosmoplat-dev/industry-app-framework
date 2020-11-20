package com.cosmoplat.examplecontroller;

import com.cosmoplat.example.domain.RegisterInfo;
import com.cosmoplat.example.mapper.ExampleRegisterInfoMapper;
import com.cosmoplat.example.service.ExampleService;
import com.cosmoplat.model.RepStatus;
import com.cosmoplat.model.ResponseData;
import com.cosmoplat.model.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备注册restful
 *
 * @author 27279
 */
@RestController
@RequestMapping("index")
@Api(value = "MachineRegisterApi", description = "设备注册Controller")
public class MachineRegisterApi {

    @Autowired
    ExampleRegisterInfoMapper exampleIRegisterInfoMapper;
    @Autowired
    ExampleService exampleservice;

    @PostMapping("register")
    @ApiOperation(value = "注册")
    public ResponseData<String> register(@RequestBody RegisterInfo registerInfo) {
        ResponseData<String> responseData = new ResponseData(RepStatus.SUCCESS, ResponseMsg.SUCCESS, null);
        if (null != registerInfo) {
            exampleIRegisterInfoMapper.save(registerInfo);
        } else {
            responseData.setCode(RepStatus.FAIL);
            responseData.setMessage(ResponseMsg.JSON_ERROR);
        }
        return responseData;
    }

    /**
     * 设备注销
     */
    @PostMapping("logoff")
    @ApiOperation(value = "设备注销")
    public ResponseData<String> logoff(@RequestBody RegisterInfo registerInfo) {
        registerInfo.setId(2);
        ResponseData<String> responseData = new ResponseData(RepStatus.SUCCESS, ResponseMsg.SUCCESS, null);
        if (null != registerInfo) {
            registerInfo.setStatus(0);
            RegisterInfo result = exampleIRegisterInfoMapper.getById(registerInfo.getId());
            registerInfo.setId(result.getId());
            exampleIRegisterInfoMapper.update(registerInfo);
        } else {
            responseData.setCode(RepStatus.FAIL);
            responseData.setMessage(ResponseMsg.JSON_ERROR);
        }
        return responseData;
    }

    @GetMapping("/getRegister")
    @ApiOperation(httpMethod = "GET", value = "查询注册信息")
    public ResponseData<List> getRegister() {
        ResponseData<List> responseData = new ResponseData(RepStatus.SUCCESS, ResponseMsg.SUCCESS, null);
        List<RegisterInfo> searchList = exampleservice.searchList();
        responseData.setData(searchList);
        return responseData;
    }


}
