package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import java.util.List;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileWxAttentionUser;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.PageUtil;
import net.sf.json.JSONObject;

import org.springframework.transaction.annotation.Transactional;



/**
 * 类MobileWxAttentionUserMapperBiz.java的描述： 微信关注者用户接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
@Transactional
public interface MobileWxAttentionUserMapperBiz {
	
	/**
	 * 通过id获取用户
	 * 
	 * @param id
	 * @return
	 */
	MobileWxAttentionUser getWxUserById(String id);
	
	/**
	 * 通过微信openID拉取用户信息
	 * 
	 * @param openID
	 * @return
	 */
	MobileWxAttentionUser pullWxUserInformation(Integer pharmacyId, String openID);
	
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 * @return
	 */
	MobileWxAttentionUser saveWxAttentionUser(JSONObject user, Integer pharmacyId);
	
	/**
	 * 修改用户信息
	 * 
	 * @param wxAttentionUser
	 * @return
	 */
	void updateWxAttentionUser(MobileWxAttentionUser wxAttentionUser);
	
	/**
	 * 取消订阅
	 * 
	 * @param openID
	 * @return
	 */
	int unsubscribeWxAttentionUser(String openID);
	
	/**
	 * 通过openId获取关注者
	 * 
	 * @param openID
	 * @return
	 */
	MobileWxAttentionUser getWxAttentionUserByOpenId(String openID, Integer isSubscribe);
	
	/**
	 * 获取关注者by groupid
	 * 
	 * @param groupId
	 * @return
	 */
	List<MobileWxAttentionUser> getMobileWxAttentionUserByGroupId(Integer pharmacyId, String groupId, PageUtil pageUtil);
	
	/**
	 * 拉取所有关注者信息
	 * 在添加保存好用户微信信息后调用
	 * 一定是在action中调用
	 * 
	 * @param pharmacyId
	 */
	void pullAttentionUserInformationByPharmacyId(Integer pharmacyId, int n);
	
	/**
	 * 查询微信关注者用户
	 * 
	 * @param mobileWxAttentionUser
	 * @return
	 */
	List<MobileWxAttentionUser> selectMobileWxAttentionUser(MobileWxAttentionUser mobileWxAttentionUser);
	
	/**
	 * 统计总数
	 * 
	 * @param mobileWxAttentionUser
	 * @return
	 */
	int countInfoWxCustomer(MobileWxAttentionUser mobileWxAttentionUser);
	
	/**
	 * 移动用户分组
	 * 
	 * @param ids
	 * @param groupId
	 * @param pharmacyId
	 */
	void moveUserToGroup(String[] ids, String groupId, Integer pharmacyId);
	
}
