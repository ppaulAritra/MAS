package com.biziitech.mlfm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.biziitech.mlfm.bg.model.ModelCountry;

@Entity(name="MLFM_BUYER")
public class ModelBuyer {
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name= "BUYER_ID")
	private Long buyerId  ;
	
	@ManyToOne
	@JoinColumn(name= "BUSINESS_TYPE_ID")
	private ModelBusinessType typeId  ;
	
	@ManyToOne
	@JoinColumn(name= "COUNTRY_ID", nullable =true)
	private ModelCountry countryId  ;
	
	@Column(name= "BUYER_NAME")
	private String buyerName  ;
	
	@Column(name= "SHORT_CODE")
	private String shortCode  ;
	
	@Column(name= "BUYER_CITY")
	private String city  ;
	
	@Column(name= "BUYER_EMAIL")
	private String email  ;
	
	@Column(name= "CONTACT_PERSON_NAME")
	private String contactPerson  ;
	
	@Column(name= "BUYER_ADDRESS")
	private String buyerAddress  ;
	
	@Column(name= "BUYER_REMARKS")
	private String remarks  ;
	
	@Column(name= "POST_CODE")
	private int postCode  ;
	
	@Column(name= "ACTIVE_STATUS")
	private int activeStatus  ;

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
	private String phoneNumber;
	@Transient
	private boolean active=true;
	@Transient
	private String countryName;
	@Transient
	private String typeName;
	
	@Transient
	private String sActive;
	
	public ModelBuyer(){
		
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public ModelBusinessType getTypeId() {
		return typeId;
	}

	public void setTypeId(ModelBusinessType typeId) {
		this.typeId = typeId;
	}

	public ModelCountry getCountryId() {
		return countryId;
	}

	public void setCountryId(ModelCountry countryId) {
		this.countryId = countryId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getsActive() {
		return sActive;
	}

	public void setsActive(String sActive) {
		this.sActive = sActive;
	}

	@Override
	public String toString() {
		return "ModelBuyer [buyerId=" + buyerId + ", typeId=" + typeId + ", countryId=" + countryId + ", buyerName="
				+ buyerName + ", shortCode=" + shortCode + ", city=" + city + ", email=" + email + ", contactPerson="
				+ contactPerson + ", buyerAddress=" + buyerAddress + ", remarks=" + remarks + ", postCode=" + postCode
				+ ", activeStatus=" + activeStatus + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3=" + flex3
				+ ", flex4=" + flex4 + ", flex5=" + flex5 + ", phoneNumber=" + phoneNumber + ", active=" + active
				+ ", countryName=" + countryName + ", typeName=" + typeName + ", sActive=" + sActive + "]";
	}
	

	
}
