package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PScoreProject;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProjectExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PScoreProjectDao {
    long countByExample(PScoreProjectExample example);

    int deleteByExample(PScoreProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PScoreProject record);

    int insertSelective(PScoreProject record);

    List<PScoreProject> selectByExample(PScoreProjectExample example);

    PScoreProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PScoreProject record, @Param("example") PScoreProjectExample example);

    int updateByExample(@Param("record") PScoreProject record, @Param("example") PScoreProjectExample example);

    int updateByPrimaryKeySelective(PScoreProject record);

    int updateByPrimaryKey(PScoreProject record);
}