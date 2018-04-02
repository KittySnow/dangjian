package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PScoreProject implements Serializable {
    /**
     * 项目ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 项目名称
     *
     * @mbg.generated
     */
    private String projectName;

    /**
     * 分值
     *
     * @mbg.generated
     */
    private BigDecimal score;

    /**
     * 是否有效
     *
     * @mbg.generated
     */
    private String validYn;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getValidYn() {
        return validYn;
    }

    public void setValidYn(String validYn) {
        this.validYn = validYn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectName=").append(projectName);
        sb.append(", score=").append(score);
        sb.append(", validYn=").append(validYn);
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
        PScoreProject other = (PScoreProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getValidYn() == null ? other.getValidYn() == null : this.getValidYn().equals(other.getValidYn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getValidYn() == null) ? 0 : getValidYn().hashCode());
        return result;
    }
}