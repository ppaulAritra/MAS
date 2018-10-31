package com.biziitech.mlfm.dao;

import java.util.List;
import java.util.Optional;

import com.biziitech.mlfm.model.ModelItem;
import com.biziitech.mlfm.model.ModelOrderOwner;


public interface DaoItem {

	public List<ModelItem> findItems();
	
	public void saveItem(ModelItem  item);
	//public void saveItem(ModelItem item);
	//public Optional<ModelItem> findItemById(Long id);
	//public List<ModelItem> searchItem(Integer level,String name,String remarks,int active);
	
}
