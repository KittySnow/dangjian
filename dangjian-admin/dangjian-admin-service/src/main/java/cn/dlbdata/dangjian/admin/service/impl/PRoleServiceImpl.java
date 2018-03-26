package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PRoleDao;
import cn.dlbdata.dangjian.admin.dao.model.PRole;
import cn.dlbdata.dangjian.admin.dao.model.PRoleExample;
import cn.dlbdata.dangjian.admin.service.PRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PRoleService")
public class PRoleServiceImpl implements PRoleService {

    private static Logger _log = LoggerFactory.getLogger(PRoleServiceImpl.class);

    @Autowired
    PRoleDao pRoleDao;

    @Override
    public long countByExample(PRoleExample example) {
        return pRoleDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PRoleExample example) {
        return pRoleDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return pRoleDao.deleteByPrimaryKey(roleid);
    }
    
    @Override
    public int insert(PRole pRole) {
        pRoleDao.insert(pRole);
        return pRole.getRoleid();
    }
    
    @Override
    public int insertSelective(PRole pRole) {
        pRoleDao.insertSelective(pRole);
        return pRole.getRoleid();
    }
    
    @Override
    public List<PRole> selectByExample(String searchText) {
        return pRoleDao.selectByExample(searchText);
    }

    @Override
    public PRole selectByPrimaryKey(Integer roleId) {
        return pRoleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByExampleSelective(PRole pRole, PRoleExample example) {
        return pRoleDao.updateByExampleSelective(pRole,example);
    }

    @Override
    public int updateByExample(PRole pRole, PRoleExample example) {
        return pRoleDao.updateByExample(pRole,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PRole pRole) {
        return pRoleDao.updateByPrimaryKeySelective(pRole);
    }

    @Override
    public int updateByPrimaryKey(PRole pRole) {
        return pRoleDao.updateByPrimaryKey(pRole);
    }

}