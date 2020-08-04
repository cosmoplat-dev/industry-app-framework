package com.cosmoplat.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
* 实体类：RegisterInfo
* 对照表：register_info
 * @author 27279
 */
@Data
public class RegisterInfo implements Serializable {
	/**
	 * 操作者
	 */
	private String author;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 *  设备ip
	 */
	private String machineIp;
	/**
	 * 设备标记
	 */
	private String machineMark;
	/**
	 * 设备号
	 */
	private String machineNumber;
	/**
	 * 注册时间
	 */
	private java.util.Date regTime;
	/**
	 * 设备状态（1正常，0已注销，2禁用）
	 */
	private Integer Status;

}
