package com.cosmoplat.example.domain;

import lombok.Data;

/**
 * @author 27279
 */
@Data
public class MessageEntity extends AssetHealthEntity {
    /**
     * 湿度
     */
    private String dam;
    /**
     * 数量
     */
    private String num;
    /**
     * 温度
     */
    private String tem;
    /**
     * 状态
     */
    private String status;
}
