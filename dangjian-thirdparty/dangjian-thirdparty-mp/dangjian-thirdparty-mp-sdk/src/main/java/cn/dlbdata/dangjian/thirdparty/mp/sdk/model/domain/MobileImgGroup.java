package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain;

import java.util.Date;

public class MobileImgGroup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.PHARMACY_ID
     *
     * @mbggenerated
     */
    private Integer pharmacyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.GROUP_NAME
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.IS_DEFAULT
     *
     * @mbggenerated
     */
    private Integer isDefault;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    private Integer lifeCycleStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mobile_img_group.UPDATE_TIME
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.ID
     *
     * @return the value of t_mobile_img_group.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.ID
     *
     * @param id the value for t_mobile_img_group.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.PHARMACY_ID
     *
     * @return the value of t_mobile_img_group.PHARMACY_ID
     *
     * @mbggenerated
     */
    public Integer getPharmacyId() {
        return pharmacyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.PHARMACY_ID
     *
     * @param pharmacyId the value for t_mobile_img_group.PHARMACY_ID
     *
     * @mbggenerated
     */
    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.GROUP_NAME
     *
     * @return the value of t_mobile_img_group.GROUP_NAME
     *
     * @mbggenerated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.GROUP_NAME
     *
     * @param groupName the value for t_mobile_img_group.GROUP_NAME
     *
     * @mbggenerated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.IS_DEFAULT
     *
     * @return the value of t_mobile_img_group.IS_DEFAULT
     *
     * @mbggenerated
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.IS_DEFAULT
     *
     * @param isDefault the value for t_mobile_img_group.IS_DEFAULT
     *
     * @mbggenerated
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.LIFE_CYCLE_STATUS
     *
     * @return the value of t_mobile_img_group.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    public Integer getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.LIFE_CYCLE_STATUS
     *
     * @param lifeCycleStatus the value for t_mobile_img_group.LIFE_CYCLE_STATUS
     *
     * @mbggenerated
     */
    public void setLifeCycleStatus(Integer lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.CREATE_TIME
     *
     * @return the value of t_mobile_img_group.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.CREATE_TIME
     *
     * @param createTime the value for t_mobile_img_group.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mobile_img_group.UPDATE_TIME
     *
     * @return the value of t_mobile_img_group.UPDATE_TIME
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mobile_img_group.UPDATE_TIME
     *
     * @param updateTime the value for t_mobile_img_group.UPDATE_TIME
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}