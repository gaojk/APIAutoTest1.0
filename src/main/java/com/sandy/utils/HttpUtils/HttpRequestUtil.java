package com.sandy.utils.HttpUtils;

import com.sandy.utils.MD5Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * @ClassName: HttpRequestUtil
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

public class HttpRequestUtil {

    //单例模式调用
//    public HttpRequestUtil() { }
//
//    private static HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
//
//    //静态工厂方法
//    public static HttpRequestUtil getInstance(){ return httpRequestUtil; }

    public static HttpAPIRequest httpAPIRequest = new HttpAPIRequest();
    public static HttpClient httpClient = new DefaultHttpClient();

    public final static String FORMAT = "json";
    public final static String NONCE = "80bb50cffa65451582a1ec2e1a0fd512";
    public final static String VERSION = "1.0";

    static MD5Utils md5Utils = new MD5Utils();

    public enum Env{
        QA("http://api.mall.yzw.cn.qa:"),
        PRE("http://api.mall.cscec.com.pre:16000"),
        PRDTEST("https://mallapi.yzw.cn:8081");

        String url;

        Env(String url){ this.url = url; }
    }

    public static void GeneHttpRequestUtil(String method, String data, String appid, String appsecret){

        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());

        String source = ("appid=" + appid + "&" +  "data=" + data + "&" + "format=" + FORMAT
                + "&" + "method=" + method + "&" + "nonce=" + NONCE + "&" + "timestamp=" + timestamp
                + "&" + "version=" + VERSION + "&" + "appsecret=" + appsecret).toLowerCase();

        //MD5校验
        String sign = md5Utils.getStringMD5(source);

        httpAPIRequest.setAppid(appid);
        httpAPIRequest.setAppsecret(appsecret);
        httpAPIRequest.setTimestamp(timestamp);
        httpAPIRequest.setFormat(FORMAT);
        httpAPIRequest.setMethod(method);
        httpAPIRequest.setNonce(NONCE);
        httpAPIRequest.setVersion(VERSION);
        httpAPIRequest.setData(data);
        httpAPIRequest.setSign(sign);

    }

    public static String ExeHttpRequestUtil(String env, String port){

        //
        String url = null;
        String result = null;

        for(Env enumenv : Env.values())
        {
            if (enumenv.toString().equals(env))
            {
                if(env.equals("QA"))
                {
                    url = enumenv.url + port + "/open.api";
                }
                else{
                    url = enumenv.url;
                }
                break;
            }

        }

        if(url == null)
            return ("incorrect request url");

        Map map = new HashMap<String,String>();
        map.put("method",httpAPIRequest.getMethod());
        map.put("version",httpAPIRequest.getVersion());
        map.put("appid",httpAPIRequest.getAppid());
        map.put("format",httpAPIRequest.getFormat());
        map.put("timestamp",httpAPIRequest.getTimestamp());
        map.put("nonce",httpAPIRequest.getNonce());
        map.put("sign",httpAPIRequest.getSign());
        map.put("data",httpAPIRequest.getData());

        try{

            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            //设置参数
            List<NameValuePair> list = new ArrayList();

            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"utf-8");
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {

        HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
        httpRequestUtil.GeneHttpRequestUtil("Product.UpProductStock",
                "[{\"ProductGroupItemSysNo\": 25884,\"Stock\": 300,\"StockSysNo\": 10295,\"StandingStock\":1000}]",
                "gys003sandy",
                "abcd");
        String resp = httpRequestUtil.ExeHttpRequestUtil("QA","8000");

        System.out.println(resp);

    }
}
