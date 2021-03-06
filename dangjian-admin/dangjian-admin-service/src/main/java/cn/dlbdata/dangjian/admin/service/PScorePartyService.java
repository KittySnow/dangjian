package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PScorePartyExample;
import cn.dlbdata.dangjian.admin.dao.vo.PScorePartyVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PScorePartyService {

    public long countByExample(PScorePartyExample example);
    
    public int deleteByExample(PScorePartyExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PScoreParty pScoreParty);
    
    public int insertSelective(PScoreParty pScoreParty);
    
    public List<PScoreParty> selectByExample(PScorePartyExample example);

    public PScoreParty selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pScoreParty") PScoreParty pScoreParty, @Param("example") PScorePartyExample example);

    public int updateByExample(@Param("pScoreParty") PScoreParty pScoreParty, @Param("example") PScorePartyExample example);

    public int updateByPrimaryKeySelective(PScoreParty pScoreParty);

    public int updateByPrimaryKey(PScoreParty pScoreParty);

    int updateScanCode(PScoreParty pScoreParty);

    int updateScoreCustom(PScoreParty pScoreParty);

    int updateSscoreClean(PScoreParty pScoreParty);

    int updateAudit(PScoreParty pScoreParty);

    public List<PScoreParty> getProjectScoreByUserId(Integer userId , Integer year);

    public Double getSumScoreByUserId(Integer userId ,Integer year);
    
    /**
     * 
     * @param projectId
     * @param userId
     * @param year
     * @return
     */
    public Double getSumScoreByProjectIdAndUserId(Integer projectId, Integer userId,Integer year);

    public List<PScoreParty> getDakDetialByDepartmentId(Integer departmentId);

    public PScoreParty isInsertRights(PScoreParty pScoreParty);
    
    public List<PScorePartyVo> getScoreAndActiveList(@Param("userId") Integer userId);

}