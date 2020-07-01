package com.cosmoplat.example.service.serviceimpl;

import com.cosmoplat.example.domain.RegisterInfo;
import com.cosmoplat.example.mapper.ExampleRegisterInfoMapper;
import com.cosmoplat.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 27279
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRegisterInfoMapper exampleIRegisterInfoMapper;

    @Override
    public void save(RegisterInfo registerInfo) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(RegisterInfo registerInfo) {

    }

    @Override
    public RegisterInfo getById(Integer id) {
        return null;
    }

    @Override
    public RegisterInfo getByModel(RegisterInfo registerInfo) {
        return null;
    }

    @Override
    public List<RegisterInfo> searchList() {
        return exampleIRegisterInfoMapper.searchList();
    }
}
