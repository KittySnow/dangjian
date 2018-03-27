package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

/**
 * 类ReceiveMobileService.java的实现描述： 移动业务处理业务动作分发器接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface ReceiveMobileService {
	
	/**
	 * 效验微信接入
	 * 
	 * @param pharmacyId
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	boolean chechkWxSignature(Integer pharmacyId, String signature, String timestamp, String nonce);
	
	/**
	 * 处理微信请求并返回对应xml信息
	 * 
	 * @param jsonObject
	 * @return
	 */
	String receiveMobileServiceWx(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 处理支付宝请求消息并返回对应xml信息
	 * 
	 * @param params
	 * @return
	 */
	String receiveMobileServiceAli(Map<String, String> params, Integer pharmacyId) throws Exception;
	
	/**
	 * 用户信息共享（获取用户信息）
	 * 
	 * @param params
	 */
	void loginAuthService(Map<String, String> params, Integer pharmacyId);
	
	
	
}
