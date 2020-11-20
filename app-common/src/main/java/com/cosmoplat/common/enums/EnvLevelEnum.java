package com.cosmoplat.common.enums;


import com.cosmoplat.model.BitStatus;

/**
 * @Author: 27279
 * @Date: 2020/2/12 3:51 PM
 */
public enum EnvLevelEnum implements BitStatus {
    PRODUCT(1, "生产环境"),
    DEVELOP(2, "开发环境"),
    TEST(3, "测试环境"),
    PRE_PRODUCT(4, "预生产环境");

    int value;
    String desc;

    EnvLevelEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public String desc() {
        return null;
    }
}
