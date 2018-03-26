package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PDepartment implements Serializable {
    private Integer departmentid;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private String departmentname;

    /**
     * 基础成本
     *
     * @mbg.generated
     */
    private Double cost;

    private static final long serialVersionUID = 1L;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentid=").append(departmentid);
        sb.append(", departmentname=").append(departmentname);
        sb.append(", cost=").append(cost);
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
        PDepartment other = (PDepartment) that;
        return (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
            && (this.getDepartmentname() == null ? other.getDepartmentname() == null : this.getDepartmentname().equals(other.getDepartmentname()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getDepartmentname() == null) ? 0 : getDepartmentname().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        return result;
    }
}