package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileWxAttentionUserLocation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

/**
 * 类MobileWxAttentionUserLocationMapperBiz.java的描述： 微信关注者用户地理位置接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
@Transactional
public interface MobileWxAttentionUserLocationMapperBiz {
	
	/**
	 * 保存微信关注者地理位置信息
	 * 
	 * @param jsonObject
	 * @return
	 */
	MobileWxAttentionUserLocation saveWxAttentionUserLocation(JSONObject jsonObject, Integer pharmacyId);
	
	/**
	 * 获取微信关注者地理位置by openid
	 * 
	 * @param openID
	 * @return
	 */
	MobileWxAttentionUserLocation getWxAttentionUserLocation(String openID);
	
	
}
