package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseParam;

public class GetUserInfo {
    private String openid;
    private String lang;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
