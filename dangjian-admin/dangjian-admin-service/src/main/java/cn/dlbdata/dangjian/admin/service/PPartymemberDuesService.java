package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDuesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymemberDuesService {

    public long countByExample(PPartymemberDuesExample example);
    
    public int deleteByExample(PPartymemberDuesExample example);
    
    public int deleteByPrimaryKey(Integer dues_id);
    
    public int insert(PPartymemberDues pPartymemberDues);
    
    public int insertSelective(PPartymemberDues pPartymemberDues);
    
    public List<PPartymemberDues> selectByExample(PPartymemberDuesExample example);

    public PPartymemberDues selectByPrimaryKey(Integer dues_id);

    public int updateByExampleSelective(@Param("pPartymemberDues") PPartymemberDues pPartymemberDues, @Param("example") PPartymemberDuesExample example);

    public int updateByExample(@Param("pPartymemberDues") PPartymemberDues pPartymemberDues, @Param("example") PPartymemberDuesExample example);

    public int updateByPrimaryKeySelective(PPartymemberDues pPartymemberDues);

    public int updateByPrimaryKey(PPartymemberDues pPartymemberDues);
    
}