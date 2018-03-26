package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PRole;
import cn.dlbdata.dangjian.admin.dao.model.PRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PRoleDao {
    long countByExample(PRoleExample example);

    int deleteByExample(PRoleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(PRole record);

    int insertSelective(PRole record);

    List<PRole> selectByExample(String searchText);

    PRole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByExample(@Param("record") PRole record, @Param("example") PRoleExample example);

    int updateByPrimaryKeySelective(PRole record);

    int updateByPrimaryKey(PRole record);
}