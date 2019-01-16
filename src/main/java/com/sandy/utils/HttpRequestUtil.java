package com.sandy.utils;

import com.sandy.domain.HttpAPIRequest;

import java.util.Calendar;

/**
 * @ClassName: HttpRequestUtil
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

public class HttpRequestUtil {

    //单例模式调用
    private HttpRequestUtil() { }

    private static HttpRequestUtil httpRequestUtil = new HttpRequestUtil();

    //静态工厂方法
    public static HttpRequestUtil getInstance(){ return httpRequestUtil;}

//    public HttpAPIRequest httpAPIRequest;
    public final static String FORMAT = "json";
    public final static String NONCE = "80bb50cffa65451582a1ec2e1a0fd512";
    public final static String VERSION = "1.0";

//    public enum Env{
//        QA,  //测试环境
//        PRE, //运营演示环境
//        PRDTEST; //预发布环境
//    }
//
//    public enum Port{
//        PORT1(8000),
//        PORT2(8001),
//        PORT3(8003),
//        PORT4(8005);
//
//        public int portNum;
//
//        Port(int portNum){
//            this.portNum = portNum;
//        }
//    }

    public void GeneHttpRequestUtil(String method, String data, String appid, String appsecret){

        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String source = ("appid=" + appid + "&" +  "data=" + data + "&" + "format=" + FORMAT
                + "&" + "method=" + method + "&" + "nonce=" + NONCE + "&" + "timestamp=" + timestamp
                + "&" + "version=" + VERSION + "&" + "appsecret=" + appsecret).toLowerCase();

        //MD5校验

    }

    public void ExeHttpRequestUtil(String env, String port){



    }

}
