package com.biziitech.mlfm.dao;

import java.sql.SQLException;
import java.util.List;

import com.biziitech.mlfm.model.ModelBuyer;



public interface DaoBuyer {
	public List<ModelBuyer> getAllBuyer(String type, String name, String shortCode, String country, String number);//Active buyer + Specific Field
	public List<ModelBuyer>getAllBuyerNotActive(String type, String name, String shortCode, String country, String number);//buyer not active + Specific Field
	
	public void saveBuyer(ModelBuyer  buyer);
	public void updateBuyer(ModelBuyer  buyer);
	
	public long getBuyerId() throws SQLException;//for generating Buyer Id (Primary key);
	public ModelBuyer getBuyer(long id) throws ClassNotFoundException,SQLException;//all field of a specific buyer
}

