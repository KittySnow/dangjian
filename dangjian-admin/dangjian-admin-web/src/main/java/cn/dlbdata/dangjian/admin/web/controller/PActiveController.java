package cn.dlbdata.dangjian.admin.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipate;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipateExample;
import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.query.ActiveQuery;
import cn.dlbdata.dangjian.admin.service.PActiveParticipateService;
import cn.dlbdata.dangjian.admin.service.PActiveService;
import cn.dlbdata.dangjian.admin.service.PDepartmentService;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.admin.service.PPictureService;
import cn.dlbdata.dangjian.admin.service.PScoreDetailService;
import cn.dlbdata.dangjian.admin.service.PScorePartyService;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.common.util.DateUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;

/**
 * @packageName PActiveController
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 活动接口
 */

@Controller
@RequestMapping("/active")
public class PActiveController {
	private static Logger _log = LoggerFactory.getLogger(PActiveController.class);

	@Autowired
	private PPartymemberService pPartymemberService;
	@Autowired
	private PUserService pUserService;

	@Autowired
	private PActiveService pActiveService;
	@Autowired
	private PPictureService pPictureService;

	@Autowired
	private PActiveParticipateService activeParticipateService;

	@Autowired
	private PScoreDetailService scoreDetailService;

	@Autowired
	private PScorePartyService pScorePartyService;

	@Autowired
	private PDepartmentService pDepartmentService;

	/**
	 * 创建活动
	 *
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> create(Long startTime, Long endTime, Integer activeType, Integer activeStatus,
			String activeName, String activePace, Integer activeCreatePeople, String departmentid,
			String activePrincipalPeople, String activeContext, String picids) {
		ResultUtil result = new ResultUtil();
		if (startTime == null) {
			result.setMsg("活动时间开始时间不能为空");
			result.setSuccess(false);
			return result.getResult();
		}
		if (activeType == null) {
			result.setMsg("请传入活动类型");
			result.setSuccess(false);
			return result.getResult();
		}
		PScoreDetail detail = scoreDetailService.selectByPrimaryKey(activeType);
		if (detail == null) {
			result.setMsg("活动类型找不到！");
			result.setSuccess(false);
			return result.getResult();
		}

		PActive active = new PActive();
		active.setStartTime(new Date(startTime));
		if (endTime != null) {
			active.setEndTime(new Date(endTime));
		}

		active.setActiveType(detail.getId());
		active.setActiveProjectId(detail.getProjectId());
		active.setActiveStatus(activeStatus);
		active.setActiveName(activeName);
		active.setActivePace(activePace);
		active.setActiveCreatePeople(activeCreatePeople);
		active.setDepartmentid(departmentid == null || "".equals(departmentid.trim()) ? null
				: Integer.valueOf(departmentid.split(",")[0].trim()));
		active.setActivePrincipalPeople(activePrincipalPeople);
		active.setActiveContext(activeContext);
		active.setCreateTime(new Date());
		active.setDepartIds(departmentid);
		active.setPicIds(picids);
		Integer id = pActiveService.insert(active);

		/*
		 * Integer[] arr = new Integer[]{};
		 * 
		 * 
		 * //当前活动为驿站生活的时候不用自动报名 if(activeType != 5){
		 * activeParticipateService.insertList( arr ,id); }
		 * 
		 * PPartymemberExample pPartymemberExample = new PPartymemberExample();
		 * PPartymemberExample.Criteria pPartymemberCriteria =
		 * pPartymemberExample.createCriteria();
		 * pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
		 * pPartymemberCriteria.andBidEqualTo(1); List<PPartymember> pPartymemberList =
		 * pPartymemberService.selectByExample(pPartymemberExample); for (PPartymember
		 * pPartymember:pPartymemberList){
		 * 
		 * arr. pPartymember.getUserid();
		 * 
		 * }
		 */

