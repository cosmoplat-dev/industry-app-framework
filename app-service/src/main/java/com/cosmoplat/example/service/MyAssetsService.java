package com.cosmoplat.example.service;

import com.cosmoplat.example.domain.RegisterInfo;

import java.util.List;

public interface MyAssetsService {

    List<RegisterInfo> searchList(RegisterInfo registerInfo);
}
