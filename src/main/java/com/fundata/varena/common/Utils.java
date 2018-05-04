package com.fundata.varena.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

/**
 * @version 1.0.0
 * @Title: Utils
 * @Package: com.fundata.varena.common
 * @Description: Copyright: Copyright (c) 2016
 * @author li.xian
 * @date 2018-04-25 12:06
 */
public class Utils {

    public static String JointUrl(String host, String uri){
        if(uri.startsWith(host)){
            return uri ;
        }else {
            return host+uri ;
        }
    }

    public static String JointParams(Map<String,?> args){
        if (args==null||args.size()==0){
            return "" ;
        }

        List<String> keys = new ArrayList<String>(args.keySet()) ;

        Collections.sort(keys);

        List<String> params = new ArrayList<String>() ;

        for (String key:keys){
            params.add(key+"="+String.valueOf(args.get(key))) ;
        }
        String param = String.join("&",params) ;

        return param ;
    }

    private static final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;

    public static String RandomString(int count){

        char[] buffer = new char[count];

        Random random = new Random() ;

        while(count-- != 0) {
            char ch = chars.charAt(random.nextInt(chars.length())) ;
            buffer[count] = ch;
        }
        return new String(buffer);
    }

    public static String Encrypt(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

}
