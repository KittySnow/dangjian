package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PScoreDetailDao {
    long countByExample(PScoreDetailExample example);

    int deleteByExample(PScoreDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PScoreDetail record);

    int insertSelective(PScoreDetail record);

    List<PScoreDetail> selectByExample(PScoreDetailExample example);

    PScoreDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PScoreDetail record, @Param("example") PScoreDetailExample example);

    int updateByExample(@Param("record") PScoreDetail record, @Param("example") PScoreDetailExample example);

    int updateByPrimaryKeySelective(PScoreDetail record);

    int updateByPrimaryKey(PScoreDetail record);
}