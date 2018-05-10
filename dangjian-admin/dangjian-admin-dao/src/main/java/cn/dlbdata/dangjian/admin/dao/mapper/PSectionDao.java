package cn.dlbdata.dangjian.admin.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.dlbdata.dangjian.admin.dao.model.PSection;
import cn.dlbdata.dangjian.admin.dao.model.PSectionExample;

@Mapper
public interface PSectionDao {
	
    long countByExample(PSectionExample example);

    int deleteByExample(PSectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PSection record);

    int insertSelective(PSection record);

    List<PSection> selectByExample(PSectionExample example);

    PSection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PSection record, @Param("example") PSectionExample example);

    int updateByExample(@Param("record") PSection record, @Param("example") PSectionExample example);

    int updateByPrimaryKeySelective(PSection record);

    int updateByPrimaryKey(PSection record);

}
