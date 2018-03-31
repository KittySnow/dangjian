package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymenberDuesDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDuesExample;
import cn.dlbdata.dangjian.admin.service.PPartymenberDuesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PPartymenberDuesService")
public class PPartymenberDuesServiceImpl implements PPartymenberDuesService {

    private static Logger _log = LoggerFactory.getLogger(PPartymenberDuesServiceImpl.class);

    @Resource
    PPartymenberDuesDao pPartymenberDuesDao;

    @Override
    public long countByExample(PPartymenberDuesExample example) {
        return pPartymenberDuesDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPartymenberDuesExample example) {
        return pPartymenberDuesDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer dues_id) {
        return pPartymenberDuesDao.deleteByPrimaryKey(dues_id);
    }
    
    @Override
    public int insert(PPartymenberDues pPartymenberDues) {
        pPartymenberDuesDao.insert(pPartymenberDues);
        return pPartymenberDues.getDuesId();
    }
    
    @Override
    public int insertSelective(PPartymenberDues pPartymenberDues) {
        pPartymenberDuesDao.insertSelective(pPartymenberDues);
        return pPartymenberDues.getDuesId();
    }
    
    @Override
    public List<PPartymenberDues> selectByExample(PPartymenberDuesExample example) {
        return pPartymenberDuesDao.selectByExample(example);
    }

    @Override
    public PPartymenberDues selectByPrimaryKey(Integer dues_id) {
        return pPartymenberDuesDao.selectByPrimaryKey(dues_id);
    }

    @Override
    public int updateByExampleSelective(PPartymenberDues pPartymenberDues, PPartymenberDuesExample example) {
        return pPartymenberDuesDao.updateByExampleSelective(pPartymenberDues,example);
    }

    @Override
    public int updateByExample(PPartymenberDues pPartymenberDues, PPartymenberDuesExample example) {
        return pPartymenberDuesDao.updateByExample(pPartymenberDues,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymenberDues pPartymenberDues) {
        return pPartymenberDuesDao.updateByPrimaryKeySelective(pPartymenberDues);
    }

    @Override
    public int updateByPrimaryKey(PPartymenberDues pPartymenberDues) {
        return pPartymenberDuesDao.updateByPrimaryKey(pPartymenberDues);
    }

}