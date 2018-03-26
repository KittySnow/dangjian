package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PSpace implements Serializable {
    private Integer spaceid;

    /**
     * 空间名字
     *
     * @mbg.generated
     */
    private String spacename;

    /**
     * 空间基础成本
     *
     * @mbg.generated
     */
    private Double spacecost;

    /**
     * 空间面积
     *
     * @mbg.generated
     */
    private Double spacesquare;

    private Integer rid;

    private Long toid;

    /**
     * 隶属部门
     *
     * @mbg.generated
     */
    private Integer departmentid;

    private static final long serialVersionUID = 1L;

    public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

    public String getSpacename() {
        return spacename;
    }

    public void setSpacename(String spacename) {
        this.spacename = spacename;
    }

    public Double getSpacecost() {
        return spacecost;
    }

    public void setSpacecost(Double spacecost) {
        this.spacecost = spacecost;
    }

    public Double getSpacesquare() {
        return spacesquare;
    }

    public void setSpacesquare(Double spacesquare) {
        this.spacesquare = spacesquare;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Long getToid() {
        return toid;
    }

    public void setToid(Long toid) {
        this.toid = toid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spaceid=").append(spaceid);
        sb.append(", spacename=").append(spacename);
        sb.append(", spacecost=").append(spacecost);
        sb.append(", spacesquare=").append(spacesquare);
        sb.append(", rid=").append(rid);
        sb.append(", toid=").append(toid);
        sb.append(", departmentid=").append(departmentid);
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
        PSpace other = (PSpace) that;
        return (this.getSpaceid() == null ? other.getSpaceid() == null : this.getSpaceid().equals(other.getSpaceid()))
            && (this.getSpacename() == null ? other.getSpacename() == null : this.getSpacename().equals(other.getSpacename()))
            && (this.getSpacecost() == null ? other.getSpacecost() == null : this.getSpacecost().equals(other.getSpacecost()))
            && (this.getSpacesquare() == null ? other.getSpacesquare() == null : this.getSpacesquare().equals(other.getSpacesquare()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getToid() == null ? other.getToid() == null : this.getToid().equals(other.getToid()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpaceid() == null) ? 0 : getSpaceid().hashCode());
        result = prime * result + ((getSpacename() == null) ? 0 : getSpacename().hashCode());
        result = prime * result + ((getSpacecost() == null) ? 0 : getSpacecost().hashCode());
        result = prime * result + ((getSpacesquare() == null) ? 0 : getSpacesquare().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getToid() == null) ? 0 : getToid().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        return result;
    }
}