package cn.dlbdata.dangjian.admin.dao.mapper;


import cn.dlbdata.dangjian.admin.dao.model.PRoleFeature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PRoleFeatureDao {

    int deleteByRoleId(Integer roleid);

    int insert(List<PRoleFeature> record);

    List<PRoleFeature> selectByRoid(Integer roleid);

}