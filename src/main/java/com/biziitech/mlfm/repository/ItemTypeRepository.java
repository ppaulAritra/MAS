package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.model.ModelItemType;
import com.biziitech.mlfm.model.ModelOrderOwner;

public interface ItemTypeRepository extends JpaRepository<ModelItemType,Long> {
	
	@Query("select a from MLFM_ITEM_TYPE a where  a.activeStatus=1")
	public List<ModelItemType> findItemDetails();
	
	@Query("select a from MLFM_ITEM_TYPE a where a.activeStatus=1 and a.levelNo=0 order by a.itemTypeName")
	
	public List<ModelItemType> findItemCategory();
	
	@Query("select a from MLFM_ITEM_TYPE a where a.parentItemTypeId=:id and a.activeStatus=1 and a.levelNo=1")
	public List<ModelItemType> findItemSubcategory(@Param("id") Long id);
	
	@Query("select a from MLFM_ITEM_TYPE a where a.parentItemTypeId=:id and a.activeStatus=1 and a.levelNo=2")
	public List<ModelItemType> findItemSubsubcategory(@Param("id") Long id);
	
}
