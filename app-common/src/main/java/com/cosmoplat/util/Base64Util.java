package com.cosmoplat.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * base64 编码、解码util
 *
 * @author hxx
 * @date 2015-3-4 上午09:23:33
 */
public class Base64Util {
    /**
     * 将 s 进行 BASE64 编码
     *
     * @return String
     * @author lifq
     * @date 2015-3-4 上午09:24:02
     */
    public static String encode(String s) {
        if (s == null)
            return null;
        String res = "";
        try {
            res = Base64.encodeBase64String(s.getBytes("GBK"));
        } catch (UnsupportedEncodingException ignore) {
        }
        return res;
    }

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-4 上午09:24:26
     */
    public static String decode(String s) {
        if (s == null)
            return null;
        try {
            byte[] b = Base64.decodeBase64(s);
            return new String(b, "GBK");
        } catch (Exception e) {
            return null;
        }
    }

}
