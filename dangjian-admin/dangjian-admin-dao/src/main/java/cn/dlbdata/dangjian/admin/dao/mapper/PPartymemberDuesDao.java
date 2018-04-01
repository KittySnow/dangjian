package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDuesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberDuesDao {
    long countByExample(PPartymemberDuesExample example);

    int deleteByExample(PPartymemberDuesExample example);

    int deleteByPrimaryKey(Integer duesId);

    int insert(PPartymemberDues record);

    int insertSelective(PPartymemberDues record);

    List<PPartymemberDues> selectByExample(PPartymemberDuesExample example);

    PPartymemberDues selectByPrimaryKey(Integer duesId);

    int updateByExampleSelective(@Param("record") PPartymemberDues record, @Param("example") PPartymemberDuesExample example);

    int updateByExample(@Param("record") PPartymemberDues record, @Param("example") PPartymemberDuesExample example);

    int updateByPrimaryKeySelective(PPartymemberDues record);

    int updateByPrimaryKey(PPartymemberDues record);
}