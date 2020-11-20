package com.cosmoplat.example.mapper;
import java.util.List;

import com.cosmoplat.example.domain.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface IRegisterInfoMapper {

	/**
	 * @param registerInfo
	 * 添加
	 */
	void save(@Param("model") RegisterInfo registerInfo);
	/**
	 * @param id
	 * 删除
	 */
	void deleteById(@Param("id") Integer id);
	/**
	 * @param registerInfo
	 * 修改
	 */
	void update(@Param("model") RegisterInfo registerInfo);
	/**
	 * @param
	 * @return 查找
	 */
	RegisterInfo getById(@Param("id") Integer id);
	/**
	 * @param
	 * @return 全部字段查找
	 */
	RegisterInfo getByModel(@Param("model") RegisterInfo registerInfo);
	/**
	 * @param registerInfo
	 */
	List<RegisterInfo> searchList(@Param("model") RegisterInfo registerInfo);
}
