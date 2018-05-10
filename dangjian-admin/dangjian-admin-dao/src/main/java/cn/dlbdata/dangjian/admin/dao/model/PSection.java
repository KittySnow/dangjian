package cn.dlbdata.dangjian.admin.dao.model;

public class PSection {
	 /**
     * 片区id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 片区名称
     *
     * @mbg.generated
     */
    private String name;
    /**
     * 片区书记ID
     *
     * @mbg.generated
     */
    private Integer secretaryId;
    
    private String remark;
    /**
     * 片区企业数量
     *
     * @mbg.generated
     */
    private Integer enterpriseCount;
    /**
     * 片区负责人姓名
     *
     * @mbg.generated
     */
    private String secretaryName;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSecretaryId() {
		return secretaryId;
	}
	public void setSecretaryId(Integer secretaryId) {
		this.secretaryId = secretaryId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEnterpriseCount() {
		return enterpriseCount;
	}
	public void setEnterpriseCount(Integer enterpriseCount) {
		this.enterpriseCount = enterpriseCount;
	}
	public String getSecretaryName() {
		return secretaryName;
	}
	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}
    
}
