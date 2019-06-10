package com.fundata.varena.fundatajavasdk.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;

/**
 * fundata dota2 工具类
 * @author baoyl
 * @created 2018/5/9
 */
public class FunDataUtils {

    private final static String CODES = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

    public static String randomCode(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(CODES.charAt(sr.nextInt(CODES.length())));
        }
        return sb.toString();
    }

    public static String randomNumber(int length) {
        return StringUtils.leftPad(String.valueOf(new SecureRandom().nextInt((int) Math.pow(10, length))), length, '0');
    }

    public static int randomLength(int min, int max) {
        return new SecureRandom().nextInt(min) + (max - min);
    }

    public static String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String makeMd5(String code) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5bytes = md5.digest(code.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : md5bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                sb.append(temp);
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
