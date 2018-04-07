package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymemberGetScoreItemDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberGetScoreItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PPartymemberGetScoreItemService")
public class PPartymemberGetScoreItemServiceImpl implements PPartymemberGetScoreItemService {

    private static Logger _log = LoggerFactory.getLogger(PPartymemberGetScoreItemServiceImpl.class);

    @Autowired
    PPartymemberGetScoreItemDao pPartymemberGetScoreItemDao;

    @Override
    public long countByExample(PPartymemberGetScoreItemExample example) {
        return pPartymemberGetScoreItemDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPartymemberGetScoreItemExample example) {
        return pPartymemberGetScoreItemDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer itemid) {
        return pPartymemberGetScoreItemDao.deleteByPrimaryKey(itemid);
    }
    
    @Override
    public int insert(PPartymemberGetScoreItem pPartymemberGetScoreItem) {
        pPartymemberGetScoreItemDao.insert(pPartymemberGetScoreItem);
        return pPartymemberGetScoreItem.getItemid();
    }
    
    @Override
    public int insertSelective(PPartymemberGetScoreItem pPartymemberGetScoreItem) {
        pPartymemberGetScoreItemDao.insertSelective(pPartymemberGetScoreItem);
        return pPartymemberGetScoreItem.getItemid();
    }
    
    @Override
    public List<PPartymemberGetScoreItem> selectByExample(PPartymemberGetScoreItemExample example) {
        return pPartymemberGetScoreItemDao.selectByExample(example);
    }

    @Override
    public PPartymemberGetScoreItem selectByPrimaryKey(Integer itemid) {
        return pPartymemberGetScoreItemDao.selectByPrimaryKey(itemid);
    }

    @Override
    public int updateByExampleSelective(PPartymemberGetScoreItem pPartymemberGetScoreItem, PPartymemberGetScoreItemExample example) {
        return pPartymemberGetScoreItemDao.updateByExampleSelective(pPartymemberGetScoreItem,example);
    }

    @Override
    public int updateByExample(PPartymemberGetScoreItem pPartymemberGetScoreItem, PPartymemberGetScoreItemExample example) {
        return pPartymemberGetScoreItemDao.updateByExample(pPartymemberGetScoreItem,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymemberGetScoreItem pPartymemberGetScoreItem) {
        return pPartymemberGetScoreItemDao.updateByPrimaryKeySelective(pPartymemberGetScoreItem);
    }

    @Override
    public int updateByPrimaryKey(PPartymemberGetScoreItem pPartymemberGetScoreItem) {
        return pPartymemberGetScoreItemDao.updateByPrimaryKey(pPartymemberGetScoreItem);
    }

}