package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PPartymamberScoreItem implements Serializable {
    private Integer itemId;

    /**
     * 党员ID
     *
     * @mbg.generated
     */
    private Integer partyMemberId;

    /**
     * 党员积分项ID
     *
     * @mbg.generated
     */
    private Integer scorePartyId;

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
     * 提交图片
     *
     * @mbg.generated
     */
    private Integer pictureId;

    /**
     * 主要内容
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPartyMemberId() {
        return partyMemberId;
    }

    public void setPartyMemberId(Integer partyMemberId) {
        this.partyMemberId = partyMemberId;
    }

    public Integer getScorePartyId() {
        return scorePartyId;
    }

    public void setScorePartyId(Integer scorePartyId) {
        this.scorePartyId = scorePartyId;
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

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
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
        sb.append(", itemId=").append(itemId);
        sb.append(", partyMemberId=").append(partyMemberId);
        sb.append(", scorePartyId=").append(scorePartyId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", pictureId=").append(pictureId);
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
        PPartymamberScoreItem other = (PPartymamberScoreItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getPartyMemberId() == null ? other.getPartyMemberId() == null : this.getPartyMemberId().equals(other.getPartyMemberId()))
            && (this.getScorePartyId() == null ? other.getScorePartyId() == null : this.getScorePartyId().equals(other.getScorePartyId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getPictureId() == null ? other.getPictureId() == null : this.getPictureId().equals(other.getPictureId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getPartyMemberId() == null) ? 0 : getPartyMemberId().hashCode());
        result = prime * result + ((getScorePartyId() == null) ? 0 : getScorePartyId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getPictureId() == null) ? 0 : getPictureId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}