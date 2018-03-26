package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PSpace;
import cn.dlbdata.dangjian.admin.dao.model.PSpaceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PSpaceDao {
    long countByExample(PSpaceExample example);

    int deleteByExample(PSpaceExample example);

    int deleteByPrimaryKey(Integer spaceid);

    int insert(PSpace record);

    int insertSelective(PSpace record);

    List<PSpace> selectByExample(PSpaceExample example);

    PSpace selectByPrimaryKey(Integer spaceid);

    int updateByExampleSelective(@Param("record") PSpace record, @Param("example") PSpaceExample example);

    int updateByExample(@Param("record") PSpace record, @Param("example") PSpaceExample example);

    int updateByPrimaryKeySelective(PSpace record);

    int updateByPrimaryKey(PSpace record);

    int updateByToid(PSpace pSpace);

}