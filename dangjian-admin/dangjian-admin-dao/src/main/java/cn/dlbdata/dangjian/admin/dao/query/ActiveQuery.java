package cn.dlbdata.dangjian.admin.dao.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author July july_sky@foxmail.com
 * @version 1.0
 * @date 2018/4/21 下午9:11
 * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
 */
public class ActiveQuery extends PageQuery {

    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 是否确定开始日期
     */
    private String startTimeYn;
    /**
     * 活动状态
     */
    private Integer activeStatus;
    /**
     * 项目ID
     */
    private Integer activeProjectId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getStartTimeYn() {
        return startTimeYn;
    }

    public void setStartTimeYn(String startTimeYn) {
        this.startTimeYn = startTimeYn;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Integer getActiveProjectId() {
        return activeProjectId;
    }

    public void setActiveProjectId(Integer activeProjectId) {
        this.activeProjectId = activeProjectId;
    }

    public Integer getStart() {
        return !this.getPageYn() || this.getPageNum() == null || this.getPageNum() <= 0 || this.getPageSize() == null || this.getPageSize() <= 0 ? null : ((this.getPageNum() - 1) * this.getPageSize());
    }
}

