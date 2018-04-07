package cn.dlbdata.dangjian.admin.service.impl;

import cn.dlbdata.dangjian.admin.dao.mapper.PUserDao;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.common.DO.WXUserInfoDO;
import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PUserService")
public class PUserServiceImpl implements PUserService {
    private static Logger logger = LoggerFactory.getLogger(PUserServiceImpl.class);

    @Autowired
    private UserInfoService userInfoService;

    @Resource
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

    @Override
    public PUser tologin(String name, String password) {return this.pUserDao.tologin(name,password);
    }
    @Override
    public PUser findRoleid(String name) {return pUserDao.findRoleid(name);}

    @Override
    public void saveLoginUserInfo(int userId, String token, String openId) {
        pUserDao.saveLoginUserInfo(userId, token, openId);

        GetUserInfo getUserInfo = new GetUserInfo();
        getUserInfo.setLang("zh_CN");
        getUserInfo.setOpenid(openId);

        try {
            JSONObject jsonObject = userInfoService.userInfo(getUserInfo);
            WXUserInfoDO wxUserInfoDO = (WXUserInfoDO) JSONObject.toBean(jsonObject, WXUserInfoDO.class);

        } catch (DangjianException e) {
            logger.error("Get wx userinfo error.", e);
        }
    }
}