package cn.dlbdata.dangjian.admin.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dlbdata.dangjian.admin.dao.mapper.PActiveDao;
import cn.dlbdata.dangjian.admin.dao.mapper.PActiveParticipateDao;
import cn.dlbdata.dangjian.admin.dao.mapper.PActivePictureDao;
import cn.dlbdata.dangjian.admin.dao.mapper.PUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.dao.query.ActiveQuery;
import cn.dlbdata.dangjian.admin.service.PActiveService;


@Service("PActiveService")
public class PActiveServiceImpl implements PActiveService {

    private static Logger _log = LoggerFactory.getLogger(PActiveServiceImpl.class);

    @Autowired
    PActiveDao pActiveDao;
    @Autowired
    PActivePictureDao pActivePictureDao;
    @Autowired
    PUserDao pUserDao;
    @Autowired
    PActiveParticipateDao pActiveParticipateDao;

    @Override
    public long countByExample(PActiveExample example) {
        return pActiveDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PActiveExample example) {
        return pActiveDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer activeId) {
        return pActiveDao.deleteByPrimaryKey(activeId);
    }
    
    @Override
    public int insert(PActive pActive) {
        pActiveDao.insert(pActive);
        
        //当前活动为驿站生活的时候不用自动报名
        if(pActive.getActiveType() != 5 && StringUtils.isNotEmpty(pActive.getDepartIds()))
        {
        		List<Integer> deptIds = new ArrayList<>();
        		String[] deptIdArr = pActive.getDepartIds().split(",");
        		if(deptIdArr != null)
        		{
        			for(String str : deptIdArr)
        			{
        				Integer id = 0;
        				try
        				{
        					id = Integer.parseInt(str);
        				}
        				catch (Exception e) {
        					_log.error("部门ID转换失败",e);
					}
        				if(id > 0)
        				{
        					deptIds.add(id);
        				}
        			}
        		}
        		//查询对应部门下的用户
	        PUserExample example = new PUserExample();
	        example.createCriteria().andDepartmentidIn(deptIds);
	        List<PUser> list = pUserDao.selectByExample(example);
	        List<Integer> userIds = new ArrayList<Integer>();
	        if(list != null)
	        {
	        		for(PUser u : list)
	        		{
	        			userIds.add(u.getUserid());
	        		}
	        }
	        
	        //批量插入到P_Active_Participate
	        pActiveParticipateDao.insertList(userIds.toArray(new Integer[0]), pActive.getId());
        }
        
        return pActive.getId();
    }
    
    @Override
    public int insertSelective(PActive pActive) {
        pActiveDao.insertSelective(pActive);
        return pActive.getId();
    }
    
    @Override
    public List<PActive> selectByExample(PActiveExample example) {
        return pActiveDao.selectByExample(example);
    }

    @Override
    public PActive selectByPrimaryKey(Integer activeId) {
        return pActiveDao.selectByPrimaryKey(activeId);
    }

    @Override
    public int updateByExampleSelective(PActive pActive, PActiveExample example) {
        return pActiveDao.updateByExampleSelective(pActive,example);
    }

    @Override
    public int updateByExample(PActive pActive, PActiveExample example) {
        return pActiveDao.updateByExample(pActive,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PActive pActive) {
        return pActiveDao.updateByPrimaryKeySelective(pActive);
    }

    @Override
    public int updateByPrimaryKey(PActive pActive) {
        return pActiveDao.updateByPrimaryKey(pActive);
    }

    @Override
    public int selectByActiveTypeAndUserParticipate(Integer userId, Integer activeType, Date startTime,Date endTime) {
        return pActiveDao.selectByActiveTypeAndUserParticipate(userId, activeType,startTime,endTime);
    }

    @Override
    public int savePicture(PActivePicture activePicture) {
        return pActivePictureDao.insert(activePicture);
    }

    @Override
    public List<Map<String, Object>> getRunningActive(ActiveQuery activeQuery) {
        return this.pActiveDao.getRunningActive(activeQuery);
    }
}