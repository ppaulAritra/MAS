package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.model.ModelItem;
import com.biziitech.mlfm.model.ModelOrderOwner;

public interface ItemRepository extends JpaRepository <ModelItem,Long>{
	
	@Query ("select a from MLFM_ITEM a where a.activeStatus=1")
	public List<ModelItem> findItems();
	
	
	@Query("select a from MLFM_ITEM a where a.itemId=:id")
	public List<ModelItem> findItemById(@Param("id") Long id);
	
	

}
