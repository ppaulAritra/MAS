package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.bg.model.ModelPhone;

public interface PhoneRepository extends JpaRepository <ModelPhone,Long> {
	@Query("select a from BG_PHONE a where a.owner.orderOwnerId=:id ")
	public List<ModelPhone> findPhones(@Param("id")Long id);
	
}
