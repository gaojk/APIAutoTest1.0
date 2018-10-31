package com.sandy.utils;

/**
 * @ClassName: HttpRequestUtil
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

public class HttpRequestUtil {

    private HttpRequest httpRequest;
    public final static String APPID = "T12345678";
    public final static String APPSECRET = "HelloCSCEC2017";
    public final static String FORMAT = "json";
    public final static String NONCE = "80bb50cffa65451582a1ec2e1a0fd512";
    public final static String VERSION = "1.0";

    public enum Env{
        QA,  //测试环境
        PRE, //运营演示环境
        PRDTEST; //预发布环境

    }

    public enum Port{
        PORT1(8000),
        PORT2(8001),
        PORT3(8003),
        PORT4(8005);

        public int portNum;

        Port(int portNum){
            this.portNum = portNum;
        }
    }

    public HttpRequest GeneHttpUtil(String method, String data){

        return null;
    }

}
