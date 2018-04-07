package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PStudyPictureDao;
import cn.dlbdata.dangjian.admin.dao.model.PStudyPicture;
import cn.dlbdata.dangjian.admin.dao.model.PStudyPictureExample;
import cn.dlbdata.dangjian.admin.service.PStudyPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PStudyPictureService")
public class PStudyPictureServiceImpl implements PStudyPictureService {

    private static Logger _log = LoggerFactory.getLogger(PStudyPictureServiceImpl.class);

    @Autowired
    PStudyPictureDao pStudyPictureDao;

    @Override
    public long countByExample(PStudyPictureExample example) {
        return pStudyPictureDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PStudyPictureExample example) {
        return pStudyPictureDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pStudyPictureDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PStudyPicture pStudyPicture) {
        pStudyPictureDao.insert(pStudyPicture);
        return pStudyPicture.getId();
    }
    
    @Override
    public int insertSelective(PStudyPicture pStudyPicture) {
        pStudyPictureDao.insertSelective(pStudyPicture);
        return pStudyPicture.getId();
    }
    
    @Override
    public List<PStudyPicture> selectByExample(PStudyPictureExample example) {
        return pStudyPictureDao.selectByExample(example);
    }

    @Override
    public PStudyPicture selectByPrimaryKey(Integer id) {
        return pStudyPictureDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PStudyPicture pStudyPicture, PStudyPictureExample example) {
        return pStudyPictureDao.updateByExampleSelective(pStudyPicture,example);
    }

    @Override
    public int updateByExample(PStudyPicture pStudyPicture, PStudyPictureExample example) {
        return pStudyPictureDao.updateByExample(pStudyPicture,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PStudyPicture pStudyPicture) {
        return pStudyPictureDao.updateByPrimaryKeySelective(pStudyPicture);
    }

    @Override
    public int updateByPrimaryKey(PStudyPicture pStudyPicture) {
        return pStudyPictureDao.updateByPrimaryKey(pStudyPicture);
    }

}