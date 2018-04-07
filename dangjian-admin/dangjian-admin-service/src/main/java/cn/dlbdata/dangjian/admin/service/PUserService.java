package cn.dlbdata.dangjian.admin.service;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PUserService {

    public long countByExample(PUserExample example);

    public int deleteByExample(PUserExample example);

    public int deleteByPrimaryKey(Integer userid);

    public int insert(PUser record);

    public int insertSelective(PUser record);

    public List<PUser> selectByExample(PUserExample example);

    public List<PUser> selectAll(String searchText);

    public PUser selectByPrimaryKey(Integer userid);
    public PUser selectByEmail(final String email);
    public int updatePasswordByEmail(final PUser user);
    
    public int updateByExampleSelective(@Param("record") PUser record, @Param("example") PUserExample example);

    public int updateByExample(@Param("record") PUser record, @Param("example") PUserExample example);

    public int updateByPrimaryKeySelective(PUser record);

    public int updateByPrimaryKey(PUser record);

    PUser tologin(String name, String password);
    public PUser findRoleid(String name);

    public void saveLoginUserInfo(int userId, String token, String openId);
}
