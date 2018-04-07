package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PWxUser implements Serializable {
    private Integer id;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * OpenID
     *
     * @mbg.generated
     */
    private String openId;

    /**
     * 昵称
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * 性别
     *
     * @mbg.generated
     */
    private Boolean sex;

    /**
     * 语言
     *
     * @mbg.generated
     */
    private String language;

    /**
     * 市
     *
     * @mbg.generated
     */
    private String city;

    /**
     * 省
     *
     * @mbg.generated
     */
    private String province;

    /**
     * 国家
     *
     * @mbg.generated
     */
    private String country;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private String headImgUrl;

    /**
     * 用户关注时间
     *
     * @mbg.generated
     */
    private Integer subscribeTime;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 群组ID
     *
     * @mbg.generated
     */
    private Integer groupId;

    /**
     * 标签列表
     *
     * @mbg.generated
     */
    private String tagidList;

    /**
     * 关注详情
     *
     * @mbg.generated
     */
    private String subscribeScene;

    /**
     * 二维码
     *
     * @mbg.generated
     */
    private Integer qrScene;

    /**
     * 二维码签名
     *
     * @mbg.generated
     */
    private String qrSceneStr;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Integer subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTagidList() {
        return tagidList;
    }

    public void setTagidList(String tagidList) {
        this.tagidList = tagidList;
    }

    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    public Integer getQrScene() {
        return qrScene;
    }

    public void setQrScene(Integer qrScene) {
        this.qrScene = qrScene;
    }

    public String getQrSceneStr() {
        return qrSceneStr;
    }

    public void setQrSceneStr(String qrSceneStr) {
        this.qrSceneStr = qrSceneStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", nickName=").append(nickName);
        sb.append(", sex=").append(sex);
        sb.append(", language=").append(language);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append(", country=").append(country);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", subscribeTime=").append(subscribeTime);
        sb.append(", remark=").append(remark);
        sb.append(", groupId=").append(groupId);
        sb.append(", tagidList=").append(tagidList);
        sb.append(", subscribeScene=").append(subscribeScene);
        sb.append(", qrScene=").append(qrScene);
        sb.append(", qrSceneStr=").append(qrSceneStr);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PWxUser other = (PWxUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getHeadImgUrl() == null ? other.getHeadImgUrl() == null : this.getHeadImgUrl().equals(other.getHeadImgUrl()))
            && (this.getSubscribeTime() == null ? other.getSubscribeTime() == null : this.getSubscribeTime().equals(other.getSubscribeTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getTagidList() == null ? other.getTagidList() == null : this.getTagidList().equals(other.getTagidList()))
            && (this.getSubscribeScene() == null ? other.getSubscribeScene() == null : this.getSubscribeScene().equals(other.getSubscribeScene()))
            && (this.getQrScene() == null ? other.getQrScene() == null : this.getQrScene().equals(other.getQrScene()))
            && (this.getQrSceneStr() == null ? other.getQrSceneStr() == null : this.getQrSceneStr().equals(other.getQrSceneStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getHeadImgUrl() == null) ? 0 : getHeadImgUrl().hashCode());
        result = prime * result + ((getSubscribeTime() == null) ? 0 : getSubscribeTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getTagidList() == null) ? 0 : getTagidList().hashCode());
        result = prime * result + ((getSubscribeScene() == null) ? 0 : getSubscribeScene().hashCode());
        result = prime * result + ((getQrScene() == null) ? 0 : getQrScene().hashCode());
        result = prime * result + ((getQrSceneStr() == null) ? 0 : getQrSceneStr().hashCode());
        return result;
    }
}