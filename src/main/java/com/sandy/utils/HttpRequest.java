package com.sandy.utils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName: HttpRequest
 * @Author sandy.n.hao
 * @Date: 2018/10/30
 * @Version v1.0.0
 * @Description: //TODO
 */

public class HttpRequest implements Serializable {

    private String appid;
    private String format;
    private String method;
    private String nonce;
    private String timestamp;
    private String version;
    private String appsecret;
    private String data;
    private String sign;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpRequest that = (HttpRequest) o;
        return Objects.equals(appid, that.appid) &&
                Objects.equals(format, that.format) &&
                Objects.equals(method, that.method) &&
                Objects.equals(nonce, that.nonce) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(version, that.version) &&
                Objects.equals(appsecret, that.appsecret) &&
                Objects.equals(data, that.data) &&
                Objects.equals(sign, that.sign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appid, format, method, nonce, timestamp, version, appsecret, data, sign);
    }
}
