package com.cosmoplat.bussiness.controller;

import com.cosmoplat.common.bysiness.ResponseVo;
import com.cosmoplat.example.domain.MessageEntity;
import com.cosmoplat.example.service.AssetHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备运行状态
 *
 * @Author: CRX
 * @Package: com.cosmoplat.business.controller
 * @Date: 2019/11/27
 */
@Controller
@RequestMapping("/assetHealth")
public class AssetHealthController {
    @Autowired
    private AssetHealthService assetHealthService;

    public static String machineNumber;

    /**
     * 根据设备号获取设备的运行状态
     *
     * @param machineNumber 设备号
     * @return
     */
    @RequestMapping("/state/{machineNumber}")
    @ResponseBody
    public ResponseVo getState(@PathVariable String machineNumber) {
        List<MessageEntity> messageEntities = new ArrayList<>();
        try {
            messageEntities = assetHealthService.getState(machineNumber);
            return ResponseVo.ok(messageEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVo.fail("获取设备运行状态失败");
        }
    }

    @PostMapping("/state/{sid}")
    public ModelAndView getStateEcharts(@PathVariable String sid,@RequestParam String machineNumber){
        this.machineNumber=machineNumber;
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("forward:/websocket/"+sid);
        return modelAndView;
    }

    public static String getMachineNumber() {
        return machineNumber;
    }
}
