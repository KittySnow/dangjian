package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.common.AccessTokenProvider;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import org.springframework.stereotype.Component;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 17:21 2018/3/25
 */
@Component
public class SimpleAccessTokenProvider implements AccessTokenProvider {

    private AccessService accessService;

    public SimpleAccessTokenProvider(AccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public String getAccessToken() throws DangjianException {
        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
        return accessTokenResponse.getAccessToken();
    }
}
