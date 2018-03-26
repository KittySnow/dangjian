package cn.dlbdata.dangjian.admin.service.impl;


import cn.dlbdata.dangjian.admin.dao.mapper.PUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PUserService")
public class PUserServiceImpl implements PUserService {

    private static Logger _log = LoggerFactory.getLogger(PUserServiceImpl.class);

    @Autowired
    PUserDao pUserDao;

    @Override
    public long countByExample(PUserExample example) {
        return pUserDao.countByExample(example);
    }
    
    @Override
    public int deleteByExample(PUserExample example) {
        return pUserDao.deleteByExample(example);
    }
    
    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return pUserDao.deleteByPrimaryKey(userid);
    }
    
    @Override
    public int insert(PUser record) {
        pUserDao.insert(record);
        return record.getUserid();
    }
    
    @Override
    public int insertSelective(PUser record) {
    return pUserDao.insertSelective(record);
    }
    
    @Override
    public List<PUser> selectByExample(PUserExample example) {
        return pUserDao.selectByExample(example);
    }


    public List<PUser> selectAll(String searchText){return pUserDao.selectAll(searchText);};
    @Override
    public PUser selectByPrimaryKey(Integer userid) {
        return pUserDao.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByExampleSelective(PUser record, PUserExample example) {
        return pUserDao.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(PUser record, PUserExample example) {
        return pUserDao.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PUser record) {
        return pUserDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PUser record) {
        return pUserDao.updateByPrimaryKey(record);
    }

	@Override
	public PUser selectByEmail(String email) {
		return pUserDao.selectByEmail(email);
	}

	@Override
	public int updatePasswordByEmail(final PUser user) {
		return pUserDao.updatePasswordByEmail(user);
	}

}