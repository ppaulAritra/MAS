package com.biziitech.mlfm.model;

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

@Entity(name="MLFM_ITEM")
public class ModelItem {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="ITEM_ID")
	private Long itemId;
	
	@ManyToOne
	@JoinColumn(name="ITEM_TYPE_ID")
	private ModelItemType itemTypeId;
	
	@ManyToOne
	@JoinColumn(name="UOM_ID")
	private ModelUOM modelUOM;
	
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_SPEC")
	private String itemSpec;
	
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
	
	@Transient
	private boolean active;
	
	@Transient
	private String sActive;
	
	@Transient
	private Long categoryId;
	
	@Transient
	private Long subcategoryId;
	
	@Transient
	private Long subsubcategoryId;
	
    public ModelItem() {
    	
    }

    
    
	public Long getItemId() {
		return itemId;
	}



	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}



	public ModelItemType getItemTypeId() {
		return itemTypeId;
	}



	public void setItemTypeId(ModelItemType itemTypeId) {
		this.itemTypeId = itemTypeId;
	}



	public ModelUOM getModelUOM() {
		return modelUOM;
	}



	public void setModelUOM(ModelUOM modelUOM) {
		this.modelUOM = modelUOM;
	}



	public String getItemSpec() {
		return itemSpec;
	}



	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
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



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public Long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	public Long getSubcategoryId() {
		return subcategoryId;
	}



	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}



	public Long getSubsubcategoryId() {
		return subsubcategoryId;
	}



	public void setSubsubcategoryId(Long subsubcategoryId) {
		this.subsubcategoryId = subsubcategoryId;
	}



	@Override
	public String toString() {
		return "ModelItem [itemId=" + itemId + ", itemTypeId=" + itemTypeId + ", modelUOM=" + modelUOM + ", itemSpec="
				+ itemSpec + ", remarks=" + remarks + ", activeStatus=" + activeStatus + ", enteredBy=" + enteredBy
				+ ", entryTimestamp=" + entryTimestamp + ", updatedBy=" + updatedBy + ", updateTimestap="
				+ updateTimestap + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3=" + flex3 + ", flex4=" + flex4
				+ ", flex5=" + flex5 + ", active=" + active + ", sActive=" + sActive + "]";
	}

	
}
