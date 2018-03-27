package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileAtiveArticles;

import java.util.List;



/**
 * 类MobileAtiveArticlesMapperBiz.java的描述： 主动图文接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobileAtiveArticlesMapperBiz {
	
	/**
	 * 添加主动图文
	 * 
	 * @param mobileAtiveArticles
	 * @param pharmacyId
	 */
	int addMobileAtiveArticlesList(List<MobileAtiveArticles> mobileAtiveArticles, Integer pharmacyId);
	
	/**
	 * 获取用户主动图文素材
	 * 
	 * @param pharmacyId
	 * @return
	 */
	List<MobileAtiveArticles> getMobileAtiveArticlesByPharmacyId(Integer pharmacyId);
	
	/**
	 * 更新图文MediaId并返回
	 * 
	 * @param mobileAtiveArticles
	 * @param pharmacyId
	 * @return
	 */
	String getMobileAtiveArticlesMediaId(MobileAtiveArticles mobileAtiveArticles, Integer pharmacyId);
	
	/**
	 * 获取MobileAtiveArticles by id
	 * 
	 * @param id
	 * @return
	 */
	MobileAtiveArticles getMobileAtiveArticlesById(String id);
	
	/**
	 * 删除图文消息by id
	 * 
	 * @param id
	 * @param pharmacyId
	 * @return
	 */
	void deleteAtiveArticlesById(String id, Integer pharmacyId);
	
	/**
	 * 获取子图文
	 * 
	 * @param id
	 * @param pharmacyId
	 * @return
	 */
	List<MobileAtiveArticles> getSubMobileAtiveArticles(String id, Integer pharmacyId);
	
	/**
	 * 上传图文素材获取获取MediaId
	 * 
	 * @param ativeArticles
	 * @param accessToken
	 * @return
	 */
	String uploadnews(MobileAtiveArticles ativeArticles, String accessToken);
	
}
