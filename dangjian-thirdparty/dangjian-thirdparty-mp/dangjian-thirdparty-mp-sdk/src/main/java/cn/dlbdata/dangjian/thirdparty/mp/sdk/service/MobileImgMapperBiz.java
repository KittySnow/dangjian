package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.MobileImg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



/**
 * 类ReceiveMobileServiceImpl.java的描述： 图片接口
 * 
 * @author lxl 2014年10月24日 下午15:38:54
 * 
 */
public interface MobileImgMapperBiz {
	
	/**
	 * 通过id获取图片
	 * 
	 * @param id
	 * @return
	 */
	MobileImg getMobileImgById(String id);
	
	/**
	 * 更新图片素材
	 * 
	 * @param mobileImg
	 * @return
	 */
	MobileImg updateMobileImg(MobileImg mobileImg);
	
//	/**
//	 * 上传图片素材获取Media
//	 * 
//	 * @param mobileImg
//	 * @return
//	 */
//	MobileImg uploadMobileImgGetMedia(MobileImg mobileImg);
	
	/**
	 * 下载图片素材并保存
	 * 
	 * @param mediaId
	 * @return
	 */
	MobileImg downloadMobileImgByMediaId(Integer pharmacyId, String mediaId);
	
	/**
	 * 分组获取图片
	 * 
	 * @param pharmacyId
	 * @param groupId
	 * @return
	 */
	List<MobileImg> getMobileImgByGroupId(Integer pharmacyId, String groupId);
	
	/**
	 * 添加图片素材
	 * 
	 * @param img
	 * @return
	 */
	int addMobileImg(MobileImg img);
	
	/**
	 * 批量添加图片素材
	 * 
	 * @param imgList
	 * @return
	 */
	int addMobileImgList(List<MobileImg> imgList);
	
	/**
	 * 更新图片MediaId并返回
	 * 
	 * @param mobileImg
	 * @return
	 */
	String updateMobileImgMediaId(MobileImg mobileImg, String accessToken);
	
	/**
	 * 批量删除图片
	 * 
	 * @param ids
	 */
	int deleteImageByIds(List<String> ids);
	
	/**
	 * 删除图片by id
	 * 
	 * @param id
	 * @return
	 */
	int deleteImageById(String id);
	
	/**
	 * 图片上传
	 * 
	 * @param request
	 * @param user
	 * @param contentType
	 * @return
	 */
	List<MobileImg> materialsUpload(HttpServletRequest request, PUser user, String contentType);
	
	/**
	 * 修改图片分组
	 * 
	 * @param ids
	 * @param groupId
	 * @param pharmacyId
	 */
	void moveImageToGroup(String[] ids, String groupId, Integer pharmacyId);
	
}
