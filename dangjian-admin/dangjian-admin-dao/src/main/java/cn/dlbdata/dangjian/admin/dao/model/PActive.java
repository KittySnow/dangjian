package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PActive implements Serializable {
    /**
     * 活动表id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 活动名称
     *
     * @mbg.generated
     */
    private String activeName;

    /**
     * 活动所属项目（表）
     *
     * @mbg.generated
     */
    private Integer activeProjectId;

    /**
     * 活动类型(特殊表)
     *
     * @mbg.generated
     */
    private Integer activeType;

    /**
     * 活动地点
     *
     * @mbg.generated
     */
    private String activePace;

    /**
     * 活动发起人
     *
     * @mbg.generated
     */
    private Integer activeCreatePeople;

    private Integer departmentid;

    /**
     * 活动负责人
     *
     * @mbg.generated
     */
    private String activePrincipalPeople;

    /**
     * 活动是否审核：0：未审核；1：审核通过；2：审核失败
     *
     * @mbg.generated
     */
    private Integer activeStatus;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Date endTime;

    /**
     * 活动内容
     *
     * @mbg.generated
     */
    private String activeContext;

    /**
     * 支部信息
     *
     * @mbg.generated
     */
    private String zbMessage;

    private Date createTime;
    /**
     * 参与部门ID集合
     */
    private String departIds;
    /**
     * 活动所属项目
     */
    private String projectName;
    /**
     * 活动类型
     */
    private String title;
    
    /**
     * 活动发起人姓名
     */
    private String activeCreatePeopleName;
    /**
     * 参与部门ID集合
     */
    private String picIds;
    

    public String getActiveCreatePeopleName() {
		return activeCreatePeopleName;
	}

	public void setActiveCreatePeopleName(String activeCreatePeopleName) {
		this.activeCreatePeopleName = activeCreatePeopleName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActiveTypeName() {
        return activeTypeName;
    }

    public void setActiveTypeName(String activeTypeName) {
        this.activeTypeName = activeTypeName;
    }

    private String activeTypeName;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Integer getActiveProjectId() {
        return activeProjectId;
    }

    public void setActiveProjectId(Integer activeProjectId) {
        this.activeProjectId = activeProjectId;
    }

    public Integer getActiveType() {
        return activeType;
    }

    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    public String getActivePace() {
        return activePace;
    }

    public void setActivePace(String activePace) {
        this.activePace = activePace;
    }

    public Integer getActiveCreatePeople() {
        return activeCreatePeople;
    }

    public void setActiveCreatePeople(Integer activeCreatePeople) {
        this.activeCreatePeople = activeCreatePeople;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getActivePrincipalPeople() {
        return activePrincipalPeople;
    }

    public void setActivePrincipalPeople(String activePrincipalPeople) {
        this.activePrincipalPeople = activePrincipalPeople;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActiveContext() {
        return activeContext;
    }

    public void setActiveContext(String activeContext) {
        this.activeContext = activeContext;
    }

    public String getZbMessage() {
        return zbMessage;
    }

    public void setZbMessage(String zbMessage) {
        this.zbMessage = zbMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDepartIds() {
        return departIds;
    }

    public void setDepartIds(String departIds) {
        this.departIds = departIds;
    }

    public String getPicIds() {
		return picIds;
	}

	public void setPicIds(String picIds) {
		this.picIds = picIds;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activeName=").append(activeName);
        sb.append(", activeProjectId=").append(activeProjectId);
        sb.append(", activeType=").append(activeType);
        sb.append(", activePace=").append(activePace);
        sb.append(", activeCreatePeople=").append(activeCreatePeople);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", activePrincipalPeople=").append(activePrincipalPeople);
        sb.append(", activeStatus=").append(activeStatus);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", activeContext=").append(activeContext);
        sb.append(", zbMessage=").append(zbMessage);
        sb.append(", createTime=").append(createTime);
        sb.append(", projectName=").append(projectName);
        sb.append(", title=").append(title);
        sb.append(", activeCreatePeopleName=").append(activeCreatePeopleName);
        sb.append(", picIds=").append(picIds);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PActive other = (PActive) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getActiveName() == null ? other.getActiveName() == null : this.getActiveName().equals(other.getActiveName()))
                && (this.getActiveProjectId() == null ? other.getActiveProjectId() == null : this.getActiveProjectId().equals(other.getActiveProjectId()))
                && (this.getActiveType() == null ? other.getActiveType() == null : this.getActiveType().equals(other.getActiveType()))
                && (this.getActivePace() == null ? other.getActivePace() == null : this.getActivePace().equals(other.getActivePace()))
                && (this.getActiveCreatePeople() == null ? other.getActiveCreatePeople() == null : this.getActiveCreatePeople().equals(other.getActiveCreatePeople()))
                && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
                && (this.getActivePrincipalPeople() == null ? other.getActivePrincipalPeople() == null : this.getActivePrincipalPeople().equals(other.getActivePrincipalPeople()))
                && (this.getActiveStatus() == null ? other.getActiveStatus() == null : this.getActiveStatus().equals(other.getActiveStatus()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getActiveContext() == null ? other.getActiveContext() == null : this.getActiveContext().equals(other.getActiveContext()))
                && (this.getZbMessage() == null ? other.getZbMessage() == null : this.getZbMessage().equals(other.getZbMessage()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getActiveCreatePeopleName() == null ? other.getActiveCreatePeopleName() == null : this.getActiveCreatePeopleName().equals(other.getActiveCreatePeopleName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActiveName() == null) ? 0 : getActiveName().hashCode());
        result = prime * result + ((getActiveProjectId() == null) ? 0 : getActiveProjectId().hashCode());
        result = prime * result + ((getActiveType() == null) ? 0 : getActiveType().hashCode());
        result = prime * result + ((getActivePace() == null) ? 0 : getActivePace().hashCode());
        result = prime * result + ((getActiveCreatePeople() == null) ? 0 : getActiveCreatePeople().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getActivePrincipalPeople() == null) ? 0 : getActivePrincipalPeople().hashCode());
        result = prime * result + ((getActiveStatus() == null) ? 0 : getActiveStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getActiveContext() == null) ? 0 : getActiveContext().hashCode());
        result = prime * result + ((getZbMessage() == null) ? 0 : getZbMessage().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getActiveCreatePeopleName() == null) ? 0 : getActiveCreatePeopleName().hashCode());
        return result;
    }
}