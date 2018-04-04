package cn.dlbdata.dangjian.thirdparty.mp.sdk.constant;

import static cn.dlbdata.dangjian.thirdparty.mp.sdk.config.DefaultConfigs.API_URL_PREFIX;

/**
 * @Author: linfujun
 * @Description: 存放所有请求url
 * @Date: Created on 14:24 2017/12/13
 */
public class RequestUrls {

  /**
   * 获取access_token 请求url前缀
   */
  public static final String GAIN_ACCESS_TOKEN_PREFIX = API_URL_PREFIX + "token";

  public static final String GREATE_MENU_PREFIX = API_URL_PREFIX + "menu/create";

  public static final String USER_INFO_PREFIX = API_URL_PREFIX + "user/info";

}
