package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PStudyPicture;
import cn.dlbdata.dangjian.admin.dao.model.PStudyPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PStudyPictureDao {
    long countByExample(PStudyPictureExample example);

    int deleteByExample(PStudyPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PStudyPicture record);

    int insertSelective(PStudyPicture record);

    List<PStudyPicture> selectByExample(PStudyPictureExample example);

    PStudyPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PStudyPicture record, @Param("example") PStudyPictureExample example);

    int updateByExample(@Param("record") PStudyPicture record, @Param("example") PStudyPictureExample example);

    int updateByPrimaryKeySelective(PStudyPicture record);

    int updateByPrimaryKey(PStudyPicture record);
}