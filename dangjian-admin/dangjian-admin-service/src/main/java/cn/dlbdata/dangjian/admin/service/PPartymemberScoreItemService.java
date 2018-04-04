package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberScoreItemService {

    public long countByExample(PPartymemberScoreItemExample example);
    
    public int deleteByExample(PPartymemberScoreItemExample example);
    
    public int deleteByPrimaryKey(Integer itemid);
    
    public int insert(PPartymemberScoreItem pPartymemberScoreItem);
    
    public int insertSelective(PPartymemberScoreItem pPartymemberScoreItem);
    
    public List<PPartymemberScoreItem> selectByExample(PPartymemberScoreItemExample example);

    public PPartymemberScoreItem selectByPrimaryKey(Integer itemid);

    public int updateByExampleSelective(@Param("pPartymemberScoreItem") PPartymemberScoreItem pPartymemberScoreItem, @Param("example") PPartymemberScoreItemExample example);

    public int updateByExample(@Param("pPartymemberScoreItem") PPartymemberScoreItem pPartymemberScoreItem, @Param("example") PPartymemberScoreItemExample example);

    public int updateByPrimaryKeySelective(PPartymemberScoreItem pPartymemberScoreItem);

    public int updateByPrimaryKey(PPartymemberScoreItem pPartymemberScoreItem);
    
}