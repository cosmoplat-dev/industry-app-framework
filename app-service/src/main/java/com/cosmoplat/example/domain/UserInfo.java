package com.cosmoplat.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 实体类：UserInfo
* 对照表：user_info
 * @author 27279
 */
@Data
public class UserInfo implements Serializable {
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 是否删除
	 */
	private String isDel;
	/**
	 * 用户状态
	 */
	private String status;
	/**
	 * 修改时间
	 */
	private java.util.Date updateTime;
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPass;
	/**
	 * 用户手机号
	 */
	private String userPhone;

	private String token;
}
