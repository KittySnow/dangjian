package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

public class PPartymemberScoreItem implements Serializable {
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
    private Integer scorepartyid;

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
     * 提交图片
     *
     * @mbg.generated
     */
    private Integer pictureid;

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

    public Integer getScorepartyid() {
        return scorepartyid;
    }

    public void setScorepartyid(Integer scorepartyid) {
        this.scorepartyid = scorepartyid;
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

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
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
        sb.append(", scorepartyid=").append(scorepartyid);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", pictureid=").append(pictureid);
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
        PPartymemberScoreItem other = (PPartymemberScoreItem) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getPartymemberid() == null ? other.getPartymemberid() == null : this.getPartymemberid().equals(other.getPartymemberid()))
            && (this.getScorepartyid() == null ? other.getScorepartyid() == null : this.getScorepartyid().equals(other.getScorepartyid()))
            && (this.getStarttime() == null ? other.getStarttime() == null : this.getStarttime().equals(other.getStarttime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getPictureid() == null ? other.getPictureid() == null : this.getPictureid().equals(other.getPictureid()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getPartymemberid() == null) ? 0 : getPartymemberid().hashCode());
        result = prime * result + ((getScorepartyid() == null) ? 0 : getScorepartyid().hashCode());
        result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getPictureid() == null) ? 0 : getPictureid().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}