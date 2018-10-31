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

@Entity(name="BG_ORG_BRANCH")
public class ModelOrgBranch {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="ORG_BRANCH_ID")
	private Long orgBranchId;
	
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@Column(name="SHORT_CODE")
	private String shortCode;
	
	@Column(name="BRANCH_MAIN")
	private int branchMain;
	
	@ManyToOne
	@JoinColumn(name="ORG_ID")
	private ModelOrg orgId;
	
	@ManyToOne
	@JoinColumn(name= "COUNTRY_ID", nullable =true)
	private ModelCountry countryId;
	
	@Column(name="BRANCH_ADDRESS")
	private String branchAddress;
	
	@Column(name="BRANCH_EMAIL")
	private String branchEmail;
	
	@Column(name="BRANCH_WEB")
	private String branchWeb;
	
	@Column(name="BRANCH_PHONE")
	private String branchPhone;
	
	@Column(name="POST_CODE")
	private int postCode;
	
	@Column(name="BRANCH_CITY")
	private String branchCity;
	
	@Column(name="POLICE_STATION")
	private String polliceStation;
	
	@Column(name="BRANCH_UPAZILLA")
	private String branchUpazilla;
	
	@Column(name="BRANCH_DISTRICT")
	private String branchDistrict;
	
	@Column(name="BRANCH_DIVISION")
	private String branchDivision;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
	@Column(name="ORG_BRANCH_REMARKS")
	private String orgBranchRemarks;
	
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
	
	
	public ModelOrgBranch() {
		
	}


	public Long getOrgBranchId() {
		return orgBranchId;
	}


	public void setOrgBranchId(Long orgBranchId) {
		this.orgBranchId = orgBranchId;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public int getBranchMain() {
		return branchMain;
	}


	public void setBranchMain(int branchMain) {
		this.branchMain = branchMain;
	}


	public ModelOrg getOrgId() {
		return orgId;
	}


	public void setOrgId(ModelOrg orgId) {
		this.orgId = orgId;
	}


	public ModelCountry getCountryId() {
		return countryId;
	}


	public void setCountryId(ModelCountry countryId) {
		this.countryId = countryId;
	}


	public String getBranchAddress() {
		return branchAddress;
	}


	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}


	public String getBranchEmail() {
		return branchEmail;
	}


	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}


	public String getBranchWeb() {
		return branchWeb;
	}


	public void setBranchWeb(String branchWeb) {
		this.branchWeb = branchWeb;
	}


	public String getBranchPhone() {
		return branchPhone;
	}


	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getBranchCity() {
		return branchCity;
	}


	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}


	public String getPolliceStation() {
		return polliceStation;
	}


	public void setPolliceStation(String polliceStation) {
		this.polliceStation = polliceStation;
	}


	public String getBranchUpazilla() {
		return branchUpazilla;
	}


	public void setBranchUpazilla(String branchUpazilla) {
		this.branchUpazilla = branchUpazilla;
	}


	public String getBranchDistrict() {
		return branchDistrict;
	}


	public void setBranchDistrict(String branchDistrict) {
		this.branchDistrict = branchDistrict;
	}


	public String getBranchDivision() {
		return branchDivision;
	}


	public void setBranchDivision(String branchDivision) {
		this.branchDivision = branchDivision;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	public String getOrgBranchRemarks() {
		return orgBranchRemarks;
	}


	public void setOrgBranchRemarks(String orgBranchRemarks) {
		this.orgBranchRemarks = orgBranchRemarks;
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
		return "ModelOrgBranch [orgBranchId=" + orgBranchId + ", branchName=" + branchName + ", shortCode=" + shortCode
				+ ", branchMain=" + branchMain + ", orgId=" + orgId + ", countryId=" + countryId + ", branchAddress="
				+ branchAddress + ", branchEmail=" + branchEmail + ", branchWeb=" + branchWeb + ", branchPhone="
				+ branchPhone + ", postCode=" + postCode + ", branchCity=" + branchCity + ", polliceStation="
				+ polliceStation + ", branchUpazilla=" + branchUpazilla + ", branchDistrict=" + branchDistrict
				+ ", branchDivision=" + branchDivision + ", activeStatus=" + activeStatus + ", orgBranchRemarks="
				+ orgBranchRemarks + ", enteredBy=" + enteredBy + ", entryTimestamp=" + entryTimestamp + ", updatedBy="
				+ updatedBy + ", updateTimestap=" + updateTimestap + ", flex1=" + flex1 + ", flex2=" + flex2
				+ ", flex3=" + flex3 + ", flex4=" + flex4 + ", flex5=" + flex5 + ", active=" + active + ", sActive="
				+ sActive + "]";
	}


	
}
