package com.cosmoplat.example.mapper;

import com.cosmoplat.example.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 27279
 */
@Mapper
public interface ExampleUserInfoMapper{
    /**
     * 新增用户
     * @param userInfo
     */
    void save(@Param("model") UserInfo userInfo);

    /**
     * 根据主键删除
     * @param id
     */
    void deleteById(@Param("id") Integer id);

    /**
     * 全字段修改
     * @param userInfo
     */
    void update(@Param("model") UserInfo userInfo);
    /**
     * @param id
     * @return 查找
     */
    UserInfo getById(@Param("id") Integer id);

    /**
     * 全部字段查找
     * @param userInfo
     * @return
     */
    UserInfo getByModel(@Param("model") UserInfo userInfo);

    /**
     * 查找list
     * @param userInfo
     * @return List<UserInfo>
     */
    List<UserInfo> searchList(@Param("model") UserInfo userInfo);


}
