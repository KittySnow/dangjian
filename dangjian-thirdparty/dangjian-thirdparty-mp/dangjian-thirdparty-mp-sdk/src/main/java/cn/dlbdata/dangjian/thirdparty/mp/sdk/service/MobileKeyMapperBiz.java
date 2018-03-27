package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileKey;

import java.util.List;
/**
 * 类MobileKeyMapperBiz.java的描述： 关键字接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobileKeyMapperBiz {
	
	/**
	 * 关键字匹配
	 * 
	 * @param keyword
	 * @return
	 */
	MobileKey matchingKeyword(String keyword, Integer pharmacyId);
	
	/**
	 * 通过pharmacyId获取关注事件的MobileKey
	 * 
	 * @param pharmacyId
	 * @return
	 */
	MobileKey subscribeEventKeyword(Integer pharmacyId);
	
	/**
	 * 保存关注事件key
	 * 
	 * @param id
	 * @return
	 */
	void saveSubscribeEventKeyword(String id, Integer pharmacyId);
	
	/**
	 * 匹配key
	 * 
	 * @param key
	 * @return
	 */
	MobileKey matchingKey(String key, Integer pharmacyId);
	
	/**
	 * 添加关键字和key
	 * 
	 * @param mobileKey
	 * @return
	 */
	int addMobileKey(MobileKey mobileKey);
	
	/**
	 * 通过id获取关键字
	 * 
	 * @param id
	 * @return
	 */
	MobileKey selectMobileKeyById(String id);
	
	/**
	 * 通过pharmacyId获取关键字
	 * 
	 * @param pharmacyId
	 * @return
	 */
	List<MobileKey> selectMobileKeyByPharmacyId(Integer pharmacyId);
	
	/**
	 * 通过id删除
	 * 
	 * @param mobileKey
	 * @return
	 */
	int updateMobileKeyById(MobileKey mobileKey);
	
	/**
	 * 删除关键字
	 * 
	 * @param id
	 * @return
	 */
	int deleteMobileKeyById(String id, Integer pharmacyId);
	
}
