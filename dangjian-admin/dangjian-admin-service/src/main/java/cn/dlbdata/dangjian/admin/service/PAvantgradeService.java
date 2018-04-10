package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgrade;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PAvantgradeService {

    public long countByExample(PAvantgradeExample example);
    
    public int deleteByExample(PAvantgradeExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PAvantgrade pAvantgrade);
    
    public int insertSelective(PAvantgrade pAvantgrade);
    
    public List<PAvantgrade> selectByExample(PAvantgradeExample example);

    public PAvantgrade selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pAvantgrade") PAvantgrade pAvantgrade, @Param("example") PAvantgradeExample example);

    public int updateByExample(@Param("pAvantgrade") PAvantgrade pAvantgrade, @Param("example") PAvantgradeExample example);

    public int updateByPrimaryKeySelective(PAvantgrade pAvantgrade);

    public int updateByPrimaryKey(PAvantgrade pAvantgrade);
    
}