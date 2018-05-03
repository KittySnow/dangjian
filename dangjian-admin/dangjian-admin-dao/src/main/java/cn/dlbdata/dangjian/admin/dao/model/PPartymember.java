package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;




public class PPartymember implements Serializable {
    /**
     * 党员表id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Integer userid;

    /**
     * 姓名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 年龄
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * 转出支部
     *
     * @mbg.generated
     */
    private Integer fromdepartmentid;


    private Double totalScore;

    /**
     * 身份证号
     *
     * @mbg.generated
     */
    private String idcard;



    /**
     * 积分分值表id
     *
     * @mbg.generated
     */
    private Integer bid;

    private Integer departmentid;

    private String departmentname;

    private String fromdepartmentname;

    /**
     * 电话
     *
     * @mbg.generated
     */
    private String phone;


    private Integer tempint;


    private static final long serialVersionUID = 1L;
    private String avatar;
    /**
     * 登录名
     * 
     * 
     */
    private String userName;
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public Double getTotalscore() {
        return totalScore;
    }

    public void setTotalscore(Double totalScore) {
        this.totalScore = totalScore;
    }


    public Integer getTempint() {
        return tempint;
    }

    public void setTempint(Integer tempint) {
        this.tempint = tempint;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }


    public String getFromdepartmentname() {
        return fromdepartmentname;
    }

    public void setFromdepartmentname(String fromdepartmentname) {
        this.fromdepartmentname = fromdepartmentname;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFromdepartmentid() {
        return fromdepartmentid;
    }

    public void setFromdepartmentid(Integer fromdepartmentid) {
        this.fromdepartmentid = fromdepartmentid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", userName=").append(userName);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", fromdepartmentid=").append(fromdepartmentid);
        sb.append(", bid=").append(bid);
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
        PPartymember other = (PPartymember) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getFromdepartmentid() == null ? other.getFromdepartmentid() == null : this.getFromdepartmentid().equals(other.getFromdepartmentid()))
            && (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getFromdepartmentid() == null) ? 0 : getFromdepartmentid().hashCode());
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        return result;
    }
}