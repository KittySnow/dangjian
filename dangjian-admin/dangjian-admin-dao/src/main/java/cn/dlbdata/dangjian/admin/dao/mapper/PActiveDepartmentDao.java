package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActiveDepartmentDao {
    long countByExample(PActiveDepartmentExample example);

    int deleteByExample(PActiveDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PActiveDepartment record);

    int insertSelective(PActiveDepartment record);

    List<PActiveDepartment> selectByExample(PActiveDepartmentExample example);

    PActiveDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PActiveDepartment record, @Param("example") PActiveDepartmentExample example);

    int updateByExample(@Param("record") PActiveDepartment record, @Param("example") PActiveDepartmentExample example);

    int updateByPrimaryKeySelective(PActiveDepartment record);

    int updateByPrimaryKey(PActiveDepartment record);

    void insertList(@Param("departmentIds") Integer[] departmentIds , @Param("activeId") Integer activeId);
}