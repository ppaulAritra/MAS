package com.biziitech.mlfm.dao;


import java.util.List;

import com.biziitech.mlfm.model.ModelOrderOwner;


public interface DaoOrderOwner {
	public List<ModelOrderOwner> getAllOwner(Long typeId, Long countryId, String name,String shortCode, int  status);// Specific Field search +all
	public List<ModelOrderOwner>getAllOwnerNotActive(String type, String name, String shortCode, String country, String number);//owner not active + Specific Field
	public List<ModelOrderOwner> getAllOwnerName();
	
	public void saveOwner(ModelOrderOwner  owner);
	public void updateOwner(ModelOrderOwner  owner);
	
	public long getOwnerId() ;//for generating Owner Id (Primary key);
	public ModelOrderOwner getOwner(Long id) ;//all field of a specific owner
	
	
	public List<ModelOrderOwner> getOwnerByType(Long ownerTypeId);
}
