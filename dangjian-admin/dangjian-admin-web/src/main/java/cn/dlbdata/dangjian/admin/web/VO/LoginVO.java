package cn.dlbdata.dangjian.admin.web.VO;

import lombok.Data;

@Data
public class LoginVO {
    private String ptoken;
    private Integer userId;
    private Integer roleId;

    public String getPtoken() {
        return ptoken;
    }

    public void setPtoken(String ptoken) {
        this.ptoken = ptoken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
