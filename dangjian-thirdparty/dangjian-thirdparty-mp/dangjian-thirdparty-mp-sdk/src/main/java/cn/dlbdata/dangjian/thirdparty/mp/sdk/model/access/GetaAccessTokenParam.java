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
}
