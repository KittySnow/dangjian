package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PScorePartyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PScorePartyDao {
    long countByExample(PScorePartyExample example);

    int deleteByExample(PScorePartyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PScoreParty record);

    int insertSelective(PScoreParty record);

    List<PScoreParty> selectByExample(PScorePartyExample example);

    PScoreParty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PScoreParty record, @Param("example") PScorePartyExample example);

    int updateByExample(@Param("record") PScoreParty record, @Param("example") PScorePartyExample example);

    int updateByPrimaryKeySelective(PScoreParty record);

    int updateByPrimaryKey(PScoreParty record);
}