package com.fundata.varena;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @Title: FunDataTest
 * @Package: com.fundata.varena
 * @Description: Copyright: Copyright (c) 2016
 * @author li.xian
 * @date 2018-04-25 13:00
 */
public class FunDataTest {

    public static void main(String[] argv){

        String key = "";
        String secret = "" ;

        FunData.Init(key,secret);

        Map<String,Integer> params = new HashMap<String, Integer>() ;

        params.put("limit",3) ;
        params.put("page",2) ;

        FunData.Response response = FunData.Get("/data-service/dota2/pro/league/list",params);

        response.getData() ;

    }



}
