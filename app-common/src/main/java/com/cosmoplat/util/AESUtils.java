package com.cosmoplat.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AESUtils {

        /**
         * 密钥，16的倍数
         */
        public static String default_key = "fS6Von6MQAVynXy1oZfxC7VNSMMXkNKd";
        private static Charset charset = StandardCharsets.UTF_8;
        /**
         * 偏移量
         */
        private static int offset = 16;
        private static String transformation = "AES/CBC/PKCS5Padding";
        private static String algorithm = "AES";

        /**
         * 加密
         * @param content
         * @return
         */
        public static String encrypt(String content) {
            return encrypt(content, default_key);
        }

        /**
         * 解密
         * @param content
         * @return
         */
        public static String decrypt(String content) {
            return decrypt(content, default_key);
        }

        /**
         * 加密
         * @param content 明文
         * @param key     密钥
         * @return
         */
        public static String encrypt(String content, String key) {
            try {
                SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
                IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
                Cipher cipher = Cipher.getInstance(transformation);
                byte[] byteContent = content.getBytes(charset);
                cipher.init(Cipher.ENCRYPT_MODE, skey, iv);// 初始化
                byte[] result = cipher.doFinal(byteContent);
                return Base64.encodeBase64String(result); // 加密
            } catch (Exception e) {
                // 异常返回原文
                return content;
            }
        }

        /**
         * 解密
         * @param content 密文
         * @param key     密钥
         * @return 明文
         * @throws Exception
         */
        public static String decrypt(String content, String key) {
            try {

                SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
                IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
                Cipher cipher = Cipher.getInstance(transformation);
                // 初始化
                cipher.init(Cipher.DECRYPT_MODE, skey, iv);
                byte[] result = cipher.doFinal(Base64.decodeBase64(content));
                return new String(result); // 解密
            } catch (Exception e) {
                //异常返回原文
                return content;
            }
        }
    }
