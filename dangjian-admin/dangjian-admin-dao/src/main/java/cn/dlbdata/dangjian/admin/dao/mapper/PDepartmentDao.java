package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PDepartmentDao {
    long countByExample(PDepartmentExample example);

    int deleteByExample(PDepartmentExample example);

    int deleteByPrimaryKey(Integer departmentid);

    int insert(PDepartment record);

    int insertSelective(PDepartment record);

    List<PDepartment> selectByExample(PDepartmentExample example);

    PDepartment selectByPrimaryKey(Integer departmentid);

    int updateByExampleSelective(@Param("record") PDepartment record, @Param("example") PDepartmentExample example);

    int updateByExample(@Param("record") PDepartment record, @Param("example") PDepartmentExample example);

    int updateByPrimaryKeySelective(PDepartment record);

    int updateByPrimaryKey(PDepartment record);

    int getSumPeople();

    int getSumDepartment();
}