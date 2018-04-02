package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PScoreProjectDao;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProject;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProjectExample;
import cn.dlbdata.dangjian.admin.service.PScoreProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PScoreProjectService")
public class PScoreProjectServiceImpl implements PScoreProjectService {

    private static Logger _log = LoggerFactory.getLogger(PScoreProjectServiceImpl.class);

    @Resource
    PScoreProjectDao pScoreProjectDao;

    @Override
    public long countByExample(PScoreProjectExample example) {
        return pScoreProjectDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PScoreProjectExample example) {
        return pScoreProjectDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pScoreProjectDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PScoreProject pScoreProject) {
        pScoreProjectDao.insert(pScoreProject);
        return pScoreProject.getId();
    }
    
    @Override
    public int insertSelective(PScoreProject pScoreProject) {
        pScoreProjectDao.insertSelective(pScoreProject);
        return pScoreProject.getId();
    }
    
    @Override
    public List<PScoreProject> selectByExample(PScoreProjectExample example) {
        return pScoreProjectDao.selectByExample(example);
    }

    @Override
    public PScoreProject selectByPrimaryKey(Integer id) {
        return pScoreProjectDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PScoreProject pScoreProject, PScoreProjectExample example) {
        return pScoreProjectDao.updateByExampleSelective(pScoreProject,example);
    }

    @Override
    public int updateByExample(PScoreProject pScoreProject, PScoreProjectExample example) {
        return pScoreProjectDao.updateByExample(pScoreProject,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PScoreProject pScoreProject) {
        return pScoreProjectDao.updateByPrimaryKeySelective(pScoreProject);
    }

    @Override
    public int updateByPrimaryKey(PScoreProject pScoreProject) {
        return pScoreProjectDao.updateByPrimaryKey(pScoreProject);
    }

}