package cn.dlbdata.dangjian.thirdparty.mp.sdk.common;

import cn.dlbdata.dangjian.common.DangjianException;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 17:29 2018/2/7
 */
public interface AccessTokenProvider {
    public String getAccessToken() throws DangjianException;
}
