package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PAvantgradeDao;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgrade;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradeExample;
import cn.dlbdata.dangjian.admin.service.PAvantgradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PAvantgradeService")
public class PAvantgradeServiceImpl implements PAvantgradeService {

    private static Logger _log = LoggerFactory.getLogger(PAvantgradeServiceImpl.class);

    @Autowired
    PAvantgradeDao pAvantgradeDao;

    @Override
    public long countByExample(PAvantgradeExample example) {
        return pAvantgradeDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PAvantgradeExample example) {
        return pAvantgradeDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pAvantgradeDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PAvantgrade pAvantgrade) {
        pAvantgradeDao.insert(pAvantgrade);
        return pAvantgrade.getId();
    }
    
    @Override
    public int insertSelective(PAvantgrade pAvantgrade) {
        pAvantgradeDao.insertSelective(pAvantgrade);
        return pAvantgrade.getId();
    }
    
    @Override
    public List<PAvantgrade> selectByExample(PAvantgradeExample example) {
        return pAvantgradeDao.selectByExample(example);
    }

    @Override
    public PAvantgrade selectByPrimaryKey(Integer id) {
        return pAvantgradeDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PAvantgrade pAvantgrade, PAvantgradeExample example) {
        return pAvantgradeDao.updateByExampleSelective(pAvantgrade,example);
    }

    @Override
    public int updateByExample(PAvantgrade pAvantgrade, PAvantgradeExample example) {
        return pAvantgradeDao.updateByExample(pAvantgrade,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PAvantgrade pAvantgrade) {
        return pAvantgradeDao.updateByPrimaryKeySelective(pAvantgrade);
    }

    @Override
    public int updateByPrimaryKey(PAvantgrade pAvantgrade) {
        return pAvantgradeDao.updateByPrimaryKey(pAvantgrade);
    }

}