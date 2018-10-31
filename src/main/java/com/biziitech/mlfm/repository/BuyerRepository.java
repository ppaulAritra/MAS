package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biziitech.mlfm.model.ModelBuyer;

public interface BuyerRepository extends JpaRepository <ModelBuyer,Long>{
	
/*@Query("select M.buyerId, M.buyerName,M.shortCode,M.email,M.activeStatus,P.phoneNumber,C.countryName,B.typeName from MLFM_BUYER M join BG_PHONE P on M.buyerId=P.ownerId join BG_COUNTRY C on M.countryId=C.countryId join MLFM_BUSINESS_TYPE B on M.typeId=B.typeId")

List<ModelBuyer> findBuyerWithPhone();*/
	


	
}
