package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberGetScoreItemService {

    public long countByExample(PPartymemberGetScoreItemExample example);
    
    public int deleteByExample(PPartymemberGetScoreItemExample example);
    
    public int deleteByPrimaryKey(Integer itemid);
    
    public int insert(PPartymemberGetScoreItem pPartymemberGetScoreItem);
    
    public int insertSelective(PPartymemberGetScoreItem pPartymemberGetScoreItem);
    
    public List<PPartymemberGetScoreItem> selectByExample(PPartymemberGetScoreItemExample example);

    public PPartymemberGetScoreItem selectByPrimaryKey(Integer itemid);

    public int updateByExampleSelective(@Param("pPartymemberGetScoreItem") PPartymemberGetScoreItem pPartymemberGetScoreItem, @Param("example") PPartymemberGetScoreItemExample example);

    public int updateByExample(@Param("pPartymemberGetScoreItem") PPartymemberGetScoreItem pPartymemberGetScoreItem, @Param("example") PPartymemberGetScoreItemExample example);

    public int updateByPrimaryKeySelective(PPartymemberGetScoreItem pPartymemberGetScoreItem);

    public int updateByPrimaryKey(PPartymemberGetScoreItem pPartymemberGetScoreItem);
    
}