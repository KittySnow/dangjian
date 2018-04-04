package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import net.sf.json.JSONObject;

/**
 * @Author: linfujun
 * @Description: 自定义菜单服务
 * @Date: Created on 1:24 2018/3/25
 */
public interface UserInfoService {

    public JSONObject userInfo(GetUserInfo getUserInfo) throws DangjianException ;

}
