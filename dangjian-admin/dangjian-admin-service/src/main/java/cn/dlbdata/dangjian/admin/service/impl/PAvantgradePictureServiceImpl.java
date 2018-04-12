package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PAvantgradePictureDao;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePicture;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePictureExample;
import cn.dlbdata.dangjian.admin.service.PAvantgradePictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PAvantgradePictureService")
public class PAvantgradePictureServiceImpl implements PAvantgradePictureService {

    private static Logger _log = LoggerFactory.getLogger(PAvantgradePictureServiceImpl.class);

    @Autowired
    PAvantgradePictureDao pAvantgradePictureDao;

    @Override
    public long countByExample(PAvantgradePictureExample example) {
        return pAvantgradePictureDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PAvantgradePictureExample example) {
        return pAvantgradePictureDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pAvantgradePictureDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PAvantgradePicture pAvantgradePicture) {
        pAvantgradePictureDao.insert(pAvantgradePicture);
        return pAvantgradePicture.getId();
    }
    
    @Override
    public int insertSelective(PAvantgradePicture pAvantgradePicture) {
        pAvantgradePictureDao.insertSelective(pAvantgradePicture);
        return pAvantgradePicture.getId();
    }
    
    @Override
    public List<PAvantgradePicture> selectByExample(PAvantgradePictureExample example) {
        return pAvantgradePictureDao.selectByExample(example);
    }

    @Override
    public PAvantgradePicture selectByPrimaryKey(Integer id) {
        return pAvantgradePictureDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PAvantgradePicture pAvantgradePicture, PAvantgradePictureExample example) {
        return pAvantgradePictureDao.updateByExampleSelective(pAvantgradePicture,example);
    }

    @Override
    public int updateByExample(PAvantgradePicture pAvantgradePicture, PAvantgradePictureExample example) {
        return pAvantgradePictureDao.updateByExample(pAvantgradePicture,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PAvantgradePicture pAvantgradePicture) {
        return pAvantgradePictureDao.updateByPrimaryKeySelective(pAvantgradePicture);
    }

    @Override
    public int updateByPrimaryKey(PAvantgradePicture pAvantgradePicture) {
        return pAvantgradePictureDao.updateByPrimaryKey(pAvantgradePicture);
    }

    @Override
    public void insertList(Integer[] picIds,Integer avantgradeId){
        pAvantgradePictureDao.insertList(picIds,avantgradeId);
    }
}