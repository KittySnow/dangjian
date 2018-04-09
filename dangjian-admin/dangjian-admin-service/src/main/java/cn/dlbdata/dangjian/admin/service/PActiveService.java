package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PActiveService {

    public long countByExample(PActiveExample example);
    
    public int deleteByExample(PActiveExample example);
    
    public int deleteByPrimaryKey(Integer activeId);
    
    public int insert(PActive pActive);
    
    public int insertSelective(PActive pActive);
    
    public List<PActive> selectByExample(PActiveExample example);

    public PActive selectByPrimaryKey(Integer activeId);

    public int updateByExampleSelective(@Param("pActive") PActive pActive, @Param("example") PActiveExample example);

    public int updateByExample(@Param("pActive") PActive pActive, @Param("example") PActiveExample example);

    public int updateByPrimaryKeySelective(PActive pActive);

    public int updateByPrimaryKey(PActive pActive);

    public int selectByActiveTypeAndUserParticipate(@Param("userId") Integer userId,  @Param("activeType")Integer activeType);

    public int savePicture(PActivePicture activePicture);

}