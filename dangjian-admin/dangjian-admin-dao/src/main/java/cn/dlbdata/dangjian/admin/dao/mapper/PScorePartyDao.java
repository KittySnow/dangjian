package cn.dlbdata.dangjian.admin.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PScorePartyExample;
import cn.dlbdata.dangjian.admin.dao.vo.PScorePartyVo;
@Mapper
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

    int updateScanCode(PScoreParty pScoreParty);

    int updateScoreCustom(PScoreParty pScoreParty);

    int updateSscoreClean(PScoreParty pScoreParty);

    PScoreParty isInsertRights(PScoreParty pScoreParty);

    int updateAudit(PScoreParty pScoreParty);

    List<PScoreParty> getProjectScoreByUserId(@Param("userId")Integer  userId , @Param("year") Integer year);
    
    Double getSumScoreByProjectIdAndUserId(@Param("projectId")Integer projectId, @Param("userId")Integer  userId , @Param("year") Integer year);

    Double getSumScoreByUserId(@Param("userId")Integer  userId , @Param("year") Integer year);

    List<PScoreParty> getDakDetialByDepartmentId(@Param("departmentId")Integer departmentId);

    List<PScorePartyVo> getScoreAndActiveList(Integer userId);

}