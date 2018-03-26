package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.rest.HttpWebApi;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.constant.RequestUrls;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.BaseService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.TokenBasedService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.TokenBasedHttpClient;
import org.springframework.stereotype.Service;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 16:57 2018/3/25
 */
@Service
public class CustomMenuServiceImpl extends TokenBasedService implements CustomMenuService {

    public CustomMenuServiceImpl(TokenBasedHttpClient client) {
        super(client);
    }

    @Override
    public BaseMpApiResponse createMenu(String json) throws DangjianException {
        return  postAtomEntity(RequestUrls.GREATE_MENU_PREFIX, json, BaseMpApiResponse.class);
    }

}
