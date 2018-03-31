package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PScorePartyDao;
import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PScorePartyExample;
import cn.dlbdata.dangjian.admin.service.PScorePartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PScorePartyService")
public class PScorePartyServiceImpl implements PScorePartyService {

    private static Logger _log = LoggerFactory.getLogger(PScorePartyServiceImpl.class);

    @Resource
    PScorePartyDao pScorePartyDao;

    @Override
    public long countByExample(PScorePartyExample example) {
        return pScorePartyDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PScorePartyExample example) {
        return pScorePartyDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pScorePartyDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PScoreParty pScoreParty) {
        pScorePartyDao.insert(pScoreParty);
        return pScoreParty.getId();
    }
    
    @Override
    public int insertSelective(PScoreParty pScoreParty) {
        pScorePartyDao.insertSelective(pScoreParty);
        return pScoreParty.getId();
    }
    
    @Override
    public List<PScoreParty> selectByExample(PScorePartyExample example) {
        return pScorePartyDao.selectByExample(example);
    }

    @Override
    public PScoreParty selectByPrimaryKey(Integer id) {
        return pScorePartyDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PScoreParty pScoreParty, PScorePartyExample example) {
        return pScorePartyDao.updateByExampleSelective(pScoreParty,example);
    }

    @Override
    public int updateByExample(PScoreParty pScoreParty, PScorePartyExample example) {
        return pScorePartyDao.updateByExample(pScoreParty,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PScoreParty pScoreParty) {
        return pScorePartyDao.updateByPrimaryKeySelective(pScoreParty);
    }

    @Override
    public int updateByPrimaryKey(PScoreParty pScoreParty) {
        return pScorePartyDao.updateByPrimaryKey(pScoreParty);
    }

}