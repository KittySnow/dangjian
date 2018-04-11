package cn.dlbdata.dangjian.admin.web.VO;

import lombok.Data;
import net.sf.json.JSONObject;

@Data
public class LoginVO {
    private String ptoken;
    private Integer userId;
    private Integer roleId;
    private JSONObject wxInfo;

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

    public JSONObject getWxInfo() {
        return wxInfo;
    }

    public void setWxInfo(JSONObject wxInfo) {
        this.wxInfo = wxInfo;
    }
}
