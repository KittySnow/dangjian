package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access;

import cn.dlbdata.dangjian.common.http.annotations.Param;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseParam;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 0:47 2018/3/25
 */
public class GetaAccessTokenParam extends BaseParam {

    @Param(key = "grant_type", required = true)
    private GrantType grantType;
    @Param(key = "appid", required = true)
    private String appid;
    @Param(key = "secret", required = true)
    private String secret;

    private String token;

    private long timestamp;

    private String nonceStr;

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    private String signature;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
