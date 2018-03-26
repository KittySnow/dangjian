package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PUserDao {
    long countByExample(PUserExample example);

    int deleteByExample(PUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(PUser record);

    int insertSelective(PUser record);

    List<PUser> selectByExample(PUserExample example);

    List<PUser> selectAll(String searchText);

    PUser selectByPrimaryKey(Integer userid);
    PUser selectByEmail(final String email);

    int updateByExampleSelective(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByExample(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByPrimaryKeySelective(PUser record);

    int updateByPrimaryKey(PUser record);

    int updatePasswordByEmail(final PUser user);
}