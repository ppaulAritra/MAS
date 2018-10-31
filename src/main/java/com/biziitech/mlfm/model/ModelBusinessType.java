package com.biziitech.mlfm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="MLFM_BUSINESS_TYPE")
public class ModelBusinessType {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="BUSINESS_TYPE_ID")
	private Long typeId;
	
	@Column(name="BUSINESS_TYPE_NAME")
	private String typeName;
	
	@Column(name="SHORT_CODE")
	private String shortCode  ;
	
	@Column(name="REMARKS")
	private String remarks  ;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus  ;
	
	@Column(name="ENTERED_BY")
	private long enteredBy;
	
	@Column(name="ENTRY_TIMESTAMP")
	private Date entryTimestap;
	
	@Column(name="UPDATED_BY", nullable=false)
	@ColumnDefault("0")
	private long updatedBy;
	
	@Column(name="UPDATE_TIMESTAMP")
	private Date updateTimestap;
	
	
	@Transient
	private boolean active;
	
	@Transient
	private String sActive;
	
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
	
	
	public ModelBusinessType() {
		
	}


	public Long getTypeId() {
		return typeId;
	}


	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
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


	public Date getEntryTimestap() {
		return entryTimestap;
	}


	public void setEntryTimestap(Date entryTimestap) {
		this.entryTimestap = entryTimestap;
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


	@Override
	public String toString() {
		return "ModelBusinessType [typeId=" + typeId + ", typeName=" + typeName + ", shortCode=" + shortCode
				+ ", remarks=" + remarks + ", activeStatus=" + activeStatus + ", enteredBy=" + enteredBy
				+ ", entryTimestap=" + entryTimestap + ", updatedBy=" + updatedBy + ", updateTimestap=" + updateTimestap
				+ ", active=" + active + ", sActive=" + sActive + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3="
				+ flex3 + ", flex4=" + flex4 + ", flex5=" + flex5 + "]";
	}


	

}
