package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PAvantgradePicture implements Serializable {
    private Integer id;

    private Integer avantgardeid;

    private Integer picid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvantgardeid() {
        return avantgardeid;
    }

    public void setAvantgardeid(Integer avantgardeid) {
        this.avantgardeid = avantgardeid;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", avantgardeid=").append(avantgardeid);
        sb.append(", picid=").append(picid);
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
        PAvantgradePicture other = (PAvantgradePicture) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAvantgardeid() == null ? other.getAvantgardeid() == null : this.getAvantgardeid().equals(other.getAvantgardeid()))
            && (this.getPicid() == null ? other.getPicid() == null : this.getPicid().equals(other.getPicid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAvantgardeid() == null) ? 0 : getAvantgardeid().hashCode());
        result = prime * result + ((getPicid() == null) ? 0 : getPicid().hashCode());
        return result;
    }
}