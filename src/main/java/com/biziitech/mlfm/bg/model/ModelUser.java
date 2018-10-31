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

@Entity(name="BG_USER")
public class ModelUser {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_DESIGNATION_ID")
	private int userDesignationId;
	
	@Column(name="LOGIN_USER")
	private String loginUser;
	
	@Column(name="SECURITY_CODE")
	private String securityCode;
	
	@ManyToOne
	@JoinColumn(name="ORG_BRANCH_ID")
	private ModelOrgBranch orgBranchId;
	
	@Column(name="BRANCH_UNIT_ID")
	private long branchUnitId;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private int gender;
	
	@Column(name="BLOOD_GROUP")
	private String bloodGroup;
	
	@Column(name="SMS_FLAG")
	private String smsFlag;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	@Column(name="MOTHER_NAME")
	private String motherName;
	
	@Column(name="PROFESSION")
	private String profession;
	
	@Column(name="USER_ADDRESS")
	private String userAddress;
	
	@Column(name="USER_POSTCODE")
	private int userPostcode;
	
	@Column(name="USER_CITY")
	private String userCity;
	
	@Column(name="USER_POLICE_STATION")
	private String userPoliceStation;
	
	@Column(name="USER_UPAZILLA")
	private String userUpazilla;
	
	@Column(name="USER_DISTRICT")
	private String userDistrict;
	
	@Column(name="USER_DIVISION")
	private String userDivision;
	
	@Column(name="NATIONAL_ID")
	private String nationalId;
	
	@Column(name="USER_TYPE_ID")
	private long userTypeId;
	
	@Column(name="USER_DEFINED_ID")
	private String userDefinedId;
	
	@Column(name="USER_GROUP")
	private String userGroup;
	
	@Column(name="USER_TYPE")
	private String userType;
	
	@Column(name="SPOUSE_NAME")
	private String spouseName;
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private ModelCountry countryId;
	@ManyToOne
	@JoinColumn(name="ORG_ID")
	private ModelOrg orgId;
	
	@Column(name="TITLE_NAME")
	private String titleName;
	
	@Column(name="USER_IMAGE")
	private String userImage;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
	@Column(name="USER_REMARKS")
	private String userRemarks;
	
	@Column(name="ORG_TYPE_REMARKS")
	private String orgTypeRemarks;
	
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
	
    public ModelUser() {
    	
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserDesignationId() {
		return userDesignationId;
	}

	public void setUserDesignationId(int userDesignationId) {
		this.userDesignationId = userDesignationId;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public ModelOrgBranch getOrgBranchId() {
		return orgBranchId;
	}

	public void setOrgBranchId(ModelOrgBranch orgBranchId) {
		this.orgBranchId = orgBranchId;
	}

	public long getBranchUnitId() {
		return branchUnitId;
	}

	public void setBranchUnitId(long branchUnitId) {
		this.branchUnitId = branchUnitId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(String smsFlag) {
		this.smsFlag = smsFlag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserPostcode() {
		return userPostcode;
	}

	public void setUserPostcode(int userPostcode) {
		this.userPostcode = userPostcode;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserPoliceStation() {
		return userPoliceStation;
	}

	public void setUserPoliceStation(String userPoliceStation) {
		this.userPoliceStation = userPoliceStation;
	}

	public String getUserUpazilla() {
		return userUpazilla;
	}

	public void setUserUpazilla(String userUpazilla) {
		this.userUpazilla = userUpazilla;
	}

	public String getUserDistrict() {
		return userDistrict;
	}

	public void setUserDistrict(String userDistrict) {
		this.userDistrict = userDistrict;
	}

	public String getUserDivision() {
		return userDivision;
	}

	public void setUserDivision(String userDivision) {
		this.userDivision = userDivision;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserDefinedId() {
		return userDefinedId;
	}

	public void setUserDefinedId(String userDefinedId) {
		this.userDefinedId = userDefinedId;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	

	public ModelCountry getCountryId() {
		return countryId;
	}

	public void setCountryId(ModelCountry countryId) {
		this.countryId = countryId;
	}

	public ModelOrg getOrgId() {
		return orgId;
	}

	public void setOrgId(ModelOrg orgId) {
		this.orgId = orgId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	public String getOrgTypeRemarks() {
		return orgTypeRemarks;
	}

	public void setOrgTypeRemarks(String orgTypeRemarks) {
		this.orgTypeRemarks = orgTypeRemarks;
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
		return "ModelUser [userId=" + userId + ", userName=" + userName + ", userDesignationId=" + userDesignationId
				+ ", loginUser=" + loginUser + ", securityCode=" + securityCode + ", orgBranchId=" + orgBranchId
				+ ", branchUnitId=" + branchUnitId + ", dob=" + dob + ", gender=" + gender + ", bloodGroup="
				+ bloodGroup + ", smsFlag=" + smsFlag + ", email=" + email + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", profession=" + profession + ", userAddress=" + userAddress
				+ ", userPostcode=" + userPostcode + ", userCity=" + userCity + ", userPoliceStation="
				+ userPoliceStation + ", userUpazilla=" + userUpazilla + ", userDistrict=" + userDistrict
				+ ", userDivision=" + userDivision + ", nationalId=" + nationalId + ", userTypeId=" + userTypeId
				+ ", userDefinedId=" + userDefinedId + ", userGroup=" + userGroup + ", userType=" + userType
				+ ", spouseName=" + spouseName + ", countryId=" + countryId + ", orgId=" + orgId + ", titleName="
				+ titleName + ", userImage=" + userImage + ", activeStatus=" + activeStatus + ", userRemarks="
				+ userRemarks + ", orgTypeRemarks=" + orgTypeRemarks + ", enteredBy=" + enteredBy + ", entryTimestamp="
				+ entryTimestamp + ", updatedBy=" + updatedBy + ", updateTimestap=" + updateTimestap + ", flex1="
				+ flex1 + ", flex2=" + flex2 + ", flex3=" + flex3 + ", flex4=" + flex4 + ", flex5=" + flex5
				+ ", active=" + active + ", sActive=" + sActive + "]";
	}



	
}
