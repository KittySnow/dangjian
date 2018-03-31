package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipate;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActiveParticipateService {

    public long countByExample(PActiveParticipateExample example);
    
    public int deleteByExample(PActiveParticipateExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PActiveParticipate pActiveParticipate);
    
    public int insertSelective(PActiveParticipate pActiveParticipate);
    
    public List<PActiveParticipate> selectByExample(PActiveParticipateExample example);

    public PActiveParticipate selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pActiveParticipate") PActiveParticipate pActiveParticipate, @Param("example") PActiveParticipateExample example);

    public int updateByExample(@Param("pActiveParticipate") PActiveParticipate pActiveParticipate, @Param("example") PActiveParticipateExample example);

    public int updateByPrimaryKeySelective(PActiveParticipate pActiveParticipate);

    public int updateByPrimaryKey(PActiveParticipate pActiveParticipate);
    
}