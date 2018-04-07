package cn.dlbdata.dangjian.admin.dao.mapper;

import cn.dlbdata.dangjian.admin.dao.model.PWxUser;
import cn.dlbdata.dangjian.admin.dao.model.PWxUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PWxUserDao {
    long countByExample(PWxUserExample example);

    int deleteByExample(PWxUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PWxUser record);

    int insertSelective(PWxUser record);

    List<PWxUser> selectByExample(PWxUserExample example);

    PWxUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PWxUser record, @Param("example") PWxUserExample example);

    int updateByExample(@Param("record") PWxUser record, @Param("example") PWxUserExample example);

    int updateByPrimaryKeySelective(PWxUser record);

    int updateByPrimaryKey(PWxUser record);
}