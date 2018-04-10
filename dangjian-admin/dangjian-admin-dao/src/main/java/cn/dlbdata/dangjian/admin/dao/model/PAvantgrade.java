package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PAvantgrade implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 项目id
     *
     * @mbg.generated
     */
    private Integer projectId;

    /**
     * 模块id
     *
     * @mbg.generated
     */
    private Integer moduleId;

    /**
     * 评审人id
     *
     * @mbg.generated
     */
    private Integer approveId;

    private Date createtime;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 评语
     *
     * @mbg.generated
     */
    private String message;

    /**
     * 部门ID
     *
     * @mbg.generated
     */
    private Integer departmentid;

    /**
     * 党员ID
     *
     * @mbg.generated
     */
    private Integer partmentid;

    /**
     * 1已提交、2拒绝
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 拒绝理由
     *
     * @mbg.generated
     */
    private String rejectReson;

    /**
     * 得分
     *
     * @mbg.generated
     */
    private Double itemscore;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String memo;

    private Date approvetime;

    /**
     * 年份
     *
     * @mbg.generated
     */
    private Integer year;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getApproveId() {
        return approveId;
    }

    public void setApproveId(Integer approveId) {
        this.approveId = approveId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getPartmentid() {
        return partmentid;
    }

    public void setPartmentid(Integer partmentid) {
        this.partmentid = partmentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRejectReson() {
        return rejectReson;
    }

    public void setRejectReson(String rejectReson) {
        this.rejectReson = rejectReson;
    }

    public Double getItemscore() {
        return itemscore;
    }

    public void setItemscore(Double itemscore) {
        this.itemscore = itemscore;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getApprovetime() {
        return approvetime;
    }

    public void setApprovetime(Date approvetime) {
        this.approvetime = approvetime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", projectId=").append(projectId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", approveId=").append(approveId);
        sb.append(", createtime=").append(createtime);
        sb.append(", title=").append(title);
        sb.append(", message=").append(message);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", partmentid=").append(partmentid);
        sb.append(", status=").append(status);
        sb.append(", rejectReson=").append(rejectReson);
        sb.append(", itemscore=").append(itemscore);
        sb.append(", memo=").append(memo);
        sb.append(", approvetime=").append(approvetime);
        sb.append(", year=").append(year);
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
        PAvantgrade other = (PAvantgrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getApproveId() == null ? other.getApproveId() == null : this.getApproveId().equals(other.getApproveId()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
            && (this.getPartmentid() == null ? other.getPartmentid() == null : this.getPartmentid().equals(other.getPartmentid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRejectReson() == null ? other.getRejectReson() == null : this.getRejectReson().equals(other.getRejectReson()))
            && (this.getItemscore() == null ? other.getItemscore() == null : this.getItemscore().equals(other.getItemscore()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getApprovetime() == null ? other.getApprovetime() == null : this.getApprovetime().equals(other.getApprovetime()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getApproveId() == null) ? 0 : getApproveId().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getPartmentid() == null) ? 0 : getPartmentid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRejectReson() == null) ? 0 : getRejectReson().hashCode());
        result = prime * result + ((getItemscore() == null) ? 0 : getItemscore().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getApprovetime() == null) ? 0 : getApprovetime().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        return result;
    }
}