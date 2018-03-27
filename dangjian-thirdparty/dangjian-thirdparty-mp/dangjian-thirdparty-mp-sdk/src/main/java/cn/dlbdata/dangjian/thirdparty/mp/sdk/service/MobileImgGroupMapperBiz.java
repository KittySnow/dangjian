package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileImgGroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



/**
 * 类MobileImgGroupMapperBiz.java的描述： 图片分组接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */

public interface MobileImgGroupMapperBiz {
	
	/**
	 * 获取用户图片素材分组
	 * 
	 * @param pharmacyId
	 * @return
	 */
	List<MobileImgGroup> getMobileImgGroupByPharmacyId(Integer pharmacyId);
	
	/**
	 * 通过id获取图片分组
	 * 
	 * @param id
	 * @return
	 */
	MobileImgGroup getMobileImgGroupById(String id);
	
	/**
	 * 添加图片素材分组
	 * 
	 * @param imgGroup
	 * @return
	 */
	int addMobileImgGroup(MobileImgGroup imgGroup);
	
	/**
	 * 修改图片素材分组
	 * 
	 * @param imgGroup
	 * @return
	 */
	int updateMobileImgGroupById(MobileImgGroup imgGroup);
	
	/**
	 * 删除图片分组
	 * 
	 * @param id
	 * @param pharmacyId
	 * @return
	 */
	int deleteImageGroupById(String id, Integer pharmacyId);
	
	/**
	 * 获取默认图片素材分组
	 * 
	 * @param pharmacyId
	 * @return
	 */
	public MobileImgGroup getDefaultMobileImgGroup(Integer pharmacyId);
}
