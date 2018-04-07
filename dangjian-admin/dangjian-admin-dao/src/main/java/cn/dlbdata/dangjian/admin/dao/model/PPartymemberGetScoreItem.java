package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PPartymemberGetScoreItem implements Serializable {
    private Integer itemid;

    /**
     * 党员ID
     *
     * @mbg.generated
     */
    private Integer partymemberid;

    /**
     * 党员积分项ID
     *
     * @mbg.generated
     */
    private Integer moduleid;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Date starttime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Date endtime;

    /**
     * 审批人
     *
     * @mbg.generated
     */
    private Integer approver;

    /**
     * 项目ID
     *
     * @mbg.generated
     */
    private Integer projectid;

    /**
     * 获得积分
     *
     * @mbg.generated
     */
    private Integer getscore;

    /**
     * 主要内容
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getPartymemberid() {
        return partymemberid;
    }

    public void setPartymemberid(Integer partymemberid) {
        this.partymemberid = partymemberid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
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

    public Integer getApprover() {
        return approver;
    }

    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getGetscore() {
        return getscore;
    }

    public void setGetscore(Integer getscore) {
        this.getscore = getscore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemid=").append(itemid);
        sb.append(", partymemberid=").append(partymemberid);
        sb.append(", moduleid=").append(moduleid);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", approver=").append(approver);
        sb.append(", projectid=").append(projectid);
        sb.append(", getscore=").append(getscore);
        sb.append(", content=").append(content);
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
        PPartymemberGetScoreItem other = (PPartymemberGetScoreItem) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getPartymemberid() == null ? other.getPartymemberid() == null : this.getPartymemberid().equals(other.getPartymemberid()))
            && (this.getModuleid() == null ? other.getModuleid() == null : this.getModuleid().equals(other.getModuleid()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getApprover() == null ? other.getApprover() == null : this.getApprover().equals(other.getApprover()))
            && (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
            && (this.getGetscore() == null ? other.getGetscore() == null : this.getGetscore().equals(other.getGetscore()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getPartymemberid() == null) ? 0 : getPartymemberid().hashCode());
        result = prime * result + ((getModuleid() == null) ? 0 : getModuleid().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getApprover() == null) ? 0 : getApprover().hashCode());
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getGetscore() == null) ? 0 : getGetscore().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}