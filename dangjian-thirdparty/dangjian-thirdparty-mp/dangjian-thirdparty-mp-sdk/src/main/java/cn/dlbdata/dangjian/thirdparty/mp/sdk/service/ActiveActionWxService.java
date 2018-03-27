package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import java.util.Map;



/**
 * 类ActiveActionWxService.java的描述： 主动微信请求接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface ActiveActionWxService {
	
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
