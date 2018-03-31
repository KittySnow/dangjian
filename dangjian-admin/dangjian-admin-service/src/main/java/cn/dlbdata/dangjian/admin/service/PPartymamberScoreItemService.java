package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymamberScoreItemService {

    public long countByExample(PPartymamberScoreItemExample example);
    
    public int deleteByExample(PPartymamberScoreItemExample example);
    
    public int deleteByPrimaryKey(Integer item_id);
    
    public int insert(PPartymamberScoreItem pPartymamberScoreItem);
    
    public int insertSelective(PPartymamberScoreItem pPartymamberScoreItem);
    
    public List<PPartymamberScoreItem> selectByExample(PPartymamberScoreItemExample example);

    public PPartymamberScoreItem selectByPrimaryKey(Integer item_id);

    public int updateByExampleSelective(@Param("pPartymamberScoreItem") PPartymamberScoreItem pPartymamberScoreItem, @Param("example") PPartymamberScoreItemExample example);

    public int updateByExample(@Param("pPartymamberScoreItem") PPartymamberScoreItem pPartymamberScoreItem, @Param("example") PPartymamberScoreItemExample example);

    public int updateByPrimaryKeySelective(PPartymamberScoreItem pPartymamberScoreItem);

    public int updateByPrimaryKey(PPartymamberScoreItem pPartymamberScoreItem);
    
}