package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.rest.HttpWebApi;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.common.AccessTokenProvider;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.constant.RequestUrls;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.TokenBasedService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.CommonUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.LocalCache;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.TokenBasedHttpClient;

import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 16:57 2018/3/25
 */
@Service
public class UserInfoServiceImpl extends TokenBasedService implements UserInfoService {
    Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private AccessService accessService;

    public UserInfoServiceImpl(TokenBasedHttpClient client) {
        super(client);
    }

    @Override
    public JSONObject userInfo(GetUserInfo getUserInfo) throws DangjianException {
        JSONObject jsonObject;
        try {
            String Token = LocalCache.TOKEN_CACHE.getIfPresent("ACCESS_TOKEN");
            if (null == Token || "".equals(Token)) {
                GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
                getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
                getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
                getaAccessTokenParam.setGrantType(GrantType.client_credential);
                AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
                Token = accessTokenResponse.getAccessToken();
            }
            String url = RequestUrls.USER_INFO_PREFIX +"?access_token="+Token+"&openid="+getUserInfo.getOpenid()+"&lang=zh_CN";
            jsonObject =  CommonUtil.httpsRequest(url, "GET",null);

            if (!jsonObject.has("success") || !jsonObject.getBoolean("success")) {
                logger.error("Get wx userinfo error, result jsonObject=" + jsonObject.toString());

                throw new RuntimeException("Get wx userInfo error.");
            }
        } catch (DangjianException e) {
            logger.error("", e);

            return null;
        }

        return jsonObject;
    }
}
