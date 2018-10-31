package com.biziitech.mlfm.dao;
import java.util.List;
import java.util.Optional;

import com.biziitech.mlfm.model.ModelItemType;

public interface DaoItemType {
	public List<ModelItemType> findItems();
	public void saveItemType(ModelItemType item);
	public Optional<ModelItemType> findItemTypeById(Long id);
	public List<ModelItemType> searchItem(Integer level,String name,String remarks,int active);
	
	public List<ModelItemType> findItemCategory();
	public List<ModelItemType> findItemSubcategory(Long categoryId);
	
	public List<ModelItemType> findItemSubsubcategory(Long subcategoryId);

}
