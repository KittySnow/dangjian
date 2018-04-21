package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PActiveParticipateDao;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipate;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipateExample;
import cn.dlbdata.dangjian.admin.service.PActiveParticipateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PActiveParticipateService")
public class PActiveParticipateServiceImpl implements PActiveParticipateService {

    private static Logger _log = LoggerFactory.getLogger(PActiveParticipateServiceImpl.class);

    @Autowired
    PActiveParticipateDao pActiveParticipateDao;

    @Override
    public long countByExample(PActiveParticipateExample example) {
        return pActiveParticipateDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PActiveParticipateExample example) {
        return pActiveParticipateDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pActiveParticipateDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PActiveParticipate pActiveParticipate) {
        pActiveParticipateDao.insert(pActiveParticipate);
        return pActiveParticipate.getId();
    }
    
    @Override
    public int insertSelective(PActiveParticipate pActiveParticipate) {
        pActiveParticipateDao.insertSelective(pActiveParticipate);
        return pActiveParticipate.getId();
    }
    
    @Override
    public List<PActiveParticipate> selectByExample(PActiveParticipateExample example) {
        return pActiveParticipateDao.selectByExample(example);
    }

    @Override
    public PActiveParticipate selectByPrimaryKey(Integer id) {
        return pActiveParticipateDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PActiveParticipate pActiveParticipate, PActiveParticipateExample example) {
        return pActiveParticipateDao.updateByExampleSelective(pActiveParticipate,example);
    }

    @Override
    public int updateByExample(PActiveParticipate pActiveParticipate, PActiveParticipateExample example) {
        return pActiveParticipateDao.updateByExample(pActiveParticipate,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PActiveParticipate pActiveParticipate) {
        return pActiveParticipateDao.updateByPrimaryKeySelective(pActiveParticipate);
    }

    @Override
    public int updateByPrimaryKey(PActiveParticipate pActiveParticipate) {
        return pActiveParticipateDao.updateByPrimaryKey(pActiveParticipate);
    }

    @Override
    public void insertList(Integer[] userIds ,Integer activeId){
        pActiveParticipateDao.insertList(userIds ,activeId);
    }

}