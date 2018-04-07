package cn.dlbdata.dangjian.common.DO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class WXUserInfoDO {
    @JSONField(name = "subscribe")
    private Integer subscribe;
    @JSONField(name = "openid")
    private String openId;
    @JSONField(name="nickname")
    private String nickName;
    @JSONField(name="sex")
    private Integer sex;
    @JSONField(name="language")
    private String language;
    @JSONField(name="city")
    private String city;
    @JSONField(name="province")
    private String province;
    @JSONField(name="country")
    private String country;
    @JSONField(name="headimgurl")
    private String headImgUrl;
    @JSONField(name="subscribe_time")
    private Integer subscribeTime;
    @JSONField(name="remark")
    private String remark;
    @JSONField(name="groupid")
    private Integer groupId;
    @JSONField(name="tagid_list")
    private List<Integer> tagIdList;
    @JSONField(name="subscribe_scene")
    private String subscribeScene;
    @JSONField(name="qr_scene")
    private String qrScene;
    @JSONField(name="qr_scene_str")
    private String qrSceneStr;
}
