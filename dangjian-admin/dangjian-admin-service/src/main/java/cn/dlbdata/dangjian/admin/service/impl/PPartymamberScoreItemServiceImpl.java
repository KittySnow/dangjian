package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPartymamberScoreItemDao;
import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymamberScoreItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("PPartymamberScoreItemService")
public class PPartymamberScoreItemServiceImpl implements PPartymamberScoreItemService {

    private static Logger _log = LoggerFactory.getLogger(PPartymamberScoreItemServiceImpl.class);

    @Resource
    PPartymamberScoreItemDao pPartymamberScoreItemDao;

    @Override
    public long countByExample(PPartymamberScoreItemExample example) {
        return pPartymamberScoreItemDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPartymamberScoreItemExample example) {
        return pPartymamberScoreItemDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer item_id) {
        return pPartymamberScoreItemDao.deleteByPrimaryKey(item_id);
    }
    
    @Override
    public int insert(PPartymamberScoreItem pPartymamberScoreItem) {
        pPartymamberScoreItemDao.insert(pPartymamberScoreItem);
        return pPartymamberScoreItem.getItemId();
    }
    
    @Override
    public int insertSelective(PPartymamberScoreItem pPartymamberScoreItem) {
        pPartymamberScoreItemDao.insertSelective(pPartymamberScoreItem);
        return pPartymamberScoreItem.getItemId();
    }
    
    @Override
    public List<PPartymamberScoreItem> selectByExample(PPartymamberScoreItemExample example) {
        return pPartymamberScoreItemDao.selectByExample(example);
    }

    @Override
    public PPartymamberScoreItem selectByPrimaryKey(Integer item_id) {
        return pPartymamberScoreItemDao.selectByPrimaryKey(item_id);
    }

    @Override
    public int updateByExampleSelective(PPartymamberScoreItem pPartymamberScoreItem, PPartymamberScoreItemExample example) {
        return pPartymamberScoreItemDao.updateByExampleSelective(pPartymamberScoreItem,example);
    }

    @Override
    public int updateByExample(PPartymamberScoreItem pPartymamberScoreItem, PPartymamberScoreItemExample example) {
        return pPartymamberScoreItemDao.updateByExample(pPartymamberScoreItem,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPartymamberScoreItem pPartymamberScoreItem) {
        return pPartymamberScoreItemDao.updateByPrimaryKeySelective(pPartymamberScoreItem);
    }

    @Override
    public int updateByPrimaryKey(PPartymamberScoreItem pPartymamberScoreItem) {
        return pPartymamberScoreItemDao.updateByPrimaryKey(pPartymamberScoreItem);
    }

}