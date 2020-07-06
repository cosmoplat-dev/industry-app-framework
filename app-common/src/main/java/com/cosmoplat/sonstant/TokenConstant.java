package com.cosmoplat.sonstant;

/**
 * @author donggang
 */
public final class TokenConstant {

    /**
     * 设置删除标志为真
     */
    public static final Integer DEL_FLAG_TRUE = 1;

    /**
     * 设置删除标志为假
     */
    public static final Integer DEL_FLAG_FALSE = 0;

    /**
     * redis存储token设置的过期时间:2h
     */
    public static  Integer TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 2;

    /**
     * 设置可以重置token过期时间的时间界限:1000s
     */
    public static final Integer TOKEN_RESET_TIME = 1000 * 1000;

}
