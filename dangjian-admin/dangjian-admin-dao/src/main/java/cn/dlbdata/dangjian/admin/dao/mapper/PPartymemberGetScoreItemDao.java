package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberGetScoreItemDao {
    long countByExample(PPartymemberGetScoreItemExample example);

    int deleteByExample(PPartymemberGetScoreItemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(PPartymemberGetScoreItem record);

    int insertSelective(PPartymemberGetScoreItem record);

    List<PPartymemberGetScoreItem> selectByExampleWithBLOBs(PPartymemberGetScoreItemExample example);

    List<PPartymemberGetScoreItem> selectByExample(PPartymemberGetScoreItemExample example);

    PPartymemberGetScoreItem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") PPartymemberGetScoreItem record, @Param("example") PPartymemberGetScoreItemExample example);

    int updateByExampleWithBLOBs(@Param("record") PPartymemberGetScoreItem record, @Param("example") PPartymemberGetScoreItemExample example);

    int updateByExample(@Param("record") PPartymemberGetScoreItem record, @Param("example") PPartymemberGetScoreItemExample example);

    int updateByPrimaryKeySelective(PPartymemberGetScoreItem record);

    int updateByPrimaryKeyWithBLOBs(PPartymemberGetScoreItem record);

    int updateByPrimaryKey(PPartymemberGetScoreItem record);
}