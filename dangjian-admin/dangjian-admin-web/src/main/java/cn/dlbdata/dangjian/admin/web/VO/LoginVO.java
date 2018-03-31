package cn.dlbdata.dangjian.admin.web.VO;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Data
public class LoginVO {
    private String ptoken;
    private Integer userId;
    private Integer roleId;

//    public void setPtoken(String token) throws UnsupportedEncodingException {
//        ptoken = URLEncoder.encode(token, "utf-8");
//    }

//    public String getPtoken() throws UnsupportedEncodingException {
//        return URLDecoder.decode(ptoken, "utf-8");
//    }
}
