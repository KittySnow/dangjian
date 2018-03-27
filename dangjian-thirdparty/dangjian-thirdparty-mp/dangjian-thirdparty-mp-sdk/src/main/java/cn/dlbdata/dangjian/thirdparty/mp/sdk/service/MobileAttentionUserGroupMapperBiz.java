package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileAttentionUserGroup;

import java.util.List;

/**
 * 类MobileAttentionUserGroupMapperBiz.java的描述： 关注用户分组接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobileAttentionUserGroupMapperBiz {
	
	/**
	 * 获取微信关注者用户分组
	 * 
	 * @param pharmacyId
	 * @return
	 */
	List<MobileAttentionUserGroup> getWxAttentionUserGroupByPharmacyId(Integer pharmacyId);
	
	/**
	 * 通过id获取分组
	 * 
	 * @param id
	 * @return
	 */
	MobileAttentionUserGroup getMobileAttentionUserGroupById(String id);
	
	/**
	 * 添加关注者用户分组
	 * 
	 * @param attentionUserGroup
	 * @return
	 */
	int addMobileAttentionUserGroup(MobileAttentionUserGroup attentionUserGroup);
	
	/**
	 * 修改关注者用户分组
	 * 
	 * @param attentionUserGroup
	 * @return
	 */
	int updateMobileAttentionUserGroup(MobileAttentionUserGroup attentionUserGroup);
	
	/**
	 * 删除关注者用户分组
	 * 
	 * @param id
	 * @param pharmacyId
	 * @return
	 */
	int deleteGroupById(String id, Integer pharmacyId);
	
	/**
	 * 获取默认分组
	 * 
	 * @param pharmacyId
	 * @param type
	 * @return
	 */
	MobileAttentionUserGroup getDefaultWxAttentionUserGroup(Integer pharmacyId, Integer type);
	
}
