package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PActivePictureDao;
import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import cn.dlbdata.dangjian.admin.service.PActivePictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PActivePictureService")
public class PActivePictureServiceImpl implements PActivePictureService {

    private static Logger _log = LoggerFactory.getLogger(PActivePictureServiceImpl.class);

    @Autowired
    PActivePictureDao pActivePictureDao;

    @Override
    public long countByExample(PActivePictureExample example) {
        return pActivePictureDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PActivePictureExample example) {
        return pActivePictureDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pActivePictureDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PActivePicture pActivePicture) {
        pActivePictureDao.insert(pActivePicture);
        return pActivePicture.getId();
    }
    
    @Override
    public int insertSelective(PActivePicture pActivePicture) {
        pActivePictureDao.insertSelective(pActivePicture);
        return pActivePicture.getId();
    }
    
    @Override
    public List<PActivePicture> selectByExample(PActivePictureExample example) {
        return pActivePictureDao.selectByExample(example);
    }

    @Override
    public PActivePicture selectByPrimaryKey(Integer id) {
        return pActivePictureDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PActivePicture pActivePicture, PActivePictureExample example) {
        return pActivePictureDao.updateByExampleSelective(pActivePicture,example);
    }

    @Override
    public int updateByExample(PActivePicture pActivePicture, PActivePictureExample example) {
        return pActivePictureDao.updateByExample(pActivePicture,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PActivePicture pActivePicture) {
        return pActivePictureDao.updateByPrimaryKeySelective(pActivePicture);
    }

    @Override
    public int updateByPrimaryKey(PActivePicture pActivePicture) {
        return pActivePictureDao.updateByPrimaryKey(pActivePicture);
    }

}