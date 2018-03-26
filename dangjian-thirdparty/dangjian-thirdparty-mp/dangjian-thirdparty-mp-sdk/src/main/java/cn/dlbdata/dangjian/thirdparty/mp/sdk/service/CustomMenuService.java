package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.constant.RequestUrls;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;

/**
 * @Author: linfujun
 * @Description: 自定义菜单服务
 * @Date: Created on 1:24 2018/3/25
 */
public interface CustomMenuService {
    
    public BaseMpApiResponse createMenu(String json) throws DangjianException ;

}
