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
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.TokenBasedHttpClient;

import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
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

    public UserInfoServiceImpl(TokenBasedHttpClient client) {
        super(client);
    }

    @Autowired
    private AccessService accessService;




    @Override
    public JSONObject userInfo(GetUserInfo getUserInfo) throws DangjianException {

        JSONObject jsonObject = new JSONObject();
        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        try {
            AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
            String Token  = accessTokenResponse.getAccessToken();
            String url = RequestUrls.USER_INFO_PREFIX +"?access_token="+Token+"&openid="+getUserInfo.getOpenid()+"&lang=zh_CN";
            jsonObject =  CommonUtil.httpsRequest(url, "GET",null);

        } catch (DangjianException e) {
            e.printStackTrace();
        }


        return jsonObject;
    }


}
