package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PStudy;
import cn.dlbdata.dangjian.admin.dao.model.PStudyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PStudyDao {
    long countByExample(PStudyExample example);

    int deleteByExample(PStudyExample example);

    int deleteByPrimaryKey(Integer studyid);

    int insert(PStudy record);

    int insertSelective(PStudy record);

    List<PStudy> selectByExampleWithBLOBs(PStudyExample example);

    List<PStudy> selectByExample(PStudyExample example);

    PStudy selectByPrimaryKey(Integer studyid);

    int updateByExampleSelective(@Param("record") PStudy record, @Param("example") PStudyExample example);

    int updateByExampleWithBLOBs(@Param("record") PStudy record, @Param("example") PStudyExample example);

    int updateByExample(@Param("record") PStudy record, @Param("example") PStudyExample example);

    int updateByPrimaryKeySelective(PStudy record);

    int updateByPrimaryKeyWithBLOBs(PStudy record);

    int updateByPrimaryKey(PStudy record);



}