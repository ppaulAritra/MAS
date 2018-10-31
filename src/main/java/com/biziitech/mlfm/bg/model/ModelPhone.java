package com.biziitech.mlfm.bg.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import com.biziitech.mlfm.model.ModelOrderOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="BG_PHONE")
public class ModelPhone {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="PHONE_ID")
	private Long phoneId;
	
	@Column(name="USER_ID")
	private long userId;
	
	@ManyToOne
	@JoinColumn(name="ORDER_OWNER_ID")
	@JsonManagedReference
	private ModelOrderOwner owner;
	
	@Column(name="OWNER_TYPE_ID")
	private long ownerTypeId;
	
	@ManyToOne
	@JoinColumn(name= "COUNTRY_ID", nullable =true)
	
	private ModelCountry modelCountry  ;
	
	@Column(name="PHONE_TYPE_ID")
	private int typeId ;
	
	@Column(name="AREA_CODE")
	private String areaCode;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="ENTERED_BY")
	private long entered_By ;
	
	@Column(name="ENTRY_TIMESTAP")
	private Timestamp entryTimestap;
	
	@Column(name="UPDATED_BY")
	@ColumnDefault("0")
	private long updatedBy ;
	
	@Column(name="UPDATE_TIMESTAP" , nullable=true)
	private Timestamp updateTimestap;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus ;
	
	@Column(name="SMS_FLAG")
	private int SMS ;
	
	@Column(name="EMERGENCY_FLAG")
	private int emergencyStatus ;
	
	@Transient
	private boolean active;
	
	@Transient
	private boolean emergency;
	
	@Transient
	private String phoneType;
	
	@Transient
	private String sActive;
	
	@Transient
	private String sEmergency;
	
	
	
	public ModelPhone() {

	}



	public Long getPhoneId() {
		return phoneId;
	}



	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public ModelOrderOwner getOwner() {
		return owner;
	}



	public void setOwner(ModelOrderOwner owner) {
		this.owner = owner;
	}



	public long getOwnerTypeId() {
		return ownerTypeId;
	}



	public void setOwnerTypeId(long ownerTypeId) {
		this.ownerTypeId = ownerTypeId;
	}







	public ModelCountry getModelCountry() {
		return modelCountry;
	}



	public void setModelCountry(ModelCountry modelCountry) {
		this.modelCountry = modelCountry;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	public String getAreaCode() {
		return areaCode;
	}



	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public long getEntered_By() {
		return entered_By;
	}



	public void setEntered_By(long entered_By) {
		this.entered_By = entered_By;
	}



	public Timestamp getEntryTimestap() {
		return entryTimestap;
	}



	public void setEntryTimestap(Timestamp entryTimestap) {
		this.entryTimestap = entryTimestap;
	}



	public long getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}



	public Timestamp getUpdateTimestap() {
		return updateTimestap;
	}



	public void setUpdateTimestap(Timestamp updateTimestap) {
		this.updateTimestap = updateTimestap;
	}



	public int getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}



	public int getSMS() {
		return SMS;
	}



	public void setSMS(int sMS) {
		SMS = sMS;
	}



	public int getEmergencyStatus() {
		return emergencyStatus;
	}



	public void setEmergencyStatus(int emergencyStatus) {
		this.emergencyStatus = emergencyStatus;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public boolean isEmergency() {
		return emergency;
	}



	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}



	public String getPhoneType() {
		return phoneType;
	}



	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}



	public String getsActive() {
		return sActive;
	}



	public void setsActive(String sActive) {
		this.sActive = sActive;
	}



	public String getsEmergency() {
		return sEmergency;
	}



	public void setsEmergency(String sEmergency) {
		this.sEmergency = sEmergency;
	}



	@Override
	public String toString() {
		return "ModelPhone [phoneId=" + phoneId + ", userId=" + userId + ", owner=" + owner + ", ownerTypeId="
				+ ownerTypeId + ", modelCountry=" + modelCountry + ", typeId=" + typeId + ", areaCode=" + areaCode
				+ ", phoneNumber=" + phoneNumber + ", remarks=" + remarks + ", entered_By=" + entered_By
				+ ", entryTimestap=" + entryTimestap + ", updatedBy=" + updatedBy + ", updateTimestap=" + updateTimestap
				+ ", activeStatus=" + activeStatus + ", SMS=" + SMS + ", emergencyStatus=" + emergencyStatus
				+ ", active=" + active + ", emergency=" + emergency + ", phoneType=" + phoneType + ", sActive="
				+ sActive + ", sEmergency=" + sEmergency + "]";
	}



	

	
	
}
