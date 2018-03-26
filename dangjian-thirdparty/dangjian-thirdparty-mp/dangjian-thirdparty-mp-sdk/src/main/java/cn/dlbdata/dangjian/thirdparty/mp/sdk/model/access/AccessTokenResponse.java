package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 1:16 2018/3/25
 */
public class AccessTokenResponse extends BaseMpApiResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
