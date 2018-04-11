package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgrade;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PAvantgradeDao {
    long countByExample(PAvantgradeExample example);

    int deleteByExample(PAvantgradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PAvantgrade record);

    int insertSelective(PAvantgrade record);

    List<PAvantgrade> selectByExample(PAvantgradeExample example);

    PAvantgrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PAvantgrade record, @Param("example") PAvantgradeExample example);

    int updateByExample(@Param("record") PAvantgrade record, @Param("example") PAvantgradeExample example);

    int updateByPrimaryKeySelective(PAvantgrade record);

    int updateByPrimaryKey(PAvantgrade record);
}