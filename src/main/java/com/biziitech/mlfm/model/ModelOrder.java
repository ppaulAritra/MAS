package com.biziitech.mlfm.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.biziitech.mlfm.bg.model.ModelUser;

@Entity(name="MLFM_ORDER")
public class ModelOrder {
	
	@Id @GenericGenerator(name = "custom_sequence", strategy = 
			"com.biziitech.mlfm.IdGenerator")
	@GeneratedValue(generator = "custom_sequence")
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="USER_ORDER_NO")
	private String userOrderNo;
	
	@Column(name="ORDER_TYPE")
	private int orderType;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="REF_ORDER_ID")
	private long refOrderId;
	
	@Column(name="REF_ID")
	private long refId;
	
	@Column(name="USER_REF_NO")
	private String userRefNo;
	
	@ManyToOne
	@JoinColumn(name="ORDER_OWNER_TYPE_ID")
	//private long orderOwnerTypeId;
	private ModelOrderOwnerType modelOrderOwnerType;
	
	@ManyToOne
	@JoinColumn(name="ORDER_OWNER_ID")
	private ModelOrderOwner modelOrderOwner;
	
	@ManyToOne
	@JoinColumn(name="ULTIMATE_ORDER_OWNER_ID")
	private ModelOrderOwner ultimateOwner;
	
	@Column(name="REF_MAIL_ID")
	private String refMailId;
	
	@Column(name="MAIL_SENT_DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date mailSentDate;
	
	@Column(name="MAIL_RECEIVE_DATE")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date mailReceiveDate;
	
	@Column(name="ORDER_REMARKS")
	private String orderRemarks;
	
	@Column(name="FINAL_STATUS")
	private int finalStatus;
	
	@Column(name="VERIFY_STATUS")
	private int verifyStatus;
	
	@ManyToOne
	@JoinColumn(name="VERIFIED_BY")
	private ModelUser modelVerified;
	
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
	@ManyToOne
	@JoinColumn(name="ENTERED_BY")
	private ModelUser enteredBy;
	
	@Column(name="ENTRY_TIMESTAMP")
	private Date entryTimestamp;
	
	@ManyToOne
	@JoinColumn(name="UPDATED_BY")
	private ModelUser updatedBy;
	
	@Column(name="UPDATE_TIMESTAMP" , nullable=true)
	private Date updateTimestap;
	
	@Column(name="APRX_ORDER_QTY")
	private int aprxOrderQty;
	
	@ManyToOne
	@JoinColumn(name="APRX_ORDER_QTY_UOM")
	private ModelUOM modelUom;
	
	@ManyToOne
	@JoinColumn(name="CLUSTER_ID")
	private ModelCluster modelCluster;
	
	public String getDateBuyerExpectedDate() {
		return dateBuyerExpectedDate;
	}

	public void setDateBuyerExpectedDate(String dateBuyerExpectedDate) {
		this.dateBuyerExpectedDate = dateBuyerExpectedDate;
	}

	@Column(name="CONTACT_PERSON_NAME")
	private String contactPersonName;
	
	
	@Column(name="BUYER_EXPECTED_PRICE")
	private float expectedPrice;
	
	@Column(name="BUYER_EXPECTED_DELIVERY_DATE")
	private Date expectedDeliveryDate;
	
	
	
	
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
	private String dateCheck;

	@Transient
	private String dateMailReceive;
	@Transient
	private String dateMailSent;
	@Transient
	private String dateBuyerExpectedDate;

	public String getDateMailSent() {
		return dateMailSent;
	}

	public void setDateMailSent(String dateMailSent) {
		this.dateMailSent = dateMailSent;
	}

	public String getDateMailReceive() {
		return dateMailReceive;
	}

	public void setDateMailReceive(String dateMailReceive) {
		this.dateMailReceive = dateMailReceive;
	}

	
    public String getDateCheck() {
		return dateCheck;
	}

	public void setDateCheck(String dateCheck) {
		this.dateCheck = dateCheck;
	}

	public ModelOrder() {
    	
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getUserOrderNo() {
		return userOrderNo;
	}

	public void setUserOrderNo(String userOrderNo) {
		this.userOrderNo = userOrderNo;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getRefOrderId() {
		return refOrderId;
	}

	public void setRefOrderId(long refOrderId) {
		this.refOrderId = refOrderId;
	}

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	public String getUserRefNo() {
		return userRefNo;
	}

	public void setUserRefNo(String userRefNo) {
		this.userRefNo = userRefNo;
	}


	

	public String getRefMailId() {
		return refMailId;
	}

	public void setRefMailId(String refMailId) {
		this.refMailId = refMailId;
	}

	public Date getMailSentDate() {
		return mailSentDate;
	}

	public void setMailSentDate(Date mailSentDate) {
		this.mailSentDate = mailSentDate;
	}

	public Date getMailReceiveDate() {
		return mailReceiveDate;
	}

	public void setMailReceiveDate(Date mailReceiveDate) {
		this.mailReceiveDate = mailReceiveDate;
	}

	public String getOrderRemarks() {
		return orderRemarks;
	}

	public void setOrderRemarks(String orderRemarks) {
		this.orderRemarks = orderRemarks;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	

	public Date getEntryTimestamp() {
		return entryTimestamp;
	}

	public void setEntryTimestamp(Date entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	

	public ModelOrderOwner getUltimateOwner() {
		return ultimateOwner;
	}

	public void setUltimateOwner(ModelOrderOwner ultimateOwner) {
		this.ultimateOwner = ultimateOwner;
	}

	public ModelUser getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(ModelUser enteredBy) {
		this.enteredBy = enteredBy;
	}

	public ModelUser getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(ModelUser updatedBy) {
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

	public ModelOrderOwnerType getModelOrderOwnerType() {
		return modelOrderOwnerType;
	}

	public void setModelOrderOwnerType(ModelOrderOwnerType modelOrderOwnerType) {
		this.modelOrderOwnerType = modelOrderOwnerType;
	}

	public ModelOrderOwner getModelOrderOwner() {
		return modelOrderOwner;
	}

	public void setModelOrderOwner(ModelOrderOwner modelOrderOwner) {
		this.modelOrderOwner = modelOrderOwner;
	}

	
	
	
	public int getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(int finalStatus) {
		this.finalStatus = finalStatus;
	}

	public int getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(int verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public ModelUser getModelVerified() {
		return modelVerified;
	}

	public void setModelVerified(ModelUser modelVerified) {
		this.modelVerified = modelVerified;
	}

	public int getAprxOrderQty() {
		return aprxOrderQty;
	}

	public void setAprxOrderQty(int aprxOrderQty) {
		this.aprxOrderQty = aprxOrderQty;
	}

	public ModelUOM getModelUom() {
		return modelUom;
	}

	public void setModelUom(ModelUOM modelUom) {
		this.modelUom = modelUom;
	}

	public ModelCluster getModelCluster() {
		return modelCluster;
	}

	public void setModelCluster(ModelCluster modelCluster) {
		this.modelCluster = modelCluster;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public float getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	@Override
	public String toString() {
		return "ModelOrder [orderId=" + orderId + ", userOrderNo=" + userOrderNo + ", orderType=" + orderType
				+ ", orderDate=" + orderDate + ", refOrderId=" + refOrderId + ", refId=" + refId + ", userRefNo="
				+ userRefNo + ", modelOrderOwnerType=" + modelOrderOwnerType + ", modelOrderOwner=" + modelOrderOwner
				+ ", ultimateOwner=" + ultimateOwner + ", refMailId=" + refMailId + ", mailSentDate=" + mailSentDate
				+ ", mailReceiveDate=" + mailReceiveDate + ", orderRemarks=" + orderRemarks + ", finalStatus="
				+ finalStatus + ", verifyStatus=" + verifyStatus + ", modelVerified=" + modelVerified
				+ ", activeStatus=" + activeStatus + ", enteredBy=" + enteredBy + ", entryTimestamp=" + entryTimestamp
				+ ", updatedBy=" + updatedBy + ", updateTimestap=" + updateTimestap + ", aprxOrderQty=" + aprxOrderQty
				+ ", modelUom=" + modelUom + ", modelCluster=" + modelCluster + ", contactPersonName="
				+ contactPersonName + ", expectedPrice=" + expectedPrice + ", expectedDeliveryDate="
				+ expectedDeliveryDate + ", flex1=" + flex1 + ", flex2=" + flex2 + ", flex3=" + flex3 + ", flex4="
				+ flex4 + ", flex5=" + flex5 + ", active=" + active + ", sActive=" + sActive + "]";
	}


	




	
}
