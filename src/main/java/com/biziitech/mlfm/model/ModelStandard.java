package com.biziitech.mlfm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="MLFM_STANDARD")
public class ModelStandard {
	@Id
	@Column(name="INQUIRY_VERIFY_REQUIRED")
	private int inquiryVerifyRequired;
	
public ModelStandard() {
    	
    }

public int getInquiryVerifyRequired() {
	return inquiryVerifyRequired;
}

public void setInquiryVerifyRequired(int inquiryVerifyRequired) {
	this.inquiryVerifyRequired = inquiryVerifyRequired;
}

@Override
public String toString() {
	return "ModelStandard [inquiryVerifyRequired=" + inquiryVerifyRequired + "]";
}


}

