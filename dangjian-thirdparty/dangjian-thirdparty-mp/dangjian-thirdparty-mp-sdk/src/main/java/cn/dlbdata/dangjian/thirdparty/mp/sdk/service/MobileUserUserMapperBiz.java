package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileUserUser;
import org.springframework.transaction.annotation.Transactional;


/**
 * 类MobileUserUserMapperBiz.java的描述：使用用户处理接口
 * 
 * @author Administrator
 *
 */
@Transactional
public interface MobileUserUserMapperBiz {
	
	/**
	 * 通过用户pharmacyId获取用户信息
	 * 
	 * @param pharmacyId
	 * @return
	 */
	MobileUserUser getMobileUserUserByPharmacyId(Integer pharmacyId);
	
	/**
	 * 通过用户微信号获取用户信息
	 * 
	 * @param userName
	 * @return
	 */
	MobileUserUser getMobileUserUserByWxId(String userName);
	
	/**
	 * 通过支付宝服务窗账号ID获取用户信息
	 * 
	 * @param appId
	 * @return
	 */
	MobileUserUser getMobileUserUserByAliId(String appId);
	
	/**
	 * 效验微信用户是否在平台注册并返回
	 * 
	 * @param userName
	 * @param pharmacyId
	 * @return
	 */
	MobileUserUser chackMobileUserUser(String userName, Integer pharmacyId);
	
	/**
	 * 获取AccessToken
	 * 
	 * @param pharmacyId
	 * @return
	 */
	String getAccessToken(int pharmacyId);
	
}
