package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDuesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPartymenberDuesDao {
    long countByExample(PPartymenberDuesExample example);

    int deleteByExample(PPartymenberDuesExample example);

    int deleteByPrimaryKey(Integer duesId);

    int insert(PPartymenberDues record);

    int insertSelective(PPartymenberDues record);

    List<PPartymenberDues> selectByExample(PPartymenberDuesExample example);

    PPartymenberDues selectByPrimaryKey(Integer duesId);

    int updateByExampleSelective(@Param("record") PPartymenberDues record, @Param("example") PPartymenberDuesExample example);

    int updateByExample(@Param("record") PPartymenberDues record, @Param("example") PPartymenberDuesExample example);

    int updateByPrimaryKeySelective(PPartymenberDues record);

    int updateByPrimaryKey(PPartymenberDues record);
}