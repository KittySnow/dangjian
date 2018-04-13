package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.model.PActivePictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActivePictureService {

    public long countByExample(PActivePictureExample example);
    
    public int deleteByExample(PActivePictureExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PActivePicture pActivePicture);
    
    public int insertSelective(PActivePicture pActivePicture);
    
    public List<PActivePicture> selectByExample(PActivePictureExample example);

    public PActivePicture selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pActivePicture") PActivePicture pActivePicture, @Param("example") PActivePictureExample example);

    public int updateByExample(@Param("pActivePicture") PActivePicture pActivePicture, @Param("example") PActivePictureExample example);

    public int updateByPrimaryKeySelective(PActivePicture pActivePicture);

    public int updateByPrimaryKey(PActivePicture pActivePicture);
    
}