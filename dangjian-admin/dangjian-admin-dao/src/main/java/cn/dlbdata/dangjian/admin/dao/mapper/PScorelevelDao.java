package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PScorelevel;
import cn.dlbdata.dangjian.admin.dao.model.PScorelevelExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PScorelevelDao {
    long countByExample(PScorelevelExample example);

    int deleteByExample(PScorelevelExample example);

    int deleteByPrimaryKey(Integer scoreid);

    int insert(PScorelevel record);

    int insertSelective(PScorelevel record);

    List<PScorelevel> selectByExample(PScorelevelExample example);

    PScorelevel selectByPrimaryKey(Integer scoreid);

    int updateByExampleSelective(@Param("record") PScorelevel record, @Param("example") PScorelevelExample example);

    int updateByExample(@Param("record") PScorelevel record, @Param("example") PScorelevelExample example);

    int updateByPrimaryKeySelective(PScorelevel record);

    int updateByPrimaryKey(PScorelevel record);
}