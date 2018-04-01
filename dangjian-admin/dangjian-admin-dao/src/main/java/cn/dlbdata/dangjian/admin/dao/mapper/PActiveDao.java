package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActiveDao {
    long countByExample(PActiveExample example);

    int deleteByExample(PActiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PActive record);

    int insertSelective(PActive record);

    List<PActive> selectByExample(PActiveExample example);

    PActive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PActive record, @Param("example") PActiveExample example);

    int updateByExample(@Param("record") PActive record, @Param("example") PActiveExample example);

    int updateByPrimaryKeySelective(PActive record);

    int updateByPrimaryKey(PActive record);
}