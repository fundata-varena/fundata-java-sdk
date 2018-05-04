package com.fundata.varena;

import com.alibaba.fastjson.JSON;
import com.fundata.varena.common.Utils;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * @version 1.0.0
 * @Title: FunData
 * @Package: com.fundata.varena
 * @Description: Copyright: Copyright (c) 2016
 * @author li.xian
 * @date 2018-04-23 12:47
 */
public class FunData {

    private static final String HOST = "http://api.varena.com" ;

    private static String KEY ;
    private static String SECRET ;
    private static OkHttpClient client ;

    public static void Init(String key,String secret) {
        KEY = key ;
        SECRET = secret ;
        client = new OkHttpClient() ;
    }

    public static Response Get(String uri, Map<String,?> params){

        Request funRequest = new Request(uri,params,Request.GET) ;

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(funRequest.url())
                .headers(funRequest.headers())
                .build();

        return send(request) ;
    }

    public static Response Post(String uri, Map<String,?> params){

        Request funRequest = new Request(uri,params,Request.POST) ;

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(funRequest.url())
                .headers(funRequest.headers())
                .post(funRequest.body())
                .build();

        return send(request) ;
    }


    private static Response send(okhttp3.Request request){
        try {
            okhttp3.Response response = client.newCall(request).execute() ;
            if(response.isSuccessful()){
                String body = response.body().string() ;
                return JSON.parseObject(body,Response.class) ;
            }else {
                return new Response(response.code(),response.message()) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Response(-1,e.getMessage()) ;
        }
    }

    private static class Request {

        public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

        private static final int GET = 1 ;
        private static final int POST = 2 ;

        private String uri ;
        private String url ;
        private String params ;

        private Headers headers ;
        private RequestBody body ;

        private Request(String uri, Map<String,?> params,int method){
            this.uri = uri ;
            this.url = Utils.JointUrl(HOST,uri) ;
            build(params,method);
        }

        private void build(Map<String,?> params,int method){
            this.params = Utils.JointParams(params) ;
            switch (method){
                case POST:
                    this.body = RequestBody.create(JSON_TYPE,JSON.toJSONString(params)) ;
                    break;
                case GET:
                default:
                    this.url = this.url+"?"+this.params ;
            }
        }

        public String url(){
            return url ;
        }

        public Headers headers() {
            if(headers==null){
                String nonce = Utils.RandomString(10) ;

                String timestamp = String.valueOf(System.currentTimeMillis()/1000);

                String sign = Utils.Encrypt(String.join("|",new  String[]{nonce,SECRET,timestamp,uri,params})) ;

                headers = new Headers.Builder()
                        .add("Content-Type","application/json; charset=utf-8")
                        .add("Accept-ApiKey",KEY)
                        .add("Accept-ApiNonce",nonce)
                        .add("Accept-ApiTime",timestamp)
                        .add("Accept-ApiSign",sign)
                        .build() ;
            }
            return headers;
        }

        public RequestBody body(){
            return body ;
        }
    }

    public static class Response {

        private Integer retcode ;
        private String message ;
        private Object data ;

        public Response(){}

        private Response(Integer code, String message){
            this.retcode = code ;
            this.message = message ;
        }

        public Integer getRetcode() {
            return retcode;
        }

        public void setRetcode(Integer retcode) {
            this.retcode = retcode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

}
