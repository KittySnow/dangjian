package cn.dlbdata.dangjian.admin.web.VO;

import lombok.Data;

@Data
public class LoginVO {
    private String ptoken;
    private Integer userId;
    private Integer roleId;
}
