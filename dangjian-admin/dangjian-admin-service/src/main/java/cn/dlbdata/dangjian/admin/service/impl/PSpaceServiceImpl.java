package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PSpaceDao;
import cn.dlbdata.dangjian.admin.dao.model.PSpace;
import cn.dlbdata.dangjian.admin.dao.model.PSpaceExample;
import cn.dlbdata.dangjian.admin.service.PSpaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PSpaceService")
public class PSpaceServiceImpl implements PSpaceService {

    private static Logger _log = LoggerFactory.getLogger(PSpaceServiceImpl.class);

    @Resource
    PSpaceDao pSpaceDao;

    @Override
    public long countByExample(PSpaceExample example) {
        return pSpaceDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PSpaceExample example) {
        return pSpaceDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer spaceId) {
        return pSpaceDao.deleteByPrimaryKey(spaceId);
    }
    
    @Override
    public int insert(PSpace pSpace) {
        pSpaceDao.insert(pSpace);
        return pSpace.getSpaceid();
    }
    
    @Override
    public int insertSelective(PSpace pSpace) {
        pSpaceDao.insertSelective(pSpace);
        return pSpace.getSpaceid();
    }
    
    @Override
    public List<PSpace> selectByExample(PSpaceExample example) {
        return pSpaceDao.selectByExample(example);
    }

    @Override
    public PSpace selectByPrimaryKey(Integer spaceId) {
        return pSpaceDao.selectByPrimaryKey(spaceId);
    }

    @Override
    public int updateByExampleSelective(PSpace pSpace, PSpaceExample example) {
        return pSpaceDao.updateByExampleSelective(pSpace,example);
    }

    @Override
    public int updateByExample(PSpace pSpace, PSpaceExample example) {
        return pSpaceDao.updateByExample(pSpace,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PSpace pSpace) {
        return pSpaceDao.updateByPrimaryKeySelective(pSpace);
    }

    @Override
    public int updateByPrimaryKey(PSpace pSpace) {
        return pSpaceDao.updateByPrimaryKey(pSpace);
    }

    @Override
    public int updateByToid(PSpace pSpace){return pSpaceDao.updateByToid(pSpace);}

}