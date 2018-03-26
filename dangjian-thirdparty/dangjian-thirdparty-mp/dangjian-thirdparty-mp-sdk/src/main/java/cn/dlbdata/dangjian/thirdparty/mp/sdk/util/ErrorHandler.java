package cn.dlbdata.dangjian.thirdparty.mp.sdk.util;

import cn.dlbdata.dangjian.common.DangjianException;

/**
 * @Author: linfujun
 * @Description: 错误码
 * @Date: Created on 10:10 2017/12/28
 */
public class ErrorHandler {
    public static final int PARSE_TO_OBJECT_ERROR = 110000;
    public static final int ACCESS_TOKEN_NOT_SET = 110001;

    public static DangjianException accessTokenNotSet() {
        return new DangjianException(ACCESS_TOKEN_NOT_SET, "This method needs access token to gain accessability");
    }
}
