package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePicture;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PAvantgradePictureDao {
    long countByExample(PAvantgradePictureExample example);

    int deleteByExample(PAvantgradePictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PAvantgradePicture record);

    int insertSelective(PAvantgradePicture record);

    List<PAvantgradePicture> selectByExample(PAvantgradePictureExample example);

    PAvantgradePicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PAvantgradePicture record, @Param("example") PAvantgradePictureExample example);

    int updateByExample(@Param("record") PAvantgradePicture record, @Param("example") PAvantgradePictureExample example);

    int updateByPrimaryKeySelective(PAvantgradePicture record);

    int updateByPrimaryKey(PAvantgradePicture record);
}