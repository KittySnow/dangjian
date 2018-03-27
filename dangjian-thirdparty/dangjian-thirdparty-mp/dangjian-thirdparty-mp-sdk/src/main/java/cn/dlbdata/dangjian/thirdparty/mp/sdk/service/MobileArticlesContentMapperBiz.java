package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileArticlesContent;

/**
 * 类MobileArticlesContentMapperBiz.java的描述： 主动图文内容接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobileArticlesContentMapperBiz {
	
	/**
	 * 获取主动图文内容by id
	 * 
	 * @param id
	 * @return
	 */
	MobileArticlesContent getarticlesContentByArticlesId(String id);
	
	/**
	 * 添加主动图文内容
	 * 
	 * @param content
	 * @param articlesId
	 * @return
	 */
	MobileArticlesContent addMobileArticlesContent(String content, String articlesId);
	
	/**
	 * 删除主动图文内容
	 * 
	 * @param id
	 */
	void deleteMobileArticlesContentById(String id);
	
}
