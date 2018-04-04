package cn.dlbdata.dangjian.admin.dao.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class PPartymember implements Serializable {
    /**
     * 党员表id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 年龄
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * 转出支部
     *
     * @mbg.generated
     */
    private String outZb;

    /**
     * 现有积分
     *
     * @mbg.generated
     */
    private String momentScore;

    /**
     * 年度积分
     *
     * @mbg.generated
     */
    private String nearScore;

    /**
     * 活动次数
     *
     * @mbg.generated
     */
    private Integer activeTime;

    /**
     * 政治学习时间
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zzStudytime;

    /**
     * 积分分值表id
     *
     * @mbg.generated
     */
    private Integer bid;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOutZb() {
        return outZb;
    }

    public void setOutZb(String outZb) {
        this.outZb = outZb;
    }

    public String getMomentScore() {
        return momentScore;
    }

    public void setMomentScore(String momentScore) {
        this.momentScore = momentScore;
    }

    public String getNearScore() {
        return nearScore;
    }

    public void setNearScore(String nearScore) {
        this.nearScore = nearScore;
    }

    public Integer getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }

    public Date getZzStudytime() {
        return zzStudytime;
    }

    public void setZzStudytime(Date zzStudytime) {
        this.zzStudytime = zzStudytime;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", outZb=").append(outZb);
        sb.append(", momentScore=").append(momentScore);
        sb.append(", nearScore=").append(nearScore);
        sb.append(", activeTime=").append(activeTime);
        sb.append(", zzStudytime=").append(zzStudytime);
        sb.append(", bid=").append(bid);
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
        PPartymember other = (PPartymember) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getOutZb() == null ? other.getOutZb() == null : this.getOutZb().equals(other.getOutZb()))
            && (this.getMomentScore() == null ? other.getMomentScore() == null : this.getMomentScore().equals(other.getMomentScore()))
            && (this.getNearScore() == null ? other.getNearScore() == null : this.getNearScore().equals(other.getNearScore()))
            && (this.getActiveTime() == null ? other.getActiveTime() == null : this.getActiveTime().equals(other.getActiveTime()))
            && (this.getZzStudytime() == null ? other.getZzStudytime() == null : this.getZzStudytime().equals(other.getZzStudytime()))
            && (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getOutZb() == null) ? 0 : getOutZb().hashCode());
        result = prime * result + ((getMomentScore() == null) ? 0 : getMomentScore().hashCode());
        result = prime * result + ((getNearScore() == null) ? 0 : getNearScore().hashCode());
        result = prime * result + ((getActiveTime() == null) ? 0 : getActiveTime().hashCode());
        result = prime * result + ((getZzStudytime() == null) ? 0 : getZzStudytime().hashCode());
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        return result;
    }
}