package com.cosmoplat.example.service;

import com.cosmoplat.example.domain.RegisterInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 27279
 */
public interface ExampleService {


    /**
     * 增加
     * @param registerInfo
     */
    void save(RegisterInfo registerInfo);
    /**
     * @param id
     * 根据主键删除
     */
    void deleteById(Integer id);
    /**
     * @param registerInfo
     * 全字段修改
     */
    void update(RegisterInfo registerInfo);
    /**
     * @param
     * @return 查找
     */
    RegisterInfo getById(Integer id);
    /**
     * @param
     * @return 全部字段查找
     */
    RegisterInfo getByModel(RegisterInfo registerInfo);

    /**
     * 查找list
     * @return
     */
    List<RegisterInfo> searchList();


}
