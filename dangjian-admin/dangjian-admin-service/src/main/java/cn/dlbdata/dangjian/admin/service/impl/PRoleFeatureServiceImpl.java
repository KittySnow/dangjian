package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PRoleFeatureDao;
import cn.dlbdata.dangjian.admin.dao.model.PRoleFeature;
import cn.dlbdata.dangjian.admin.service.PRoleFeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PRoleFeatureService")
public class PRoleFeatureServiceImpl implements PRoleFeatureService {

    private static Logger _log = LoggerFactory.getLogger(PRoleFeatureServiceImpl.class);

    @Autowired
    PRoleFeatureDao pRoleFeatureDao;


    @Override
    public int deleteByRoleId(Integer roleid) {
        return pRoleFeatureDao.deleteByRoleId(roleid);
    }

    @Override
    public int insert(List<PRoleFeature> list) {
        return pRoleFeatureDao.insert(list);
    }

    @Override
    public List<PRoleFeature> selectByRoid(Integer roleid) {
        return pRoleFeatureDao.selectByRoid(roleid);
    }
}