package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PWxUser;
import cn.dlbdata.dangjian.admin.dao.model.PWxUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PWxUserService {

    public long countByExample(PWxUserExample example);
    
    public int deleteByExample(PWxUserExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PWxUser pWxUser);
    
    public int insertSelective(PWxUser pWxUser);
    
    public List<PWxUser> selectByExample(PWxUserExample example);

    public PWxUser selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pWxUser") PWxUser pWxUser, @Param("example") PWxUserExample example);

    public int updateByExample(@Param("pWxUser") PWxUser pWxUser, @Param("example") PWxUserExample example);

    public int updateByPrimaryKeySelective(PWxUser pWxUser);

    public int updateByPrimaryKey(PWxUser pWxUser);
    
}