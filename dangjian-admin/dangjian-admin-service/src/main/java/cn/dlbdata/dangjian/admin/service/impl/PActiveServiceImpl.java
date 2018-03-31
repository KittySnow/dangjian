package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PActiveDao;
import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.service.PActiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PActiveService")
public class PActiveServiceImpl implements PActiveService {

    private static Logger _log = LoggerFactory.getLogger(PActiveServiceImpl.class);

    @Autowired
    PActiveDao pActiveDao;

    @Override
    public long countByExample(PActiveExample example) {
        return pActiveDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PActiveExample example) {
        return pActiveDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pActiveDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PActive pActive) {
        pActiveDao.insert(pActive);
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
    public PActive selectByPrimaryKey(Integer id) {
        return pActiveDao.selectByPrimaryKey(id);
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

}