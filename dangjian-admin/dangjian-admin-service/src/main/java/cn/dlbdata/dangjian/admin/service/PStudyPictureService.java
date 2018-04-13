package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PStudyPicture;
import cn.dlbdata.dangjian.admin.dao.model.PStudyPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PStudyPictureService {

    public long countByExample(PStudyPictureExample example);
    
    public int deleteByExample(PStudyPictureExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PStudyPicture pStudyPicture);
    
    public int insertSelective(PStudyPicture pStudyPicture);
    
    public List<PStudyPicture> selectByExample(PStudyPictureExample example);

    public PStudyPicture selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pStudyPicture") PStudyPicture pStudyPicture, @Param("example") PStudyPictureExample example);

    public int updateByExample(@Param("pStudyPicture") PStudyPicture pStudyPicture, @Param("example") PStudyPictureExample example);

    public int updateByPrimaryKeySelective(PStudyPicture pStudyPicture);

    public int updateByPrimaryKey(PStudyPicture pStudyPicture);

    public void insertList(@Param("picIds") Integer[] picIds , @Param("studyid") Integer studyid);
    
}