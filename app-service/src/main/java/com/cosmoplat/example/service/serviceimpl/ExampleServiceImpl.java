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

        exampleIRegisterInfoMapper.save(registerInfo);
    }

    @Override
    public void deleteById(Integer id) {
        exampleIRegisterInfoMapper.deleteById(id);

    }

    @Override
    public void update(RegisterInfo registerInfo) {
        exampleIRegisterInfoMapper.update(registerInfo);
    }

    @Override
    public RegisterInfo getById(Integer id) {
        return exampleIRegisterInfoMapper.getById(id);
    }

    @Override
    public RegisterInfo getByModel(RegisterInfo registerInfo) {
        return exampleIRegisterInfoMapper.getByModel(registerInfo);
    }

    @Override
    public List<RegisterInfo> searchList() {
        return exampleIRegisterInfoMapper.searchList();
    }
}
