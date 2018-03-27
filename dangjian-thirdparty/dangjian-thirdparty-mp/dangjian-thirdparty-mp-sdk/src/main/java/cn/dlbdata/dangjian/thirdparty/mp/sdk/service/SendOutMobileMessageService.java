package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;

import java.util.Map;

/**
 * @Author: linfujun
 * @Description: 自定义菜单服务
 * @Date: Created on 1:24 2018/3/25
 */
public interface SendOutMobileMessageService {

    /**
     * 群发发送文本消息
     *
     * @param map
     * @param content
     * @return
     */
    String sendOutTextGroupMessage(Map<String, String> map, String content);

    /**
     * 群发图片消息
     *
     * @param map
     * @param pid
     * @return
     */
    String sendOutImageGroupMessage(Map<String, String> map, String pid);

    /**
     * 群发送图文消息
     *
     * @param map
     * @param activeArticleid
     * @return
     */
    String sendOutNewsGroupMessage(Map<String, String> map, String activeArticleid);
}
