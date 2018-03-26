package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;

/**
 * @Author: linfujun
 * @Description: 腾讯公众平台访问服务
 * @Date: Created on 0:44 2018/3/25
 */
public interface AccessService {
    AccessTokenResponse getAccessToken(GetaAccessTokenParam param) throws DangjianException;
}
