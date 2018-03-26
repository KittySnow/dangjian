package cn.dlbdata.dangjian.admin.service;


import cn.dlbdata.dangjian.admin.dao.model.PSpace;
import cn.dlbdata.dangjian.admin.dao.model.PSpaceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PSpaceService {

    public long countByExample(PSpaceExample example);
    
    public int deleteByExample(PSpaceExample example);
    
    public int deleteByPrimaryKey(Integer spaceId);

    public int insert(PSpace pSpace);
    
    public int insertSelective(PSpace pSpace);
    
    public List<PSpace> selectByExample(PSpaceExample example);

    public PSpace selectByPrimaryKey(Integer spaceId);

    public int updateByExampleSelective(@Param("pSpace") PSpace pSpace, @Param("example") PSpaceExample example);

    public int updateByExample(@Param("pSpace") PSpace pSpace, @Param("example") PSpaceExample example);

    public int updateByPrimaryKeySelective(PSpace pSpace);

    public int updateByPrimaryKey(PSpace pSpace);

    public int updateByToid(PSpace pSpace);

    
}