package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PStudy;
import cn.dlbdata.dangjian.admin.dao.model.PStudyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PStudyService {

    public long countByExample(PStudyExample example);
    
    public int deleteByExample(PStudyExample example);
    
    public int deleteByPrimaryKey(Integer studyid);
    
    public int insert(PStudy pStudy);
    
    public int insertSelective(PStudy pStudy);
    
    public List<PStudy> selectByExample(PStudyExample example);

    public PStudy selectByPrimaryKey(Integer studyid);

    public int updateByExampleSelective(@Param("pStudy") PStudy pStudy, @Param("example") PStudyExample example);

    public int updateByExample(@Param("pStudy") PStudy pStudy, @Param("example") PStudyExample example);

    public int updateByPrimaryKeySelective(PStudy pStudy);

    public int updateByPrimaryKey(PStudy pStudy);
    
}