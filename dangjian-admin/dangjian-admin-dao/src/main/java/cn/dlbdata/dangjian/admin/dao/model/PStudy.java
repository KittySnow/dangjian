package cn.dlbdata.dangjian.admin.dao.model;

import cn.dlbdata.dangjian.common.util.DateJsonDeserializer;
import cn.dlbdata.dangjian.common.util.DateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PStudy implements Serializable {
    private Integer studyid;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @JsonDeserialize(using = DateJsonDeserializer.class)
    @JsonSerialize(using = DateJsonSerializer.class)
    private Date starttime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @JsonDeserialize(using = DateJsonDeserializer.class)
    @JsonSerialize(using = DateJsonSerializer.class)
    private Date endtime;

    /**
     * 学习主要内容
     *
     * @mbg.generated
     */
    private String content=null;

    /**
     * 支部ID
     *
     * @mbg.generated
     */
    private Integer departmentid;

    /**
     * 项目ID
     *
     * @mbg.generated
     */
    private Integer projectid;

    /**
     * 模块ID
     *
     * @mbg.generated
     */
    private Integer moduleid;

    /**
     * 审批人ID
     *
     * @mbg.generated
     */
    private Integer approvalid;

    /**
     * 上级是否审批
     *
     * @mbg.generated 0是等待审核 1是审核通过 2是拒绝
     */
    private Integer status;

    /**
     * 创建者
     *
     * @mbg.generated
     */
    private Integer createUserid;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createtime;

    private String rejectreason;

    private List<Integer> picIds=null;

    private Integer roleid;

    private String picids;

    private static final long serialVersionUID = 1L;

    public Integer getStudyid() {
        return studyid;
    }

    public void setStudyid(Integer studyid) {
        this.studyid = studyid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public Integer getApprovalid() {
        return approvalid;
    }

    public void setApprovalid(Integer approvalid) {
        this.approvalid = approvalid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studyid=").append(studyid);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", content=").append(content);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", projectid=").append(projectid);
        sb.append(", moduleid=").append(moduleid);
        sb.append(", approvalid=").append(approvalid);
        sb.append(", status=").append(status);
        sb.append(", createUserid=").append(createUserid);
        sb.append(", createtime=").append(createtime);
        sb.append(", rejectreason=").append(rejectreason);
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
        PStudy other = (PStudy) that;
        return (this.getStudyid() == null ? other.getStudyid() == null : this.getStudyid().equals(other.getStudyid()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getModuleid() == null ? other.getModuleid() == null : this.getModuleid().equals(other.getModuleid()))
            && (this.getApprovalid() == null ? other.getApprovalid() == null : this.getApprovalid().equals(other.getApprovalid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateUserid() == null ? other.getCreateUserid() == null : this.getCreateUserid().equals(other.getCreateUserid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudyid() == null) ? 0 : getStudyid().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getModuleid() == null) ? 0 : getModuleid().hashCode());
        result = prime * result + ((getApprovalid() == null) ? 0 : getApprovalid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateUserid() == null) ? 0 : getCreateUserid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    public List<Integer> getPicIds() {
        return picIds;
    }

    public void setPicIds(List<Integer> picIds) {
        this.picIds = picIds;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPicids() {
        return picids;
    }

    public void setPicids(String picids) {
        this.picids = picids;
    }
}