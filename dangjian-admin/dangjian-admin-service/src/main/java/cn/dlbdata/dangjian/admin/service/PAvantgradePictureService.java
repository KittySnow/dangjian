package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePicture;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PAvantgradePictureService {

    public long countByExample(PAvantgradePictureExample example);
    
    public int deleteByExample(PAvantgradePictureExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PAvantgradePicture pAvantgradePicture);
    
    public int insertSelective(PAvantgradePicture pAvantgradePicture);
    
    public List<PAvantgradePicture> selectByExample(PAvantgradePictureExample example);

    public PAvantgradePicture selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pAvantgradePicture") PAvantgradePicture pAvantgradePicture, @Param("example") PAvantgradePictureExample example);

    public int updateByExample(@Param("pAvantgradePicture") PAvantgradePicture pAvantgradePicture, @Param("example") PAvantgradePictureExample example);

    public int updateByPrimaryKeySelective(PAvantgradePicture pAvantgradePicture);

    public int updateByPrimaryKey(PAvantgradePicture pAvantgradePicture);

    public void insertList(@Param("picIds") Integer[] picIds, @Param("avantgradeId") Integer avantgradeId );
    
}