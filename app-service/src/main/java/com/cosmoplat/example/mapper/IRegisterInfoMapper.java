package com.cosmoplat.example.mapper;
import java.util.List;

import com.cosmoplat.example.domain.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface IRegisterInfoMapper {

	//----------增加
	/**
	 * @param registerInfo
	 * 添加
	 */
	void save(@Param("model") RegisterInfo registerInfo);
	//-------根据主键删除
	/**
	 * @param id
	 * 删除
	 */
	void deleteById(@Param("id") Integer id);
	//---------------全字段修改
	/**
	 * @param registerInfo
	 * 修改
	 */
	void update(@Param("model") RegisterInfo registerInfo);
	//---------------查找
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
	//-------------查找list
	/**
	 * @param registerInfo
	 */
	List<RegisterInfo> searchList(@Param("model") RegisterInfo registerInfo);
}
