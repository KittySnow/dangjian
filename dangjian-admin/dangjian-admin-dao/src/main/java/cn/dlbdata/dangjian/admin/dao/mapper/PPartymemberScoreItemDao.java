package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberScoreItemDao {
    long countByExample(PPartymemberScoreItemExample example);

    int deleteByExample(PPartymemberScoreItemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(PPartymemberScoreItem record);

    int insertSelective(PPartymemberScoreItem record);

    List<PPartymemberScoreItem> selectByExampleWithBLOBs(PPartymemberScoreItemExample example);

    List<PPartymemberScoreItem> selectByExample(PPartymemberScoreItemExample example);

    PPartymemberScoreItem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") PPartymemberScoreItem record, @Param("example") PPartymemberScoreItemExample example);

    int updateByExampleWithBLOBs(@Param("record") PPartymemberScoreItem record, @Param("example") PPartymemberScoreItemExample example);

    int updateByExample(@Param("record") PPartymemberScoreItem record, @Param("example") PPartymemberScoreItemExample example);

    int updateByPrimaryKeySelective(PPartymemberScoreItem record);

    int updateByPrimaryKeyWithBLOBs(PPartymemberScoreItem record);

    int updateByPrimaryKey(PPartymemberScoreItem record);
}