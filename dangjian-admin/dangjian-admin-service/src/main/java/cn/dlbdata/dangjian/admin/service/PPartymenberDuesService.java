package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDuesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymenberDuesService {

    public long countByExample(PPartymenberDuesExample example);
    
    public int deleteByExample(PPartymenberDuesExample example);
    
    public int deleteByPrimaryKey(Integer dues_id);
    
    public int insert(PPartymenberDues pPartymenberDues);
    
    public int insertSelective(PPartymenberDues pPartymenberDues);
    
    public List<PPartymenberDues> selectByExample(PPartymenberDuesExample example);

    public PPartymenberDues selectByPrimaryKey(Integer dues_id);

    public int updateByExampleSelective(@Param("pPartymenberDues") PPartymenberDues pPartymenberDues, @Param("example") PPartymenberDuesExample example);

    public int updateByExample(@Param("pPartymenberDues") PPartymenberDues pPartymenberDues, @Param("example") PPartymenberDuesExample example);

    public int updateByPrimaryKeySelective(PPartymenberDues pPartymenberDues);

    public int updateByPrimaryKey(PPartymenberDues pPartymenberDues);
    
}