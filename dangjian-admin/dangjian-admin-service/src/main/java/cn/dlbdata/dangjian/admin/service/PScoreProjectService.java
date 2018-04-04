package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PScoreProject;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PScoreProjectService {

    public long countByExample(PScoreProjectExample example);
    
    public int deleteByExample(PScoreProjectExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PScoreProject pScoreProject);
    
    public int insertSelective(PScoreProject pScoreProject);
    
    public List<PScoreProject> selectByExample(PScoreProjectExample example);

    public PScoreProject selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pScoreProject") PScoreProject pScoreProject, @Param("example") PScoreProjectExample example);

    public int updateByExample(@Param("pScoreProject") PScoreProject pScoreProject, @Param("example") PScoreProjectExample example);

    public int updateByPrimaryKeySelective(PScoreProject pScoreProject);

    public int updateByPrimaryKey(PScoreProject pScoreProject);

    List<PScoreProject> selectByUserExample(PScoreProject pScoreProject);
}