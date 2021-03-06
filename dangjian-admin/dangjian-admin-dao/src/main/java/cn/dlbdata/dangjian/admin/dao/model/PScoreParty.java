package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PScoreParty implements Serializable {
    /**
     * 党员积分ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 项目ID
     *
     * @mbg.generated
     */
    private Integer projectId;
    private String projectName;
    /**
     * 项目明细ID
     *
     * @mbg.generated
     */
    private Integer detailId;

    /**
     * 分值
     *
     * @mbg.generated
     */
    private Double score;
    private  Double typetotalscore;

    public Double getTypetotalscore() {
        return typetotalscore;
    }

    public void setTypetotalscore(Double typetotalscore) {
        this.typetotalscore = typetotalscore;
    }

    /**
     * 加分者ID
     *
     * @mbg.generated
     */
    private Integer adderId;

    /**
     * 评审人ID
     *
     * @mbg.generated
     */
    private Integer approvedId;



    private String approvedName;

    /**
     * 积分年度
     *
     * @mbg.generated
     */
    private Integer year;

    /**
     * 积分时间(yyyy-MM-dd HH:mm:ss)
     *
     * @mbg.generated
     */
    private Date scoreTime;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date addTime;

    /**
     * 创建人ID
     *
     * @mbg.generated
     */
    private Integer addId;

    /**
     * 是否有效
     *
     * @mbg.generated
     */
    private String validYn;
    /** 状态 */
    private String statusCd;

    /**
     * 党员ID
     *
     * @author July july_sky@foxmail.com
     * @date 2018-04-01 09:12:01
     * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
     * @version 1.0
     * @param null
     * @return
     */
    private Integer userId;
    /** 总分 */
    private Double totalScore;
    /** 已获得积分 */
    private Double obtainScore;

    private String detailTitle;

    private String imgs;
    private String remark;

    private String adderName;

    /**
     * 积分明细内容
     */
    private String content;
    /**
     * 开始日期(yyyy-MM-dd HH:mm:ss)
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date beginDate;
    /**
     * 结束日期(yyyy-MM-dd HH:mm:ss)
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endDate;
    
    private String partyMemberName;
    private Integer recordId;
    private Integer recordType;
    private String recordDesc;
    
    
    public String getPartyMemberName() {
		return partyMemberName;
	}

	public void setPartyMemberName(String partyMemberName) {
		this.partyMemberName = partyMemberName;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    private static final long serialVersionUID = 1L;

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdderName() {
        return adderName;
    }

    public void setAdderName(String adderName) {
        this.adderName = adderName;
    }

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

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getAdderId() {
        return adderId;
    }

    public void setAdderId(Integer adderId) {
        this.adderId = adderId;
    }

    public Integer getApprovedId() {
        return approvedId;
    }

    public void setApprovedId(Integer approvedId) {
        this.approvedId = approvedId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getValidYn() {
        return validYn;
    }

    public void setValidYn(String validYn) {
        this.validYn = validYn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApprovedName() {
        return approvedName;
    }

    public void setApprovedName(String approvedName) {
        this.approvedName = approvedName;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getObtainScore() {
        return obtainScore;
    }

    public void setObtainScore(Double obtainScore) {
        this.obtainScore = obtainScore;
    }

    public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public String getRecordDesc() {
		return recordDesc;
	}

	public void setRecordDesc(String recordDesc) {
		this.recordDesc = recordDesc;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", detailId=").append(detailId);
        sb.append(", score=").append(score);
        sb.append(", adderId=").append(adderId);
        sb.append(", approvedId=").append(approvedId);
        sb.append(", year=").append(year);
        sb.append(", scoreTime=").append(scoreTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", addId=").append(addId);
        sb.append(", validYn=").append(validYn);
        sb.append(", content=").append(content);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", partyMemberName=").append(partyMemberName);
        sb.append(", recordId=").append(recordId);
        sb.append(", recordType=").append(recordType);
        sb.append(", recordDesc=").append(recordDesc);
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
        PScoreParty other = (PScoreParty) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getDetailId() == null ? other.getDetailId() == null : this.getDetailId().equals(other.getDetailId()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getAdderId() == null ? other.getAdderId() == null : this.getAdderId().equals(other.getAdderId()))
            && (this.getApprovedId() == null ? other.getApprovedId() == null : this.getApprovedId().equals(other.getApprovedId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getScoreTime() == null ? other.getScoreTime() == null : this.getScoreTime().equals(other.getScoreTime()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getAddId() == null ? other.getAddId() == null : this.getAddId().equals(other.getAddId()))
            && (this.getValidYn() == null ? other.getValidYn() == null : this.getValidYn().equals(other.getValidYn()))
        	&& (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
	        && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
	        && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
	        && (this.getPartyMemberName() == null ? other.getPartyMemberName() == null : this.getPartyMemberName().equals(other.getPartyMemberName()))
        	&& (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
        	&& (this.getRecordType() == null ? other.getRecordType() == null : this.getRecordType().equals(other.getRecordType()))
        	&& (this.getRecordDesc() == null ? other.getRecordDesc() == null : this.getRecordDesc().equals(other.getRecordDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getDetailId() == null) ? 0 : getDetailId().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getAdderId() == null) ? 0 : getAdderId().hashCode());
        result = prime * result + ((getApprovedId() == null) ? 0 : getApprovedId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getScoreTime() == null) ? 0 : getScoreTime().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getAddId() == null) ? 0 : getAddId().hashCode());
        result = prime * result + ((getValidYn() == null) ? 0 : getValidYn().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getPartyMemberName() == null) ? 0 : getPartyMemberName().hashCode());
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getRecordType() == null) ? 0 : getRecordType().hashCode());
        result = prime * result + ((getRecordDesc() == null) ? 0 : getRecordDesc().hashCode());
        return result;
    }
}