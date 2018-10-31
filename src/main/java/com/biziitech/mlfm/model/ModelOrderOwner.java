package com.biziitech.mlfm.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="MLFM_ORDER_OWNER")
public class ModelOrderOwner {

	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="ORDER_OWNER_ID")
	private Long orderOwnerId;
	
	@Column(name="OWNER_NAME")
	private String ownerName;
	
	@OneToOne
	@JoinColumn(name="ORDER_OWNER_TYPE_ID")
	private ModelOrderOwnerType orderOwnerType;
	
	@OneToOne
	@JoinColumn(name="BUSINESS_TYPE_ID")
	private ModelBusinessType modelBusinessType;
	
	@Column(name="SHORT_CODE")
	private String shortCode;
	
	@Column(name="OWNER_ADDRESS")
	private String ownerAddress;
	
	@ManyToOne
	@JoinColumn(name="OWNER_COUNTRY")
	private ModelCountry ownerCountry;
	
	@Column(name="OWNER_CITY")
	private String ownerCity;
	
	@Column(name="POST_CODE")
	private int postCode;
	
	@Column(name="OWNER_EMAIL")
	private String ownerEmail;
	
	@Column(name="CONTACT_PERSON_NAME")
	private String contactPersonName;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
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
	
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.EAGER)    
	 @JsonBackReference
	private List<ModelPhone> phones;
	
	
	@Transient
	private boolean active;

	
	@Transient
	private String sActive;
	
	@Transient
	private String phoneNumber; // using only for search
	
	@Transient
	private int countOrder; //using for counting order of a user
	
	
    public ModelOrderOwner() {
    	
    }


	public Long getOrderOwnerId() {
		return orderOwnerId;
	}


	public void setOrderOwnerId(Long orderOwnerId) {
		this.orderOwnerId = orderOwnerId;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public ModelOrderOwnerType getOrderOwnerType() {
		return orderOwnerType;
	}


	public void setOrderOwnerType(ModelOrderOwnerType orderOwnerType) {
		this.orderOwnerType = orderOwnerType;
	}


	


	public ModelBusinessType getModelBusinessType() {
		return modelBusinessType;
	}


	public void setModelBusinessType(ModelBusinessType modelBusinessType) {
		this.modelBusinessType = modelBusinessType;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public String getOwnerAddress() {
		return ownerAddress;
	}


	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}


	public ModelCountry getOwnerCountry() {
		return ownerCountry;
	}


	public void setOwnerCountry(ModelCountry ownerCountry) {
		this.ownerCountry = ownerCountry;
	}


	public String getOwnerCity() {
		return ownerCity;
	}


	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getOwnerEmail() {
		return ownerEmail;
	}


	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}


	public String getContactPersonName() {
		return contactPersonName;
	}


	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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


	public List<ModelPhone> getPhones() {
		return phones;
	}


	public void setPhones(List<ModelPhone> phones) {
		this.phones = phones;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getCountOrder() {
		return countOrder;
	}


	public void setCountOrder(int countOrder) {
		this.countOrder = countOrder;
	}


	@Override
	public String toString() {
		return "ModelOrderOwner [orderOwnerId=" + orderOwnerId + ", ownerName=" + ownerName + ", orderOwnerType="
				+ orderOwnerType + ", modelBusinessType=" + modelBusinessType + ", shortCode=" + shortCode
				+ ", ownerAddress=" + ownerAddress + ", ownerCountry=" + ownerCountry + ", ownerCity=" + ownerCity
				+ ", postCode=" + postCode + ", ownerEmail=" + ownerEmail + ", contactPersonName=" + contactPersonName
				+ ", remarks=" + remarks + ", activeStatus=" + activeStatus + ", enteredBy=" + enteredBy
				+ ", entryTimestamp=" + entryTimestamp + ", updatedBy=" + updatedBy + ", updateTimestap="
				+ updateTimestap + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3=" + flex3 + ", flex4=" + flex4
				+ ", flex5=" + flex5 + ", phones=" + phones + ", active=" + active + ", sActive=" + sActive
				+ ", phoneNumber=" + phoneNumber + ", countOrder=" + countOrder + "]";
	}





	




	

}
