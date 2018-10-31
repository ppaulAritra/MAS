package com.biziitech.mlfm.bg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="BG_OWNER_TYPE")
public class ModelOwnerType {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="OWNER_TYPE_ID")
	private Long ownerTypeId;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	@Column(name="SHORT_CODE")
	private String shortCode;
	
	@Column(name="OWNER_DATA_TABLE")
	private String ownerDataTable;
	
	@Column(name="OWNER_DATA_TABLE_SCHEMA")
	private String ownerDataTableSchema;
	
	@Column(name="OWNER_TYPE_REMARKS")
	private String ownerTypeRemarks;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
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
	
	public ModelOwnerType() {
		
	}

	public Long getOwnerTypeId() {
		return ownerTypeId;
	}

	public void setOwnerTypeId(Long ownerTypeId) {
		this.ownerTypeId = ownerTypeId;
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

	public String getOwnerDataTable() {
		return ownerDataTable;
	}

	public void setOwnerDataTable(String ownerDataTable) {
		this.ownerDataTable = ownerDataTable;
	}

	public String getOwnerDataTableSchema() {
		return ownerDataTableSchema;
	}

	public void setOwnerDataTableSchema(String ownerDataTableSchema) {
		this.ownerDataTableSchema = ownerDataTableSchema;
	}

	public String getOwnerTypeRemarks() {
		return ownerTypeRemarks;
	}

	public void setOwnerTypeRemarks(String ownerTypeRemarks) {
		this.ownerTypeRemarks = ownerTypeRemarks;
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
		return "ModelOwnerType [ownerTypeId=" + ownerTypeId + ", typeName=" + typeName + ", shortCode=" + shortCode
				+ ", ownerDataTable=" + ownerDataTable + ", ownerDataTableSchema=" + ownerDataTableSchema
				+ ", ownerTypeRemarks=" + ownerTypeRemarks + ", activeStatus=" + activeStatus + ", flex1=" + flex1
				+ ", flex2=" + flex2 + ", flex3=" + flex3 + ", flex4=" + flex4 + ", flex5=" + flex5 + ", active="
				+ active + ", sActive=" + sActive + "]";
	}

	
}
