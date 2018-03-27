package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain;

import java.util.Date;

public class MobileWxAttentionUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.PHARMACY_ID
     *
     * @mbggenerated
     */
    private Integer pharmacyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.OPENID
     *
     * @mbggenerated
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.NICKNAME
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.SEX
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.PROVINCE
     *
     * @mbggenerated
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.CITY
     *
     * @mbggenerated
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.COUNTRY
     *
     * @mbggenerated
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.LANGUAGE
     *
     * @mbggenerated
     */
    private String language;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.HEADIMGURL
     *
     * @mbggenerated
     */
    private String headimgurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.SUBSCRIBE_TIME
     *
     * @mbggenerated
     */
    private Date subscribeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.REMARK
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.GROUP_ID
     *
     * @mbggenerated
     */
    private String groupId;
    private String groupName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.IS_SUBSCRIBE
     *
     * @mbggenerated
     */
    private Integer isSubscribe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    private Integer lifeCycleStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_wx_attention_user.UPDATE_TIME
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.ID
     *
     * @return the value of t_mobile_wx_attention_user.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.ID
     *
     * @param id the value for t_mobile_wx_attention_user.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.PHARMACY_ID
     *
     * @return the value of t_mobile_wx_attention_user.PHARMACY_ID
     *
     * @mbggenerated
     */
    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.PHARMACY_ID
     *
     * @param pharmacyId the value for t_mobile_wx_attention_user.PHARMACY_ID
     *
     * @mbggenerated
     */
    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.OPENID
     *
     * @return the value of t_mobile_wx_attention_user.OPENID
     *
     * @mbggenerated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.OPENID
     *
     * @param openid the value for t_mobile_wx_attention_user.OPENID
     *
     * @mbggenerated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.NICKNAME
     *
     * @return the value of t_mobile_wx_attention_user.NICKNAME
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.NICKNAME
     *
     * @param nickname the value for t_mobile_wx_attention_user.NICKNAME
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.SEX
     *
     * @return the value of t_mobile_wx_attention_user.SEX
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.SEX
     *
     * @param sex the value for t_mobile_wx_attention_user.SEX
     *
     * @mbggenerated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.PROVINCE
     *
     * @return the value of t_mobile_wx_attention_user.PROVINCE
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.PROVINCE
     *
     * @param province the value for t_mobile_wx_attention_user.PROVINCE
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.CITY
     *
     * @return the value of t_mobile_wx_attention_user.CITY
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.CITY
     *
     * @param city the value for t_mobile_wx_attention_user.CITY
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.COUNTRY
     *
     * @return the value of t_mobile_wx_attention_user.COUNTRY
     *
     * @mbggenerated
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.COUNTRY
     *
     * @param country the value for t_mobile_wx_attention_user.COUNTRY
     *
     * @mbggenerated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.LANGUAGE
     *
     * @return the value of t_mobile_wx_attention_user.LANGUAGE
     *
     * @mbggenerated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.LANGUAGE
     *
     * @param language the value for t_mobile_wx_attention_user.LANGUAGE
     *
     * @mbggenerated
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.HEADIMGURL
     *
     * @return the value of t_mobile_wx_attention_user.HEADIMGURL
     *
     * @mbggenerated
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.HEADIMGURL
     *
     * @param headimgurl the value for t_mobile_wx_attention_user.HEADIMGURL
     *
     * @mbggenerated
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.SUBSCRIBE_TIME
     *
     * @return the value of t_mobile_wx_attention_user.SUBSCRIBE_TIME
     *
     * @mbggenerated
     */
    public Date getSubscribeTime() {
        return subscribeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.SUBSCRIBE_TIME
     *
     * @param subscribeTime the value for t_mobile_wx_attention_user.SUBSCRIBE_TIME
     *
     * @mbggenerated
     */
    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.REMARK
     *
     * @return the value of t_mobile_wx_attention_user.REMARK
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.REMARK
     *
     * @param remark the value for t_mobile_wx_attention_user.REMARK
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.GROUP_ID
     *
     * @return the value of t_mobile_wx_attention_user.GROUP_ID
     *
     * @mbggenerated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.GROUP_ID
     *
     * @param groupId the value for t_mobile_wx_attention_user.GROUP_ID
     *
     * @mbggenerated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.IS_SUBSCRIBE
     *
     * @return the value of t_mobile_wx_attention_user.IS_SUBSCRIBE
     *
     * @mbggenerated
     */
    public Integer getIsSubscribe() {
        return isSubscribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.IS_SUBSCRIBE
     *
     * @param isSubscribe the value for t_mobile_wx_attention_user.IS_SUBSCRIBE
     *
     * @mbggenerated
     */
    public void setIsSubscribe(Integer isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.LIFE_CYCLE_STATUS
     *
     * @return the value of t_mobile_wx_attention_user.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    public Integer getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.LIFE_CYCLE_STATUS
     *
     * @param lifeCycleStatus the value for t_mobile_wx_attention_user.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    public void setLifeCycleStatus(Integer lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.CREATE_TIME
     *
     * @return the value of t_mobile_wx_attention_user.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.CREATE_TIME
     *
     * @param createTime the value for t_mobile_wx_attention_user.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_wx_attention_user.UPDATE_TIME
     *
     * @return the value of t_mobile_wx_attention_user.UPDATE_TIME
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_wx_attention_user.UPDATE_TIME
     *
     * @param updateTime the value for t_mobile_wx_attention_user.UPDATE_TIME
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}