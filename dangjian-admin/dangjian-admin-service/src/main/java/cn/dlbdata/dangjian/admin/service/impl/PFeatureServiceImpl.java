package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PFeatureDao;
import cn.dlbdata.dangjian.admin.dao.model.PFeature;
import cn.dlbdata.dangjian.admin.dao.model.PFeatureExample;
import cn.dlbdata.dangjian.admin.service.PFeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PFeatureService")
public class PFeatureServiceImpl implements PFeatureService {

    private static Logger _log = LoggerFactory.getLogger(PFeatureServiceImpl.class);

    @Resource
    PFeatureDao pFeatureDao;

    @Override
    public long countByExample(PFeatureExample example) {
        return pFeatureDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PFeatureExample example) {
        return pFeatureDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer featureId) {
        return pFeatureDao.deleteByPrimaryKey(featureId);
    }
    
    @Override
    public int insert(PFeature pFeature) {
        pFeatureDao.insert(pFeature);
        return pFeature.getFeatureid();
    }
    
    @Override
    public int insertSelective(PFeature pFeature) {
        pFeatureDao.insertSelective(pFeature);
        return pFeature.getFeatureid();
    }
    
    @Override
    public List<PFeature> selectByExample(PFeatureExample example) {
        return pFeatureDao.selectByExample(example);
    }

    @Override
    public PFeature selectByPrimaryKey(Integer featureId) {
        return pFeatureDao.selectByPrimaryKey(featureId);
    }

    @Override
    public int updateByExampleSelective(PFeature pFeature, PFeatureExample example) {
        return pFeatureDao.updateByExampleSelective(pFeature,example);
    }

    @Override
    public int updateByExample(PFeature pFeature, PFeatureExample example) {
        return pFeatureDao.updateByExample(pFeature,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PFeature pFeature) {
        return pFeatureDao.updateByPrimaryKeySelective(pFeature);
    }

    @Override
    public int updateByPrimaryKey(PFeature pFeature) {
        return pFeatureDao.updateByPrimaryKey(pFeature);
    }

	@Override
	public List<PFeature> selectByEmail(String lowercase) {
		return pFeatureDao.selectByEmail(lowercase);
	}

}