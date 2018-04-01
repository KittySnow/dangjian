package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PActivePictureDao {
    long countByExample(PActivePictureExample example);

    int deleteByExample(PActivePictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PActivePicture record);

    int insertSelective(PActivePicture record);

    List<PActivePicture> selectByExample(PActivePictureExample example);

    PActivePicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PActivePicture record, @Param("example") PActivePictureExample example);

    int updateByExample(@Param("record") PActivePicture record, @Param("example") PActivePictureExample example);

    int updateByPrimaryKeySelective(PActivePicture record);

    int updateByPrimaryKey(PActivePicture record);
}