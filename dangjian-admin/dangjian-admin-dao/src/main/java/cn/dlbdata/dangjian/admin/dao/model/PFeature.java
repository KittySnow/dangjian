package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PFeature implements Serializable {
    private Integer featureid;

    /**
     * 英文标识
     *
     * @mbg.generated
     */
    private String engname;

    /**
     * 中文名称
     *
     * @mbg.generated
     */
    private String chnname;

    private static final long serialVersionUID = 1L;

    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getChnname() {
        return chnname;
    }

    public void setChnname(String chnname) {
        this.chnname = chnname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", featureid=").append(featureid);
        sb.append(", engname=").append(engname);
        sb.append(", chnname=").append(chnname);
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
        PFeature other = (PFeature) that;
        return (this.getFeatureid() == null ? other.getFeatureid() == null : this.getFeatureid().equals(other.getFeatureid()))
            && (this.getEngname() == null ? other.getEngname() == null : this.getEngname().equals(other.getEngname()))
            && (this.getChnname() == null ? other.getChnname() == null : this.getChnname().equals(other.getChnname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFeatureid() == null) ? 0 : getFeatureid().hashCode());
        result = prime * result + ((getEngname() == null) ? 0 : getEngname().hashCode());
        result = prime * result + ((getChnname() == null) ? 0 : getChnname().hashCode());
        return result;
    }
}