package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PUserDao {
    long countByExample(PUserExample example);

    int deleteByExample(PUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(PUser record);

    int insertSelective(PUser record);

    List<PUser> selectByExample(PUserExample example);

    PUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByExample(@Param("record") PUser record, @Param("example") PUserExample example);

    int updateByPrimaryKeySelective(PUser record);

    int updateByPrimaryKey(PUser record);

    @Select("select * from p_user where name=#{name} and password=#{password}")
    PUser tologin(@Param("name")String name,@Param("password")String passowrd);

    @Select("select roleid from p_user where name=#{name}")
    public PUser findRoleid(@Param("name") String name);

    List<PUser> selectAll(String searchText);

    PUser selectByEmail(final String email);

    int updatePasswordByEmail(final PUser user);
}