package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import cn.dlbdata.dangjian.admin.dao.model.PPicture;
import cn.dlbdata.dangjian.admin.dao.model.PPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PPictureService {

    public long countByExample(PPictureExample example);
    
    public int deleteByExample(PPictureExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PPicture pPicture);
    
    public int insertSelective(PPicture pPicture);
    
    public List<PPicture> selectByExample(PPictureExample example);

    public PPicture selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pPicture") PPicture pPicture, @Param("example") PPictureExample example);

    public int updateByExample(@Param("pPicture") PPicture pPicture, @Param("example") PPictureExample example);

    public int updateByPrimaryKeySelective(PPicture pPicture);

    public int updateByPrimaryKey(PPicture pPicture);

    public List<PActivePicture> selectActivePictures(PActivePictureExample example);
    
}