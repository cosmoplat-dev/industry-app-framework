package com.cosmoplat.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备运行状态
 *
 * @author 27279
 */
@Data
public class AssetHealthEntity implements Serializable {
    /**
     * 时间
     */
    private String time;
    /**
     *设备号
     */
    private String machineNumber;
    /**
     * 信息
     */
    private String message;

  public AssetHealthEntity(String time, String machineNumber, String message) {
    this.time = time;
    this.machineNumber = machineNumber;
    this.message = message;
  }

}
