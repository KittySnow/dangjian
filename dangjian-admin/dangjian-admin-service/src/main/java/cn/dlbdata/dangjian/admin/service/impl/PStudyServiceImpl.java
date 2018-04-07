package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PStudyDao;
import cn.dlbdata.dangjian.admin.dao.model.PStudy;
import cn.dlbdata.dangjian.admin.dao.model.PStudyExample;
import cn.dlbdata.dangjian.admin.service.PStudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PStudyService")
public class PStudyServiceImpl implements PStudyService {

    private static Logger _log = LoggerFactory.getLogger(PStudyServiceImpl.class);

    @Autowired
    PStudyDao pStudyDao;

    @Override
    public long countByExample(PStudyExample example) {
        return pStudyDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PStudyExample example) {
        return pStudyDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer studyid) {
        return pStudyDao.deleteByPrimaryKey(studyid);
    }
    
    @Override
    public int insert(PStudy pStudy) {
        pStudyDao.insert(pStudy);
        return pStudy.getStudyid();
    }
    
    @Override
    public int insertSelective(PStudy pStudy) {
        pStudyDao.insertSelective(pStudy);
        return pStudy.getStudyid();
    }
    
    @Override
    public List<PStudy> selectByExample(PStudyExample example) {
        return pStudyDao.selectByExample(example);
    }

    @Override
    public PStudy selectByPrimaryKey(Integer studyid) {
        return pStudyDao.selectByPrimaryKey(studyid);
    }

    @Override
    public int updateByExampleSelective(PStudy pStudy, PStudyExample example) {
        return pStudyDao.updateByExampleSelective(pStudy,example);
    }

    @Override
    public int updateByExample(PStudy pStudy, PStudyExample example) {
        return pStudyDao.updateByExample(pStudy,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PStudy pStudy) {
        return pStudyDao.updateByPrimaryKeySelective(pStudy);
    }

    @Override
    public int updateByPrimaryKey(PStudy pStudy) {
        return pStudyDao.updateByPrimaryKey(pStudy);
    }

}