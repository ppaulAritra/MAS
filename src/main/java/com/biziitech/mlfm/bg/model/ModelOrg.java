package com.biziitech.mlfm.bg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="BG_ORG")
public class ModelOrg {

	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="ORG_ID")
	private Long orgId;
	
	@Column(name="ORG_NAME")
	private String orgName;
	
	@Column(name="SHORT_CODE")
	private String shortCode;
	@ManyToOne
	@JoinColumn(name="ORG_GROUP_ID")
	private ModelOrgGroup orgGroupId;
	
	@ManyToOne
	@JoinColumn(name="ORG_TYPE_ID")
	private ModelOrgType orgTypeId;
	
	@ManyToOne
	@JoinColumn(name= "COUNTRY_ID", nullable =true)
	private ModelCountry countryId;
	
	@Column(name="ORG_ADDRESS")
	private String orgAddress;
	
	@Column(name="ORG_EMAIL")
	private String orgEmail;
	
	@Column(name="ORG_WEB")
	private String orgWeb;
	
	@Column(name="ORG_PHONE")
	private String orgPhone;
	
	@Column(name="POST_CODE")
	private long postCode;
	
	@Column(name="ORG_CITY")
	private String orgCity;
	
	@Column(name="POLICE_STATION")
	private String polliceStation;
	
	@Column(name="ORG_UPAZILLA")
	private String orgUpazilla;
	
	@Column(name="ORG_DISTRICT")
	private String orgDistrict;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
	@Column(name="ORG_REMARKS")
	private String orgRemarks;
	
	@Column(name="ENTERED_BY")
	private long enteredBy;
	
	@Column(name="ENTRY_TIMESTAMP")
	private Date entryTimestamp;
	
	@Column(name="UPDATED_BY")
	@ColumnDefault("0")
	private long updatedBy;
	
	@Column(name="UPDATE_TIMESTAMP" , nullable=true)
	private Date updateTimestap;
	
	@Column(name="FLEX_FIELD1")
	private String flex1  ;
	
	@Column(name="FLEX_FIELD2")
	private String flex2  ;
	
	@Column(name="FLEX_FIELD3")
	private String flex3  ;
	
	@Column(name="FLEX_FIELD4")
	private String flex4  ;
	
	@Column(name="FLEX_FIELD5")
	private String flex5  ;
	
	@Transient
	private boolean active;
	
	@Transient
	private String sActive;
	
	public ModelOrg() {

	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public ModelOrgGroup getOrgGroupId() {
		return orgGroupId;
	}

	public void setOrgGroupId(ModelOrgGroup orgGroupId) {
		this.orgGroupId = orgGroupId;
	}

	public ModelOrgType getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(ModelOrgType orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public ModelCountry getCountryId() {
		return countryId;
	}

	public void setCountryId(ModelCountry countryId) {
		this.countryId = countryId;
	}

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	public String getOrgWeb() {
		return orgWeb;
	}

	public void setOrgWeb(String orgWeb) {
		this.orgWeb = orgWeb;
	}

	public String getOrgPhone() {
		return orgPhone;
	}

	public void setOrgPhone(String orgPhone) {
		this.orgPhone = orgPhone;
	}

	public long getPostCode() {
		return postCode;
	}

	public void setPostCode(long postCode) {
		this.postCode = postCode;
	}

	public String getOrgCity() {
		return orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getPolliceStation() {
		return polliceStation;
	}

	public void setPolliceStation(String polliceStation) {
		this.polliceStation = polliceStation;
	}

	public String getOrgUpazilla() {
		return orgUpazilla;
	}

	public void setOrgUpazilla(String orgUpazilla) {
		this.orgUpazilla = orgUpazilla;
	}

	public String getOrgDistrict() {
		return orgDistrict;
	}

	public void setOrgDistrict(String orgDistrict) {
		this.orgDistrict = orgDistrict;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getOrgRemarks() {
		return orgRemarks;
	}

	public void setOrgRemarks(String orgRemarks) {
		this.orgRemarks = orgRemarks;
	}

	public long getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(long enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Date getEntryTimestamp() {
		return entryTimestamp;
	}

	public void setEntryTimestamp(Date entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdateTimestap() {
		return updateTimestap;
	}

	public void setUpdateTimestap(Date updateTimestap) {
		this.updateTimestap = updateTimestap;
	}

	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public String getFlex5() {
		return flex5;
	}

	public void setFlex5(String flex5) {
		this.flex5 = flex5;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getsActive() {
		return sActive;
	}

	public void setsActive(String sActive) {
		this.sActive = sActive;
	}

	@Override
	public String toString() {
		return "ModelOrg [orgId=" + orgId + ", orgName=" + orgName + ", shortCode=" + shortCode + ", orgGroupId="
				+ orgGroupId + ", orgTypeId=" + orgTypeId + ", countryId=" + countryId + ", orgAddress=" + orgAddress
				+ ", orgEmail=" + orgEmail + ", orgWeb=" + orgWeb + ", orgPhone=" + orgPhone + ", postCode=" + postCode
				+ ", orgCity=" + orgCity + ", polliceStation=" + polliceStation + ", orgUpazilla=" + orgUpazilla
				+ ", orgDistrict=" + orgDistrict + ", activeStatus=" + activeStatus + ", orgRemarks=" + orgRemarks
				+ ", enteredBy=" + enteredBy + ", entryTimestamp=" + entryTimestamp + ", updatedBy=" + updatedBy
				+ ", updateTimestap=" + updateTimestap + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3=" + flex3
				+ ", flex4=" + flex4 + ", flex5=" + flex5 + ", active=" + active + ", sActive=" + sActive + "]";
	}

	
}
