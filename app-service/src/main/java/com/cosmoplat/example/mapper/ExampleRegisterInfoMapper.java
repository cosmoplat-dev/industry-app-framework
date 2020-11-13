package com.cosmoplat.example.mapper;

import com.cosmoplat.example.domain.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 27279
 */
@Mapper
public interface ExampleRegisterInfoMapper {

    /**
     * @param registerInfo
     * 添加
     */
    void save(@Param("model") RegisterInfo registerInfo);
    /**
     * @param id
     * 根据主键删除
     */
    void deleteById(@Param("id") Integer id);
    /**
     * @param registerInfo
     * 全字段修改
     */
    void update(@Param("model") RegisterInfo registerInfo);
    /**
     * @param id
     * @return 查找
     */
    RegisterInfo getById(@Param("id") Integer id);
    /**
     * @param registerInfo
     * @return 全部字段查找
     */
    RegisterInfo getByModel(@Param("model") RegisterInfo registerInfo);
    /**
     * @param
     * @return 查找list
     */
    List<RegisterInfo> searchList();


}
