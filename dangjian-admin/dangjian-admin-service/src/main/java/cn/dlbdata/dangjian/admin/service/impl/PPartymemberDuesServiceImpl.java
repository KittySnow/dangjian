package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymemberDuesDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDuesExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberDuesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PPartymemberDuesService")
public class PPartymemberDuesServiceImpl implements PPartymemberDuesService {

    private static Logger _log = LoggerFactory.getLogger(PPartymemberDuesServiceImpl.class);

    @Autowired
    PPartymemberDuesDao pPartymemberDuesDao;

    @Override
    public long countByExample(PPartymemberDuesExample example) {
        return pPartymemberDuesDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPartymemberDuesExample example) {
        return pPartymemberDuesDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer dues_id) {
        return pPartymemberDuesDao.deleteByPrimaryKey(dues_id);
    }
    
    @Override
    public int insert(PPartymemberDues pPartymemberDues) {
        pPartymemberDuesDao.insert(pPartymemberDues);
        return pPartymemberDues.getDuesId();
    }
    
    @Override
    public int insertSelective(PPartymemberDues pPartymemberDues) {
        pPartymemberDuesDao.insertSelective(pPartymemberDues);
        return pPartymemberDues.getDuesId();
    }
    
    @Override
    public List<PPartymemberDues> selectByExample(PPartymemberDuesExample example) {
        return pPartymemberDuesDao.selectByExample(example);
    }

    @Override
    public PPartymemberDues selectByPrimaryKey(Integer dues_id) {
        return pPartymemberDuesDao.selectByPrimaryKey(dues_id);
    }

    @Override
    public int updateByExampleSelective(PPartymemberDues pPartymemberDues, PPartymemberDuesExample example) {
        return pPartymemberDuesDao.updateByExampleSelective(pPartymemberDues,example);
    }

    @Override
    public int updateByExample(PPartymemberDues pPartymemberDues, PPartymemberDuesExample example) {
        return pPartymemberDuesDao.updateByExample(pPartymemberDues,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymemberDues pPartymemberDues) {
        return pPartymemberDuesDao.updateByPrimaryKeySelective(pPartymemberDues);
    }

    @Override
    public int updateByPrimaryKey(PPartymemberDues pPartymemberDues) {
        return pPartymemberDuesDao.updateByPrimaryKey(pPartymemberDues);
    }


}