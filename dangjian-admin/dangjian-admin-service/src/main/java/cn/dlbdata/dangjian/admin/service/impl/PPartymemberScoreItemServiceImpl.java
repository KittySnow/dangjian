package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymemberScoreItemDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberScoreItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PPartymemberScoreItemService")
public class PPartymemberScoreItemServiceImpl implements PPartymemberScoreItemService {

    private static Logger _log = LoggerFactory.getLogger(PPartymemberScoreItemServiceImpl.class);

    @Autowired
    PPartymemberScoreItemDao pPartymemberScoreItemDao;

    @Override
    public long countByExample(PPartymemberScoreItemExample example) {
        return pPartymemberScoreItemDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPartymemberScoreItemExample example) {
        return pPartymemberScoreItemDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer itemid) {
        return pPartymemberScoreItemDao.deleteByPrimaryKey(itemid);
    }
    
    @Override
    public int insert(PPartymemberScoreItem pPartymemberScoreItem) {
        pPartymemberScoreItemDao.insert(pPartymemberScoreItem);
        return pPartymemberScoreItem.getItemid();
    }
    
    @Override
    public int insertSelective(PPartymemberScoreItem pPartymemberScoreItem) {
        pPartymemberScoreItemDao.insertSelective(pPartymemberScoreItem);
        return pPartymemberScoreItem.getItemid();
    }
    
    @Override
    public List<PPartymemberScoreItem> selectByExample(PPartymemberScoreItemExample example) {
        return pPartymemberScoreItemDao.selectByExample(example);
    }

    @Override
    public PPartymemberScoreItem selectByPrimaryKey(Integer itemid) {
        return pPartymemberScoreItemDao.selectByPrimaryKey(itemid);
    }

    @Override
    public int updateByExampleSelective(PPartymemberScoreItem pPartymemberScoreItem, PPartymemberScoreItemExample example) {
        return pPartymemberScoreItemDao.updateByExampleSelective(pPartymemberScoreItem,example);
    }

    @Override
    public int updateByExample(PPartymemberScoreItem pPartymemberScoreItem, PPartymemberScoreItemExample example) {
        return pPartymemberScoreItemDao.updateByExample(pPartymemberScoreItem,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymemberScoreItem pPartymemberScoreItem) {
        return pPartymemberScoreItemDao.updateByPrimaryKeySelective(pPartymemberScoreItem);
    }

    @Override
    public int updateByPrimaryKey(PPartymemberScoreItem pPartymemberScoreItem) {
        return pPartymemberScoreItemDao.updateByPrimaryKey(pPartymemberScoreItem);
    }

}