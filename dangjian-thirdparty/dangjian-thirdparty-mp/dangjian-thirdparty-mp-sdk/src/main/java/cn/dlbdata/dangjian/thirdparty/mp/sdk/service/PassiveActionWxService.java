package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;


import com.alibaba.fastjson.JSONObject;

/**
 * 类PassiveActionWxService.java的描述： 微信被动请求接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface PassiveActionWxService {
	
	/**
	 * 处理接收文本消息
	 * 
	 * @param jsonObject
	 * @return
	 */
	String textMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 处理接收图片消息
	 * 
	 * @param jsonObject
	 * @return
	 */
	void imageMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 处理关注事件
	 * 
	 * @param jsonObject
	 * @return
	 */
	String subscribeEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 处理扫描二维码事件
	 * 
	 * @param jsonObject
	 * @return
	 */
	String subscribeEventKeyMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 处理取消订阅事件
	 * 
	 * @param jsonObject
	 */
	void unsubscribeEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 已关注时的事件(已关注用户再次扫描二维码)
	 * 
	 * @param jsonObject
	 * @return
	 */
	String SCANEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 上报地理位置事件
	 * 
	 * @param jsonObject
	 * @return
	 */
	void LOCATIONEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 点击菜单拉取消息时的事件推送
	 * 
	 * @param jsonObject
	 * @return
	 */
	String CLICKEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 点击菜单跳转链接时的事件推送
	 * 
	 * @param jsonObject
	 * @return
	 */
	String VIEWEventMassege(JSONObject jsonObject, Integer pharmacyId);
	
	
}
