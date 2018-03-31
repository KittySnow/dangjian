package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipate;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipateExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PActiveParticipateDao {
    long countByExample(PActiveParticipateExample example);

    int deleteByExample(PActiveParticipateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PActiveParticipate record);

    int insertSelective(PActiveParticipate record);

    List<PActiveParticipate> selectByExample(PActiveParticipateExample example);

    PActiveParticipate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PActiveParticipate record, @Param("example") PActiveParticipateExample example);

    int updateByExample(@Param("record") PActiveParticipate record, @Param("example") PActiveParticipateExample example);

    int updateByPrimaryKeySelective(PActiveParticipate record);

    int updateByPrimaryKey(PActiveParticipate record);
}