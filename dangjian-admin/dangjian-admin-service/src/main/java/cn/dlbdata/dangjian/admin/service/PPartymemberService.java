package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberService {
    public long countUser();

    public long countByExample(PPartymemberExample example);
    
    public int deleteByExample(PPartymemberExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PPartymember pPartymember);
    
    public int insertSelective(PPartymember pPartymember);
    
    public List<PPartymember> selectByExample(PPartymemberExample example);

    public PPartymember selectByUserId(Integer userid);

    public PPartymember selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pPartymember") PPartymember pPartymember, @Param("example") PPartymemberExample example);

    public int updateByExample(@Param("pPartymember") PPartymember pPartymember, @Param("example") PPartymemberExample example);

    public int updateByPrimaryKeySelective(PPartymember pPartymember);

    public int updateByPrimaryKey(PPartymember pPartymember);

    public List<PPartymember> getPartymemberByDepartmentid(@Param("departmentid") Integer departmentid,@Param("status") Integer status);
    
}