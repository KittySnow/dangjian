package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PFeature;
import cn.dlbdata.dangjian.admin.dao.model.PFeatureExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PFeatureService {

    public long countByExample(PFeatureExample example);
    
    public int deleteByExample(PFeatureExample example);
    
    public int deleteByPrimaryKey(Integer featureId);
    
    public int insert(PFeature pFeature);
    
    public int insertSelective(PFeature pFeature);
    
    public List<PFeature> selectByExample(PFeatureExample example);
    public List<PFeature> selectByEmail(final String lowercase);

    public PFeature selectByPrimaryKey(Integer featureId);

    public int updateByExampleSelective(@Param("pFeature") PFeature pFeature, @Param("example") PFeatureExample example);

    public int updateByExample(@Param("pFeature") PFeature pFeature, @Param("example") PFeatureExample example);

    public int updateByPrimaryKeySelective(PFeature pFeature);

    public int updateByPrimaryKey(PFeature pFeature);
    
}