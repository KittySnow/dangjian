package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PPictureDao;
import cn.dlbdata.dangjian.admin.dao.model.PPicture;
import cn.dlbdata.dangjian.admin.dao.model.PPictureExample;
import cn.dlbdata.dangjian.admin.service.PPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PPictureService")
public class PPictureServiceImpl implements PPictureService {

    private static Logger _log = LoggerFactory.getLogger(PPictureServiceImpl.class);

    @Autowired
    PPictureDao pPictureDao;

    @Override
    public long countByExample(PPictureExample example) {
        return pPictureDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PPictureExample example) {
        return pPictureDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pPictureDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PPicture pPicture) {
        pPictureDao.insert(pPicture);
        return pPicture.getId();
    }
    
    @Override
    public int insertSelective(PPicture pPicture) {
        pPictureDao.insertSelective(pPicture);
        return pPicture.getId();
    }
    
    @Override
    public List<PPicture> selectByExample(PPictureExample example) {
        return pPictureDao.selectByExample(example);
    }

    @Override
    public PPicture selectByPrimaryKey(Integer id) {
        return pPictureDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PPicture pPicture, PPictureExample example) {
        return pPictureDao.updateByExampleSelective(pPicture,example);
    }

    @Override
    public int updateByExample(PPicture pPicture, PPictureExample example) {
        return pPictureDao.updateByExample(pPicture,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PPicture pPicture) {
        return pPictureDao.updateByPrimaryKeySelective(pPicture);
    }

    @Override
    public int updateByPrimaryKey(PPicture pPicture) {
        return pPictureDao.updateByPrimaryKey(pPicture);
    }

}