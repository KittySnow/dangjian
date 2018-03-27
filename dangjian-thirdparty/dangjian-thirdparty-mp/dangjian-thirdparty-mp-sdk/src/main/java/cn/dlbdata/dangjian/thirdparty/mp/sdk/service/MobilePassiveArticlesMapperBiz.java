package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobilePassiveArticles;

import java.util.List;


/**
 * 类MobilePassiveArticlesMapperBiz.java的描述： 被动图文接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobilePassiveArticlesMapperBiz {
	
	/**
	 * 获取被动图文消息by id
	 * 
	 * @param id
	 * @return
	 */
	MobilePassiveArticles getMobilePassiveArticlesById(String id);
	
	/**
	 * 获取用户被动图文素材
	 * 
	 * @param pharmacyId
	 * @return
	 */
	List<MobilePassiveArticles> getMobilePassiveArticlesByPharmacyId(Integer pharmacyId);
	
	/**
	 * 批量添加被动图文
	 * 
	 * @param passiveArticleList
	 */
	int addMobilePassiveArticles(List<MobilePassiveArticles> passiveArticleList, Integer pharmacyId);
	
	/**
	 * 删除图文消息
	 * 
	 * @param id
	 * @param pharmacyId
	 */
	void deletePassiveArticlesById(String id, Integer pharmacyId);
	
}
