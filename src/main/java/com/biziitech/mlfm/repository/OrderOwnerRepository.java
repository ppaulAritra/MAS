package com.biziitech.mlfm.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.model.ModelOrderOwner;

public interface OrderOwnerRepository extends JpaRepository<ModelOrderOwner,Long>{
	@Query("select a from MLFM_ORDER_OWNER a  where a.modelBusinessType.typeId=COALESCE(:typeId,a.modelBusinessType.typeId) and a.ownerCountry.countryId=COALESCE(:countryId,a.ownerCountry.countryId) and a.ownerName LIKE CONCAT('%',:name,'%') and a.shortCode LIKE CONCAT('%',:code,'%') and a.activeStatus=:status")
	public List <ModelOrderOwner> findOwnerDetails(@Param("typeId")Long typeId,@Param("countryId")Long countryId,@Param("name")String name,@Param("code")String code,@Param("status") int status);

	@Query("select b from MLFM_ORDER_OWNER b where b.activeStatus=1")
	public List <ModelOrderOwner> findOwnerNames();
	
	@Query("select a from MLFM_ORDER_OWNER a where a.orderOwnerType.orderOwnerTypeId=:id")
	public List<ModelOrderOwner> findOwnerbyType(@Param("id") Long id);
	 
	@Query("select a from MLFM_ORDER_OWNER a where a.orderOwnerId=:id")
	public List<ModelOrderOwner> findOwnerById(@Param("id") Long id);
	
	
	
	
}
