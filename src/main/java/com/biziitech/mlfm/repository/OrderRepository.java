package com.biziitech.mlfm.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.model.ModelOrder;
import com.biziitech.mlfm.model.ModelOrderOwner;
public interface OrderRepository extends JpaRepository<ModelOrder,Long> {
	@Query("select a from MLFM_ORDER a where a.orderId=:id")
	public ModelOrder findOwnerTypeId(@Param("id") Long id);	
}
