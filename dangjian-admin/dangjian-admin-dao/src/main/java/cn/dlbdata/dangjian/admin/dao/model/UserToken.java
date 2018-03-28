package cn.dlbdata.dangjian.admin.dao.model;

/**
 * Created by Administrator on 2018/3/28.
 */
public class UserToken {

    private String name;
    private String password;
    private Integer roleid;
    private String rolename;

    public UserToken(String name, String password, Integer roleid) {
        this.name = name;
        this.password = password;
        this.roleid = roleid;
    }

    public UserToken(String name) {
        this.name = name;
    }

    public UserToken() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
