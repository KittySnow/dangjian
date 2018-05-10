package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.dao.model.PActivePicture;
import cn.dlbdata.dangjian.admin.dao.query.ActiveQuery;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public int selectByActiveTypeAndUserParticipate(Integer userId, Integer activeType, Date startTime, Date endTime);

    public int savePicture(PActivePicture activePicture);

    List<Map<String,Object>> getRunningActive(ActiveQuery activeQuery);

    int getRunningActiveCount(ActiveQuery activeQuery);
    
    int deleteActivePicById(Integer id);
}