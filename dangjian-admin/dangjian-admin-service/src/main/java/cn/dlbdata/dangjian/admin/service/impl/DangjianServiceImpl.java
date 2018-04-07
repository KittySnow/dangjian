package cn.dlbdata.dangjian.admin.service.impl;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.DangjianService;
import cn.dlbdata.dangjian.admin.service.PDepartmentService;
import cn.dlbdata.dangjian.admin.service.PPartymemberGetScoreItemService;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.admin.service.pojo.PartymemberInfoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 12:27 2018/4/7
 */
@Service
public class DangjianServiceImpl implements DangjianService {

    @Autowired
    private PDepartmentService pDepartmentService;

    @Autowired
    private PPartymemberService pPartymemberService;

    @Autowired
    private PPartymemberGetScoreItemService pPartymemberGetScoreItemService;

    public List<PartymemberInfoItem> getPartymemberInfoItemListByDepartmentId(Integer departmentId) {
        List<PartymemberInfoItem> partymemberInfoItems = new ArrayList<>();
        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        pPartymemberExample.createCriteria().andDepartmentidEqualTo(departmentId);
        List<PPartymember> partymemberList = pPartymemberService.selectByExample(pPartymemberExample);
        for (PPartymember pPartymember : partymemberList) {
            PartymemberInfoItem partymemberInfoItem = new PartymemberInfoItem();
            partymemberInfoItem.setName(partymemberInfoItem.getName());
            partymemberInfoItem.setAge(partymemberInfoItem.getAge());
            Integer fromDepartmentId = pPartymember.getFromdepartmentid();
            PDepartment pDepartment = pDepartmentService.selectByPrimaryKey(fromDepartmentId);
            partymemberInfoItem.setFromDepartmentname(pDepartment.getDepartmentname());
            PPartymemberGetScoreItemExample pPartymemberGetScoreItemExample = new PPartymemberGetScoreItemExample();
            pPartymemberGetScoreItemExample.createCriteria().andPartymemberidEqualTo(pPartymember.getId());
            List<PPartymemberGetScoreItem> pPartymemberGetScoreItemList = pPartymemberGetScoreItemService.selectByExample(pPartymemberGetScoreItemExample);
            Integer totalScore = 0;
            for (PPartymemberGetScoreItem pPartymemberGetScoreItem : pPartymemberGetScoreItemList) {
                totalScore += pPartymemberGetScoreItem.getGetscore();
            }
            partymemberInfoItem.setScore(totalScore);
            partymemberInfoItems.add(partymemberInfoItem);
        }
        return partymemberInfoItems;
    }
}
