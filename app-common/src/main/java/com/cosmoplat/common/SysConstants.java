package com.cosmoplat.common;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 27279
 */
public class SysConstants {
    public static final Map<String, Map<String, String>> ALLCONSTALIAS = new LinkedHashMap<>();
    /**
     * dic字典表中子系统的编码
     */
    public static final String SYS_CODE="APP";
    /**
     * 设置设备状态查询时间范围
     */
    public static final Integer ASSET_HEALTH_TIME = 60;

    /**
     * 初始化所有常量
     */
    static {
        try {
            for (Class cls : SysConstants.class.getClasses()) {
                Map<String, String> constMap = new LinkedHashMap<>();
                for (Field fd : cls.getDeclaredFields()) {
                    ConstAnnotation ca = fd.getAnnotation(ConstAnnotation.class);
                    if (ca != null) {
                        constMap.put(fd.get(cls).toString(), ca.value());
                    } else {
                        constMap.put(fd.get(cls).toString(), fd.getName());
                    }
                }
                ALLCONSTALIAS.put(cls.getSimpleName(), constMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
