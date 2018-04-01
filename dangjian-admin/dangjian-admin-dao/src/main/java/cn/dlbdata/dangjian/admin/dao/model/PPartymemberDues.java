package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PPartymemberDues implements Serializable {
    /**
     * 党费ID
     *
     * @mbg.generated
     */
    private Integer duesId;

    /**
     * 对应的党员ID
     *
     * @mbg.generated
     */
    private Integer partyMemberId;

    /**
     * 党费额度
     *
     * @mbg.generated
     */
    private String dues;

    /**
     * 党费月份
     *
     * @mbg.generated
     */
    private Integer month;

    /**
     * 党费年份
     *
     * @mbg.generated
     */
    private Integer year;

    /**
     * 缴费状态，1-已缴，2-未缴
     *
     * @mbg.generated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getDuesId() {
        return duesId;
    }

    public void setDuesId(Integer duesId) {
        this.duesId = duesId;
    }

    public Integer getPartyMemberId() {
        return partyMemberId;
    }

    public void setPartyMemberId(Integer partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public String getDues() {
        return dues;
    }

    public void setDues(String dues) {
        this.dues = dues;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", duesId=").append(duesId);
        sb.append(", partyMemberId=").append(partyMemberId);
        sb.append(", dues=").append(dues);
        sb.append(", month=").append(month);
        sb.append(", year=").append(year);
        sb.append(", status=").append(status);
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
        PPartymemberDues other = (PPartymemberDues) that;
        return (this.getDuesId() == null ? other.getDuesId() == null : this.getDuesId().equals(other.getDuesId()))
            && (this.getPartyMemberId() == null ? other.getPartyMemberId() == null : this.getPartyMemberId().equals(other.getPartyMemberId()))
            && (this.getDues() == null ? other.getDues() == null : this.getDues().equals(other.getDues()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDuesId() == null) ? 0 : getDuesId().hashCode());
        result = prime * result + ((getPartyMemberId() == null) ? 0 : getPartyMemberId().hashCode());
        result = prime * result + ((getDues() == null) ? 0 : getDues().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}