		result.setData(id);
		result.setSuccess(true);
		result.setMsg("创建成功！");
		return result.getResult();
	}

	/**
	 * 到场签名活动
	 *
	 * @param activeId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/approved", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> approved(Integer activeId, Integer userId) {
		ResultUtil result = new ResultUtil();
		PActive pActive = pActiveService.selectByPrimaryKey(activeId);
		if (pActive == null) {
			result.setMsg("活动不存在！");
			result.setSuccess(false);
			return result.getResult();
		}

		PUser pUser = pUserService.selectByPrimaryKey(userId);
		if (pUser == null) {
			result.setMsg("用户不存在！");
			result.setSuccess(false);
			return result.getResult();
		}
		if (pUser.getRoleid() != 4) {
			result.setMsg("当前用户不能签到");
			result.setSuccess(false);
			return result.getResult();
		}
		PActiveParticipateExample example = new PActiveParticipateExample();
		PActiveParticipateExample.Criteria ct = example.createCriteria();
		ct.andUserIdEqualTo(userId);
		ct.andActiveIdEqualTo(activeId);
		List<PActiveParticipate> list = activeParticipateService.selectByExample(example);
		if (list != null) {
			if (list.size() == 0) {
				result.setMsg("请先报名");
				result.setSuccess(false);
				return result.getResult();
			}
			PActiveParticipate participate = list.get(0);
			if (Integer.valueOf(1).equals(participate.getStatus())) {
				result.setMsg("请勿重复签到！");
				result.setSuccess(false);
				return result.getResult();
			}
			if (Integer.valueOf(2).equals(participate.getStatus())) {
				result.setMsg("不允许签到！");
				result.setSuccess(false);
				return result.getResult();
			}
			participate.setStatus(1);

			activeParticipateService.updateByPrimaryKeySelective(participate);

			// 签到成功后加积分
			PScoreParty pScoreParty = new PScoreParty();
			pScoreParty.setDetailId(pActive.getActiveType());
			pScoreParty.setUserId(userId);

			pScoreParty.setAdderId(pActive.getActiveCreatePeople());
			pScoreParty.setRecordId(participate.getActiveId());
			pScoreParty.setRecordType(1);
			pScoreParty.setRecordDesc(pActive.getActiveName());
			if (pScoreParty.getDetailId() == null || pScoreParty.getUserId() == null
					|| pScoreParty.getAdderId() == null) {
				result.setSuccess(false);
				result.setMsg("签到成功，请求加分参数不完整");
				return result.getResult();
			}
			if (pScorePartyService.updateScanCode(pScoreParty) > 0) {
				result.setSuccess(true);
				result.setMsg("签到成功,积分已发放");
				return result.getResult();
			}
			result.setSuccess(true);
			result.setMsg("签到成功，该项目积分已满或已发");
		} else {
			result.setMsg("请先报名");
			result.setSuccess(false);
		}
		return result.getResult();
	}

	/**
	 * 报名活动
	 *
	 * @param activeId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/participate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> participate(Integer activeId, Integer userId) {
		ResultUtil result = new ResultUtil();
		if (pActiveService.selectByPrimaryKey(activeId) == null) {
			result.setMsg("活动不存在！");
			result.setSuccess(false);
			return result.getResult();
		}
		if (pUserService.selectByPrimaryKey(userId) == null) {
			result.setMsg("用户不存在！");
			result.setSuccess(false);
			return result.getResult();
		}
		PActiveParticipateExample example = new PActiveParticipateExample();
		PActiveParticipateExample.Criteria ct = example.createCriteria();
		ct.andUserIdEqualTo(userId);
		ct.andActiveIdEqualTo(activeId);
		if (activeParticipateService.selectByExample(example).size() > 0) {
			result.setMsg("请勿重复报名");
			result.setSuccess(false);
			return result.getResult();
		}
		PActiveParticipate participate = new PActiveParticipate();
		participate.setCreateTime(new Date());
		participate.setUserId(userId);
		participate.setActiveId(activeId);
		participate.setStatus(0);
		activeParticipateService.insert(participate);

		result.setMsg("报名完成");
		result.setSuccess(true);

		return result.getResult();
	}

	private void initPictures(List<Map<String, Object>> activeList) {
		for (Map<String, Object> active : activeList) {
			PActivePictureExample picExample = new PActivePictureExample();
			PActivePictureExample.Criteria picCt = picExample.createCriteria();
			picCt.andActiveIdEqualTo(Integer.valueOf(active.get("id").toString()));
			// PageHelper.startPage(1, 3,true);
			List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
			active.put("pictures", picActiveList);
		}
	}

	/**
	 * @param departmentid
	 * @param pageNum
	 * @param pageSize
	 * @param all
	 * @return
	 * @author July july_sky@foxmail.com
	 * @date 2018-04-21 21:07:10
	 * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
	 * @version 1.0
	 */
	@RequestMapping(value = "/getRunningActive", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRunningActiveNew(Integer departmentid, Integer pageNum, Integer pageSize,
			@RequestParam(required = false) String all) {
		ResultUtil result = new ResultUtil();
		ActiveQuery activeQuery = new ActiveQuery();
		activeQuery.setPageYn(true);
		activeQuery.setPageNum(pageNum == null ? 1 : pageNum);
		activeQuery.setPageSize(pageSize == null ? 20 : pageSize);

		if (all != null && all.equals("Y")) {
			activeQuery.setStartTimeYn("Y");
		}
		activeQuery.setDepartmentId(departmentid);
		activeQuery.setActiveStatus(1);
		List<Map<String, Object>> pActiveList = pActiveService.getRunningActive(activeQuery);
		this.initPictures(pActiveList);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pActiveList);
		result.setSuccess(true);
		result.setData(pageInfo);
		return result.getResult();
	}

	// 查询已完成（组织生活）的活动
	@RequestMapping(value = "/getAlreadyActive", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAlreadyActive(Integer departmentid, Integer pageNum, Integer pageSize) {
		ResultUtil result = new ResultUtil();
		ActiveQuery activeQuery = new ActiveQuery();
		activeQuery.setPageYn(true);
		activeQuery.setPageNum(pageNum == null ? 1 : pageNum);
		activeQuery.setPageSize(pageSize == null ? 20 : pageSize);

		activeQuery.setStartTimeYn("Y");
		activeQuery.setDepartmentId(departmentid);
		activeQuery.setActiveStatus(2);
		activeQuery.setActiveProjectId(2);
		List<Map<String, Object>> pActiveList = pActiveService.getRunningActive(activeQuery);
		this.initPictures(pActiveList);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pActiveList);
		result.setSuccess(true);
		result.setData(pageInfo);
		return result.getResult();
	}

	/**
	 * 查询活动能看到 自己报没报名的
	 *
	 * @param userId
	 *            用户ID
	 * @param departmentid
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getParticipateActive", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getParticipateActive(Integer userId, Integer departmentid, Integer pageNum,
			Integer pageSize, @RequestParam(required = false) String all) {
		ResultUtil result = new ResultUtil();
		ActiveQuery activeQuery = new ActiveQuery();
		activeQuery.setPageYn(false);
		activeQuery.setPageNum(pageNum == null ? 1 : pageNum);
		activeQuery.setPageSize(pageSize == null ? 20 : pageSize);

		if (all != null && all.equals("Y")) {
			activeQuery.setStartTimeYn("Y");
		}
		activeQuery.setDepartmentId(departmentid);
		activeQuery.setActiveStatus(1);
		PUser pUser = pUserService.selectByPrimaryKey(userId);

		if (pUser != null) {
			if (pUser.getRoleid() == 4) {
				activeQuery.setEndTime(new Date());
			}
		}

		List<Map<String, Object>> pActiveList = pActiveService.getRunningActive(activeQuery);
		int id = -1;
		for (Map<String, Object> active : pActiveList) {
			id = Integer.valueOf(active.get("id").toString());
			active.put("signupstatus", hasParticipate(id, userId) ? 1 : 2);
			PActivePictureExample picExample = new PActivePictureExample();
			PActivePictureExample.Criteria picCt = picExample.createCriteria();
			picCt.andActiveIdEqualTo(id);
			// PageHelper.startPage(1, 3,true);
			active.put("pictures", pPictureService.selectActivePictures(picExample));
		}
		Collections.sort(pActiveList, new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				if (o1 == null || o2 == null) {
					return 0;
				}
				Integer signupstatus1 = (Integer) o1.get("signupstatus");
				Integer signupstatus2 = (Integer) o2.get("signupstatus");
				if (signupstatus1 > signupstatus2) {
					return -1;
				} else if (signupstatus1 < signupstatus2) {
					return 1;
				}
				return 0;
			}
		});

		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pActiveList);

		result.setSuccess(true);
		result.setData(pageInfo);
		return result.getResult();
	}

	@RequestMapping(value = "/getParticipateActiveCount", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getParticipateActiveCount(Integer userId, Integer departmentid) {
		ResultUtil result = new ResultUtil();
		ActiveQuery activeQuery = new ActiveQuery();
		activeQuery.setPageYn(false);

		activeQuery.setDepartmentId(departmentid);
		activeQuery.setActiveStatus(1);
		PUser pUser = pUserService.selectByPrimaryKey(userId);
		if (pUser != null) {
			if (pUser.getRoleid() == 4) {
				activeQuery.setEndTime(new Date());
			}
		}
		
		int count = pActiveService.getRunningActiveCount(activeQuery);

		result.setData(count);
		return result.getResult();
	}

	// 查看自己参与的活动
	@RequestMapping(value = "/getEnjoyActiveByUserId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEnjoyActiveByUserId(Integer userId, @RequestParam(required = false) String all) {
		ResultUtil result = new ResultUtil();
		PActiveExample example = new PActiveExample();
		PActiveExample.Criteria ct = example.createCriteria();
		ct.andActiveStatusEqualTo(1);
		if (all != null && all.equals("Y")) {
			ct.andStartTimeGreaterThan(new Date());
		}
		List<PActive> pActiveList = pActiveService.selectByExample(example);
		List<JSONObject> list = new ArrayList<>();
		if (pActiveList != null) {
			if (pActiveList.size() != 0) {
				for (PActive active : pActiveList) {
					JSONObject json = JSON.parseObject(JSON.toJSONString(active));
					PPartymember createUser = pPartymemberService.selectByUserId(active.getActiveCreatePeople());
					if (createUser != null) {
						json.put("activeCreatePeopleName", createUser.getName());
					}
					if (hasParticipate(active.getId(), userId)) {

						PActiveParticipateExample participateExample = new PActiveParticipateExample();
						PActiveParticipateExample.Criteria ctp = participateExample.createCriteria();
						ctp.andActiveIdEqualTo(active.getId());
						ctp.andUserIdEqualTo(userId);
						ctp.andStatusEqualTo(1);

						List<PActiveParticipate> ppList = activeParticipateService.selectByExample(participateExample);
						if (ppList != null) {

							if (ppList.size() > 0) {

								PActivePictureExample picExample = new PActivePictureExample();
								PActivePictureExample.Criteria picCt = picExample.createCriteria();
								picCt.andActiveIdEqualTo(active.getId());
								// PageHelper.startPage(1, 3,true);
								List<PActivePicture> picActiveList = pPictureService.selectActivePictures(picExample);
								json.put("pictures", picActiveList);
								list.add(json);

							}

						}

					}

				}
			}
		}
		result.setSuccess(true);
		result.setData(list);
		return result.getResult();
	}

	/**
	 * 判断是否已经报名的活动
	 *
	 * @param activeId
	 * @param userId
	 * @return
	 */
	private boolean hasParticipate(Integer activeId, Integer userId) {
		PActiveParticipateExample example = new PActiveParticipateExample();
		PActiveParticipateExample.Criteria ct = example.createCriteria();
		ct.andUserIdEqualTo(userId);
		ct.andActiveIdEqualTo(activeId);
		if (activeParticipateService.selectByExample(example).size() > 0) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(Integer pageNum, Integer pageSize) {
		ResultUtil result = new ResultUtil();
		PageHelper.startPage(pageNum, pageSize);
		List<PActive> pActiveList = pActiveService.selectByExample(new PActiveExample());
		PageInfo<PActive> p = new PageInfo<PActive>(pActiveList);
		result.setSuccess(true);
		result.setData(p);
		return result.getResult();
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteById(Integer activeid) {
		ResultUtil result = new ResultUtil();
		if (activeid == null) {
			result.setSuccess(false);
			result.setMsg("删除失败");
			return result.getResult();
		}

		PActive pActive = pActiveService.selectByPrimaryKey(activeid);
		if (pActiveService.selectByPrimaryKey(activeid) == null) {
			result.setSuccess(false);
			result.setMsg("删除失败");
			return result.getResult();
		}
		long currentTime = System.currentTimeMillis();
		if (pActive.getStartTime() == null) {
			result.setSuccess(false);
			result.setMsg("删除失败");
			return result.getResult();
		}
		Date date = pActive.getStartTime();
		long startTime = date.getTime();
		if (startTime >= currentTime) {
			if (pActiveService.deleteByPrimaryKey(activeid) > 0) {
				result.setSuccess(true);
				result.setMsg("删除成功");
			} else {
				result.setMsg("删除失败");
				result.setSuccess(false);
			}
		} else {
			result.setMsg("活动已经进行，不允许删除");
			result.setSuccess(false);
		}

		return result.getResult();
	}

	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateById(PActive pActive) {
		ResultUtil result = new ResultUtil();
		if (pActiveService.updateByPrimaryKey(pActive) > 0) {
			result.setSuccess(true);
			result.setMsg("修改成功");
		} else {
			result.setSuccess(false);
			result.setMsg("修改失败");
		}
		return result.getResult();
	}

	/**
	 * 查询活动详情
	 * 
	 * @param activeId
	 * @return
	 */
	@RequestMapping(value = "/queryById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryById(Integer activeId) {
		ResultUtil result = new ResultUtil();
		PActive pActive = pActiveService.selectByPrimaryKey(activeId);
		JSONObject json = JSON.parseObject(JSON.toJSONString(pActive));
		PPartymember createUser = pPartymemberService.selectByUserId(pActive.getActiveCreatePeople());
		if (createUser != null) {
			json.put("activeCreatePeopleName", createUser.getName());
		}
		PActiveParticipateExample pActiveParticipateExample = new PActiveParticipateExample();
		pActiveParticipateExample.createCriteria().andActiveIdEqualTo(activeId);
		List<PActiveParticipate> participateList = activeParticipateService.selectByExample(pActiveParticipateExample);
		Map<String, List<PPartymember>> mapPartyMember = new HashMap<String, List<PPartymember>>();
		List<Integer> inList = new ArrayList<>();
		List<Integer> outList = new ArrayList<>();
		for (PActiveParticipate item : participateList) {
			if (Integer.valueOf(1).equals(item.getStatus())) {
				inList.add(item.getUserId());
			} else if (Integer.valueOf(0).equals(item.getStatus())) {
				outList.add(item.getUserId());
			}
		}
		List<PPartymember> inUserList = new ArrayList<>();

		List<PPartymember> outUserList = new ArrayList<>();
		if (inList.size() > 0) {
			PPartymemberExample inUserExample = new PPartymemberExample();
			inUserExample.createCriteria().andUseridIn(inList);
			inUserExample.setOrderByClause("departmentid");
			inUserList.addAll(pPartymemberService.selectByExample(inUserExample));
		}
		int inUserListCount = inUserList.size();
		Map<String, List<PPartymember>> inUserMap = new TreeMap<String, List<PPartymember>>();

		if (inUserList.size() > 0) {
			for (int i = 0; i < inUserList.size(); i++) {
				PPartymember p = inUserList.get(i);
				List<PPartymember> list = null;
				if (i == 0) {
					list = new ArrayList<PPartymember>();
					list.add(p);
					inUserMap.put(p.getDepartmentname(), list);
				} else {
					list = inUserMap.get(p.getDepartmentname());
					if (list == null) {
						list = new ArrayList<PPartymember>();
					}
					list.add(p);

					inUserMap.put(p.getDepartmentname(), list);
				}
			}
		}
		if (outList.size() > 0) {
			PPartymemberExample outUserExample = new PPartymemberExample();
			outUserExample.createCriteria().andUseridIn(outList);
			outUserExample.setOrderByClause("departmentid");
			outUserList.addAll(pPartymemberService.selectByExample(outUserExample));
		}
		int outUserListCount = outUserList.size();
		Map<String, List<PPartymember>> outUserMap = new TreeMap<String, List<PPartymember>>();
		if (outUserList.size() > 0) {
			for (int i = 0; i < outUserList.size(); i++) {
				PPartymember p = outUserList.get(i);
				List<PPartymember> list = null;
				if (i == 0) {
					list = new ArrayList<PPartymember>();
					list.add(p);
					outUserMap.put(p.getDepartmentname(), list);
				} else {
					list = outUserMap.get(p.getDepartmentname());
					if (list == null) {
						list = new ArrayList<PPartymember>();
					}
					list.add(p);

					outUserMap.put(p.getDepartmentname(), list);
				}
			}
		}

		json.put("participateCount", inUserListCount);
		json.put("notParticipateCount", outUserListCount);
		for(Map.Entry<String, List<PPartymember>> entry : inUserMap.entrySet())
		{
			List<PPartymember> list = entry.getValue();
			Collections.sort(list,new Comparator<PPartymember>() {
				@Override
				public int compare(PPartymember o1, PPartymember o2) {
					if(o1 != null && o1.getPostId() != null && o2 != null && o2.getPostId() != null)
					{
						if(o1.getPostId() > o2.getPostId())
						{
							return -1;
						}
						else if(o1.getPostId() == o2.getPostId())
						{
							return 0;
						}
						else
						{
							return 1;
						}
					}
					return 0;
				}
			});
		}
		json.put("participate", inUserMap);
		for(Map.Entry<String, List<PPartymember>> entry : outUserMap.entrySet())
		{
			List<PPartymember> list = entry.getValue();
			if(list == null || list.isEmpty())
			{
				continue;
			}
			Collections.sort(list,new Comparator<PPartymember>() {
				@Override
				public int compare(PPartymember o1, PPartymember o2) {
					if(o1 != null && o1.getPostId() != null && o2 != null && o2.getPostId() != null)
					{
						if(o1.getPostId() > o2.getPostId())
						{
							return -1;
						}
						else if(o1.getPostId() == o2.getPostId())
						{
							return 0;
						}
						else
						{
							return 1;
						}
					}
					return 0;
				}
			});
		}
		json.put("notParticipate", outUserMap);

		result.setSuccess(true);
		result.setData(json);
		return result.getResult();
	}
	


	/**
	 * 查询年度参与次数
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getParticipateCount", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getParticipateCount(Integer year, Integer userId, Integer activeType) {
		ResultUtil result = new ResultUtil();
		Date startTime = DateUtil.getYearFirst(year);
		Date endTime = DateUtil.getYearLast(year);
		int count = pActiveService.selectByActiveTypeAndUserParticipate(userId, activeType, startTime, endTime);
		result.setSuccess(true);
		result.setMsg("查询成功");
		result.setData(count);
		return result.getResult();
	}

	/**
	 * 保存活动图片
	 * 
	 * @param activeId
	 * @param pictureId
	 * @return
	 */
	@RequestMapping(value = "/savePicture", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> savePicture(Integer activeId, Integer pictureId) {
		ResultUtil result = new ResultUtil();
		if (pActiveService.selectByPrimaryKey(activeId) == null) {
			result.setMsg("活动不存在！");
			result.setSuccess(false);
			return result.getResult();
		}
		if (pPictureService.selectByPrimaryKey(pictureId) == null) {
			result.setMsg("图片不存在！");
			result.setSuccess(false);
			return result.getResult();
		}
		PActivePicture activePicture = new PActivePicture();
		activePicture.setActiveId(activeId);
		activePicture.setPictureId(pictureId);
		int id = pActiveService.savePicture(activePicture);
		result.setSuccess(true);
		result.setMsg("保存成功");
		result.setData(id);
		return result.getResult();
	}

	/**
	 * 查询活动图集
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/getActivePictures", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getActivePictures(Integer activeId, Integer pageNum, Integer pageSize) {
		ResultUtil result = new ResultUtil();
		PActivePictureExample example = new PActivePictureExample();
		PActivePictureExample.Criteria ct = example.createCriteria();
		ct.andActiveIdEqualTo(activeId);
		List<PActivePicture> pActivePictureList = pPictureService.selectActivePictures(example);
		result.setSuccess(true);
		result.setData(pActivePictureList);
		return result.getResult();
	}

	/**
	 * 显示活动二维码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/showQrCode", method = { RequestMethod.POST, RequestMethod.GET })
	public void showQrCode(Integer activeId, HttpServletResponse response) {
		_log.info("activeId->" + activeId);
		String content = "http://dj.dlbdata.cn/#/active/activeSign/" + activeId;
		OutputStream out = null;
		BufferedImage image;
		try {
			image = genPic(content);
			response.setContentType("image/jpeg");
			// 设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			out = response.getOutputStream();// 取得响应输出流
			ImageIO.write(image, "JPEG", out);
			out.flush();
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {

				}
			}
		}
	}

	private BufferedImage genPic(String content) throws Exception {
		// int qr_size = 400;
		// int qr_size = 213;
		int qr_size = 150;
		Object errorCorrectionLevel = ErrorCorrectionLevel.H;
		Map hints = new HashMap();
		hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
		// hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 1);
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, qr_size, qr_size, hints);
		BufferedImage image = toBufferedImage(deleteWhite(bitMatrix));
		return image;
	}

	private BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		return image;
	}

	/**
	 * 删除活动图片接口
	 * 
	 * @param id
	 * 
	 */
	@RequestMapping(value = "/deleteActivePicById", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteActivePicById(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null) {
			result.setMsg("删除失败");
			result.setSuccess(false);
		}
		if (pActiveService.deleteActivePicById(id) > 0) {
			result.setSuccess(true);
			result.setMsg("删除成功");
		} else {
			result.setMsg("删除失败");
			result.setSuccess(false);
		}
		return result.getResult();
	}

	/**
	 * 删除白边
	 */
	private static BitMatrix deleteWhite(BitMatrix matrix) {
		int[] rec = matrix.getEnclosingRectangle();
		int resWidth = rec[2] + 1;
		int resHeight = rec[3] + 1;

		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
		resMatrix.clear();
		for (int i = 0; i < resWidth; i++) {
			for (int j = 0; j < resHeight; j++) {
				if (matrix.get(i + rec[0], j + rec[1]))
					resMatrix.set(i, j);
			}
		}
		return resMatrix;
	}

	private static BitMatrix renderResult(QRCode code, int width, int height, int quietZone) {
		ByteMatrix input = code.getMatrix();
		if (input == null) {
			throw new IllegalStateException();
		}
		int inputWidth = input.getWidth();
		int inputHeight = input.getHeight();
		int qrWidth = inputWidth + (quietZone * 2);
		int qrHeight = inputHeight + (quietZone * 2);
		int outputWidth = Math.max(width, qrWidth);
		int outputHeight = Math.max(height, qrHeight);

		int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
		// Padding includes both the quiet zone and the extra white pixels to
		// accommodate the requested
		// dimensions. For example, if input is 25x25 the QR will be 33x33 including the
		// quiet zone.
		// If the requested size is 200x160, the multiple will be 4, for a QR of
		// 132x132. These will
		// handle all the padding from 100x100 (the actual QR) up to 200x160.
		int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
		int topPadding = (outputHeight - (inputHeight * multiple)) / 2;

		BitMatrix output = new BitMatrix(outputWidth, outputHeight);

		for (int inputY = 0, outputY = topPadding; inputY < inputHeight; inputY++, outputY += multiple) {
			// Write the contents of this row of the barcode
			for (int inputX = 0, outputX = leftPadding; inputX < inputWidth; inputX++, outputX += multiple) {
				if (input.get(inputX, inputY) == 1) {
					output.setRegion(outputX, outputY, multiple, multiple);
				}
			}
		}

		return output;
	}

}
