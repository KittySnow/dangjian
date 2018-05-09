package cn.dlbdata.dangjian.admin.dao.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PScoreDetail implements Serializable {
    private Integer id;

    /**
     * 项目ID
     *
     * @mbg.generated
     */
    private Integer projectId;

    /**
     * 明细标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 明细内容
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 分值
     *
     * @mbg.generated
     */
    private double score;

    /**
     * 是否仅加分一次
     *
     * @mbg.generated
     */
    private String onlyYn;

    /**
     * 参与者角色ID
     *
     * @mbg.generated
     */
    private Integer actorRoleId;

    /**
     * 加分者角色ID
     *
     * @mbg.generated
     */
    private Integer adderRoleId;

    /**
     * 审评人角色ID
     *
     * @mbg.generated
     */
    private Integer approvedRoleId;

    /**
     * 创建人ID
     *
     * @mbg.generated
     */
    private Integer addId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date addTime;

    /**
     * 开始日期(yyyy-MM-dd HH:mm:ss)
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date beginDate;

    /**
     * 结束日期(yyyy-MM-dd HH:mm:ss)
     *
     * @mbg.generated
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date endDate;

    /**
     * 是否有效
     *
     * @mbg.generated
     */
    private String validYn;

    /**
     * 积分获取方式:10_扫码获取,20_评定获取
     *
     * @mbg.generated
     */
    private String scoreGetMethodCd;

    private String scoreGetMethod;
    private String projectName;
    private Double maxScore;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getOnlyYn() {
        return onlyYn;
    }

    public void setOnlyYn(String onlyYn) {
        this.onlyYn = onlyYn;
    }

    public Integer getActorRoleId() {
        return actorRoleId;
    }

    public void setActorRoleId(Integer actorRoleId) {
        this.actorRoleId = actorRoleId;
    }

    public Integer getAdderRoleId() {
        return adderRoleId;
    }

    public void setAdderRoleId(Integer adderRoleId) {
        this.adderRoleId = adderRoleId;
    }

    public Integer getApprovedRoleId() {
        return approvedRoleId;
    }

    public void setApprovedRoleId(Integer approvedRoleId) {
        this.approvedRoleId = approvedRoleId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getValidYn() {
        return validYn;
    }

    public void setValidYn(String validYn) {
        this.validYn = validYn;
    }

    public String getScoreGetMethodCd() {
        return scoreGetMethodCd;
    }

    public void setScoreGetMethodCd(String scoreGetMethodCd) {
        this.scoreGetMethodCd = scoreGetMethodCd;
    }

    public String getScoreGetMethod() {
        return scoreGetMethod;
    }

    public void setScoreGetMethod(String scoreGetMethod) {
        this.scoreGetMethod = scoreGetMethod;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Double maxScore) {
		this.maxScore = maxScore;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", score=").append(score);
        sb.append(", onlyYn=").append(onlyYn);
        sb.append(", actorRoleId=").append(actorRoleId);
        sb.append(", adderRoleId=").append(adderRoleId);
        sb.append(", approvedRoleId=").append(approvedRoleId);
        sb.append(", addId=").append(addId);
        sb.append(", addTime=").append(addTime);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", validYn=").append(validYn);
        sb.append(", scoreGetMethodCd=").append(scoreGetMethodCd);
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
        PScoreDetail other = (PScoreDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOnlyYn() == null ? other.getOnlyYn() == null : this.getOnlyYn().equals(other.getOnlyYn()))
            && (this.getActorRoleId() == null ? other.getActorRoleId() == null : this.getActorRoleId().equals(other.getActorRoleId()))
            && (this.getAdderRoleId() == null ? other.getAdderRoleId() == null : this.getAdderRoleId().equals(other.getAdderRoleId()))
            && (this.getApprovedRoleId() == null ? other.getApprovedRoleId() == null : this.getApprovedRoleId().equals(other.getApprovedRoleId()))
            && (this.getAddId() == null ? other.getAddId() == null : this.getAddId().equals(other.getAddId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getValidYn() == null ? other.getValidYn() == null : this.getValidYn().equals(other.getValidYn()))
            && (this.getScoreGetMethodCd() == null ? other.getScoreGetMethodCd() == null : this.getScoreGetMethodCd().equals(other.getScoreGetMethodCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOnlyYn() == null) ? 0 : getOnlyYn().hashCode());
        result = prime * result + ((getActorRoleId() == null) ? 0 : getActorRoleId().hashCode());
        result = prime * result + ((getAdderRoleId() == null) ? 0 : getAdderRoleId().hashCode());
        result = prime * result + ((getApprovedRoleId() == null) ? 0 : getApprovedRoleId().hashCode());
        result = prime * result + ((getAddId() == null) ? 0 : getAddId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getValidYn() == null) ? 0 : getValidYn().hashCode());
        result = prime * result + ((getScoreGetMethodCd() == null) ? 0 : getScoreGetMethodCd().hashCode());
        return result;
    }
}