package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymamberScoreItemDao {
    long countByExample(PPartymamberScoreItemExample example);

    int deleteByExample(PPartymamberScoreItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(PPartymamberScoreItem record);

    int insertSelective(PPartymamberScoreItem record);

    List<PPartymamberScoreItem> selectByExampleWithBLOBs(PPartymamberScoreItemExample example);

    List<PPartymamberScoreItem> selectByExample(PPartymamberScoreItemExample example);

    PPartymamberScoreItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") PPartymamberScoreItem record, @Param("example") PPartymamberScoreItemExample example);

    int updateByExampleWithBLOBs(@Param("record") PPartymamberScoreItem record, @Param("example") PPartymamberScoreItemExample example);

    int updateByExample(@Param("record") PPartymamberScoreItem record, @Param("example") PPartymamberScoreItemExample example);

    int updateByPrimaryKeySelective(PPartymamberScoreItem record);

    int updateByPrimaryKeyWithBLOBs(PPartymamberScoreItem record);

    int updateByPrimaryKey(PPartymamberScoreItem record);
}