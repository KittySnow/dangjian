package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileWxMsgHead;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

/**
 * 类MobileWxMsgHeadMapperBiz.java的描述： 微信消息接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
@Transactional
public interface MobileWxMsgHeadMapperBiz {
	
	/**
	 * 添加微信消息
	 * 
	 * @param mobileWxMsgHead
	 * @return
	 */
	int insert(MobileWxMsgHead mobileWxMsgHead);
	
	/**
	 * 根据微信请求消息创建微信消息对象
	 * 
	 * @param jsonObject
	 * @return
	 */
	MobileWxMsgHead createMobileWxMsgHead(JSONObject jsonObject, Integer pharmacyId);
	
}
