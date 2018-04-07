package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PWxUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PWxUser;
import cn.dlbdata.dangjian.admin.dao.model.PWxUserExample;
import cn.dlbdata.dangjian.admin.service.PWxUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PWxUserService")
public class PWxUserServiceImpl implements PWxUserService {

    private static Logger _log = LoggerFactory.getLogger(PWxUserServiceImpl.class);

    @Autowired
    PWxUserDao pWxUserDao;

    @Override
    public long countByExample(PWxUserExample example) {
        return pWxUserDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PWxUserExample example) {
        return pWxUserDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pWxUserDao.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(PWxUser pWxUser) {
        pWxUserDao.insert(pWxUser);
        return pWxUser.getId();
    }
    
    @Override
    public int insertSelective(PWxUser pWxUser) {
        pWxUserDao.insertSelective(pWxUser);
        return pWxUser.getId();
    }
    
    @Override
    public List<PWxUser> selectByExample(PWxUserExample example) {
        return pWxUserDao.selectByExample(example);
    }

    @Override
    public PWxUser selectByPrimaryKey(Integer id) {
        return pWxUserDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PWxUser pWxUser, PWxUserExample example) {
        return pWxUserDao.updateByExampleSelective(pWxUser,example);
    }

    @Override
    public int updateByExample(PWxUser pWxUser, PWxUserExample example) {
        return pWxUserDao.updateByExample(pWxUser,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PWxUser pWxUser) {
        return pWxUserDao.updateByPrimaryKeySelective(pWxUser);
    }

    @Override
    public int updateByPrimaryKey(PWxUser pWxUser) {
        return pWxUserDao.updateByPrimaryKey(pWxUser);
    }

}