package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberDao {
    long countUser();

    long countByExample(PPartymemberExample example);

    int deleteByExample(PPartymemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PPartymember record);

    int insertSelective(PPartymember record);

    List<PPartymember> selectByExample(PPartymemberExample example);

    List<PPartymember> selectAll();

    PPartymember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PPartymember record, @Param("example") PPartymemberExample example);

    int updateByExample(@Param("record") PPartymember record, @Param("example") PPartymemberExample example);

    int updateByPrimaryKeySelective(PPartymember record);

    int updateByPrimaryKey(PPartymember record);

    List<PPartymember> getPartymemberByDepartmentid(@Param("departmentid") Integer departmentid,@Param("status") Integer status);
    
    List<PPartymember> queryAreaListById();

}