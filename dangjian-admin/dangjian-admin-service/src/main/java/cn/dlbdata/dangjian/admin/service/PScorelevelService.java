package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PScorelevel;
import cn.dlbdata.dangjian.admin.dao.model.PScorelevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PScorelevelService {

    public long countByExample(PScorelevelExample example);
    
    public int deleteByExample(PScorelevelExample example);
    
    public int deleteByPrimaryKey(Integer scoreid);
    
    public int insert(PScorelevel pScorelevel);
    
    public int insertSelective(PScorelevel pScorelevel);
    
    public List<PScorelevel> selectByExample(PScorelevelExample example);

    public PScorelevel selectByPrimaryKey(Integer scoreid);

    public int updateByExampleSelective(@Param("pScorelevel") PScorelevel pScorelevel, @Param("example") PScorelevelExample example);

    public int updateByExample(@Param("pScorelevel") PScorelevel pScorelevel, @Param("example") PScorelevelExample example);

    public int updateByPrimaryKeySelective(PScorelevel pScorelevel);

    public int updateByPrimaryKey(PScorelevel pScorelevel);
    
}