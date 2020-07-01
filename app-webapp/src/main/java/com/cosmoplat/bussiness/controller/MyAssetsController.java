package com.cosmoplat.bussiness.controller;

import com.cosmoplat.common.bysiness.ResponseVo;
import com.cosmoplat.example.domain.RegisterInfo;
import com.cosmoplat.example.service.MyAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myAssets")
public class MyAssetsController {

    @Autowired
    private MyAssetsService myAssetsService;

    /**
     * 资产列表
     *
     * @return
     */
    @RequestMapping("/list")
    public ResponseVo getMyAssetsList() {
        List<RegisterInfo> myAssetsList = new ArrayList<>();
        try {
            myAssetsList = myAssetsService.searchList(new RegisterInfo());
            return ResponseVo.ok(myAssetsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVo.fail("获取资产列表失败");
        }
    }
}
