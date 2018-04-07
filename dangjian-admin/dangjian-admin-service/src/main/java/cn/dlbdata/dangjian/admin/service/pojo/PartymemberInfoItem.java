package cn.dlbdata.dangjian.admin.service.pojo;

/**
 * @Author: linfujun
 * @Description: 党员信息列表中的item
 * @Date: Created on 12:45 2018/4/7
 */
public class PartymemberInfoItem {

    private String name;
    private String sex;
    private Integer age;
    private String fromDepartmentname;
    private Integer score;

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

    public String getFromDepartmentname() {
        return fromDepartmentname;
    }

    public void setFromDepartmentname(String fromDepartmentname) {
        this.fromDepartmentname = fromDepartmentname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
