package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PPicture;
import cn.dlbdata.dangjian.admin.dao.model.PPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPictureDao {
    long countByExample(PPictureExample example);

    int deleteByExample(PPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PPicture record);

    int insertSelective(PPicture record);

    List<PPicture> selectByExample(PPictureExample example);

    PPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PPicture record, @Param("example") PPictureExample example);

    int updateByExample(@Param("record") PPicture record, @Param("example") PPictureExample example);

    int updateByPrimaryKeySelective(PPicture record);

    int updateByPrimaryKey(PPicture record);
}