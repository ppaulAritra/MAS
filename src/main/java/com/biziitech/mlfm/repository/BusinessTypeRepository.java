package com.biziitech.mlfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biziitech.mlfm.model.ModelBusinessType;

public interface BusinessTypeRepository extends JpaRepository<ModelBusinessType,Long>{
	
	
	@Query("Select t.typeId from MLFM_BUSINESS_TYPE t where t.typeName= :typeName")
	public long findTypeIdByName(String typeName);
	
}
