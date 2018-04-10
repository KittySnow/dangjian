package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PDepartmentService {

    public long countByExample(PDepartmentExample example);
    
    public int deleteByExample(PDepartmentExample example);
    
    public int deleteByPrimaryKey(Integer departmentId);
    
    public int insert(PDepartment pDepartment);
    
    public int insertSelective(PDepartment pDepartment);
    
    public List<PDepartment> selectByExample(PDepartmentExample example);

    public PDepartment selectByPrimaryKey(Integer departmentId);

    public int updateByExampleSelective(@Param("pDepartment") PDepartment pDepartment, @Param("example") PDepartmentExample example);

    public int updateByExample(@Param("pDepartment") PDepartment pDepartment, @Param("example") PDepartmentExample example);

    public int updateByPrimaryKeySelective(PDepartment pDepartment);

    public int updateByPrimaryKey(PDepartment pDepartment);

    public int getSumPeople();

    public int getSumDepartment();

}