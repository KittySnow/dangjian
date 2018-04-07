package cn.dlbdata.dangjian.admin.service;

import cn.dlbdata.dangjian.admin.service.pojo.PartymemberInfoItem;

import java.util.List;

/**
 * @Author: linfujun
 * @Description: 获取党员信息列表详情
 * @Date: Created on 13:48 2018/4/7
 */
public interface DangjianPartymemberService {

    /**
     * 获取党员信息列表详情
     * @param departmentId
     * @return
     */
    public List<PartymemberInfoItem> getPartymemberInfoItemListByDepartmentId(Integer departmentId);
}
