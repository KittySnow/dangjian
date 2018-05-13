package cn.dlbdata.dangjian.common.DO;

import lombok.Data;

@Data
public class UserLoginDO {
    private String name;
    private String password;
    private String openId;
    private Integer userType;
    private String rePassWord;
}
