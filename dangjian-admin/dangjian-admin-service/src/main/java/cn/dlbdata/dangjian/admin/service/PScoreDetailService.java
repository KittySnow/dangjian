package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PScoreDetailService {

    public long countByExample(PScoreDetailExample example);
    
    public int deleteByExample(PScoreDetailExample example);
    
    public int deleteByPrimaryKey(Integer id);
    
    public int insert(PScoreDetail pScoreDetail);
    
    public int insertSelective(PScoreDetail pScoreDetail);
    
    public List<PScoreDetail> selectByExample(PScoreDetailExample example);

    public PScoreDetail selectByPrimaryKey(Integer id);

    public int updateByExampleSelective(@Param("pScoreDetail") PScoreDetail pScoreDetail, @Param("example") PScoreDetailExample example);

    public int updateByExample(@Param("pScoreDetail") PScoreDetail pScoreDetail, @Param("example") PScoreDetailExample example);

    public int updateByPrimaryKeySelective(PScoreDetail pScoreDetail);

    public int updateByPrimaryKey(PScoreDetail pScoreDetail);

    List<Map<String,Object>> selectTodoList(Integer userId);
    
    public int selectTodoListCount(Integer userId);

}