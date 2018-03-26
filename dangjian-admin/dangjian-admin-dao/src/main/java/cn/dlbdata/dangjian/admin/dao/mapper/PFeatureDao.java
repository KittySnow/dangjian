package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PFeature;
import cn.dlbdata.dangjian.admin.dao.model.PFeatureExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PFeatureDao {
    long countByExample(PFeatureExample example);

    int deleteByExample(PFeatureExample example);

    int deleteByPrimaryKey(Integer featureid);

    int insert(PFeature record);

    int insertSelective(PFeature record);

    List<PFeature> selectByExample(PFeatureExample example);
    List<PFeature> selectByEmail(final String lowercase);

    PFeature selectByPrimaryKey(Integer featureid);

    int updateByExampleSelective(@Param("record") PFeature record, @Param("example") PFeatureExample example);

    int updateByExample(@Param("record") PFeature record, @Param("example") PFeatureExample example);

    int updateByPrimaryKeySelective(PFeature record);

    int updateByPrimaryKey(PFeature record);
}