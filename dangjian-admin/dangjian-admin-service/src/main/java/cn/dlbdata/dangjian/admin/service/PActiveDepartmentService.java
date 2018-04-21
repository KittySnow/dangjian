package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActiveDepartmentService {

    public long countByExample(PActiveDepartmentExample example);
    
    public int deleteByExample(PActiveDepartmentExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PActiveDepartment pActiveDepartment);
    
    public int insertSelective(PActiveDepartment pActiveDepartment);
    
    public List<PActiveDepartment> selectByExample(PActiveDepartmentExample example);

    public PActiveDepartment selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pActiveDepartment") PActiveDepartment pActiveDepartment, @Param("example") PActiveDepartmentExample example);

    public int updateByExample(@Param("pActiveDepartment") PActiveDepartment pActiveDepartment, @Param("example") PActiveDepartmentExample example);

    public int updateByPrimaryKeySelective(PActiveDepartment pActiveDepartment);

    public int updateByPrimaryKey(PActiveDepartment pActiveDepartment);

    public void insertList(Integer[] departmentIds ,Integer studyId);
    
}