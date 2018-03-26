package cn.dlbdata.dangjian.admin.service;


import cn.dlbdata.dangjian.admin.dao.model.PRoleFeature;

import java.util.List;

public interface PRoleFeatureService {

    public int deleteByRoleId(Integer roleid);

    public int insert(List<PRoleFeature> record);

    public List<PRoleFeature> selectByRoid(Integer roleid);
    
}