package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PScorelevel implements Serializable {
    /**
     * 积分评定表id
     *
     * @mbg.generated
     */
    private Integer scoreid;

    /**
     * 最小值
     *
     * @mbg.generated
     */
    private Integer min;

    /**
     * 最大值
     *
     * @mbg.generated
     */
    private Integer max;

    /**
     * 级别
     *
     * @mbg.generated
     */
    private String level;

    private static final long serialVersionUID = 1L;

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scoreid=").append(scoreid);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", level=").append(level);
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
        PScorelevel other = (PScorelevel) that;
        return (this.getScoreid() == null ? other.getScoreid() == null : this.getScoreid().equals(other.getScoreid()))
            && (this.getMin() == null ? other.getMin() == null : this.getMin().equals(other.getMin()))
            && (this.getMax() == null ? other.getMax() == null : this.getMax().equals(other.getMax()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScoreid() == null) ? 0 : getScoreid().hashCode());
        result = prime * result + ((getMin() == null) ? 0 : getMin().hashCode());
        result = prime * result + ((getMax() == null) ? 0 : getMax().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }
}