package cn.dlbdata.dangjian.admin.service;


import cn.dlbdata.dangjian.admin.dao.model.PRole;
import cn.dlbdata.dangjian.admin.dao.model.PRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PRoleService {

    public long countByExample(PRoleExample example);
    
    public int deleteByExample(PRoleExample example);
    
    public int deleteByPrimaryKey(Integer roleid);
    
    public int insert(PRole pRole);
    
    public int insertSelective(PRole pRole);
    
    public List<PRole> selectByExample(String searchText);

    public PRole selectByPrimaryKey(Integer roleId);

    public int updateByExampleSelective(@Param("pRole") PRole pRole, @Param("example") PRoleExample example);

    public int updateByExample(@Param("pRole") PRole pRole, @Param("example") PRoleExample example);

    public int updateByPrimaryKeySelective(PRole pRole);

    public int updateByPrimaryKey(PRole pRole);
    
}