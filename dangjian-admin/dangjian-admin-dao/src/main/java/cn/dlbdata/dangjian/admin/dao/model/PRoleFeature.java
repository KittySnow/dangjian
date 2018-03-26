package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PRoleFeature implements Serializable {
    private Integer rfid;

    private Integer roleid;

    private Integer featureid;

    private static final long serialVersionUID = 1L;

    public Integer getRfid() {
        return rfid;
    }

    public void setRfid(Integer rfid) {
        this.rfid = rfid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

}