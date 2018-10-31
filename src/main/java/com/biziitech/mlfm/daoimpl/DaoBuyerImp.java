package com.biziitech.mlfm.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.dao.DaoBuyer;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelBuyer;
import com.biziitech.mlfm.repository.BuyerRepository;
@Service
public class DaoBuyerImp implements DaoBuyer {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Override
	public List<ModelBuyer> getAllBuyer(String type, String name, String shortCode, String country, String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModelBuyer> getAllBuyerNotActive(String type, String name, String shortCode, String country,
			String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBuyer(ModelBuyer buyer) {
		
		 if(buyer.isActive())
			 buyer.setActiveStatus(1);
		 else
			 buyer.setActiveStatus(0);
		 //System.out.println(buyer.getCountryName());
		 ModelCountry country= new ModelCountry();
		 ModelBusinessType type= new ModelBusinessType();
		 type.setTypeId(buyer.getTypeId().getTypeId());
		 country.setCountryId(buyer.getCountryId().getCountryId());
		 buyer.setCountryId(country);//setCountryId(Long.valueOf(buyer.getCountryName()));
		 buyer.setTypeId(type);
		buyerRepository.save(buyer);
		
	}

	@Override
	public void updateBuyer(ModelBuyer buyer) {
		// TODO Auto-generated method stub
		buyerRepository.save(buyer);
	}

	@Override
	public long getBuyerId() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ModelBuyer getBuyer(long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Object> getBuyerWithPhone(){
		List<Object[]> buyerObject= entityManager.createNativeQuery("select  M.BUYER_ID, M.BUYER_NAME,M.SHORT_CODE,M.BUYER_EMAIL,M.ACTIVE_STATUS,P.PHONE_NUMBER,C.COUNTRY_NAME,B.BUSINESS_TYPE_NAME from MLFM_BUYER M join BG_PHONE P on M.BUYER_ID=P.OWNER_ID join BG_COUNTRY C on M.BUYER_COUNTRY=C.COUNTRY_ID join MLFM_BUSINESS_TYPE B on M.BUSINESS_TYPE_ID=B.BUSINESS_TYPE_ID" ).getResultList();
	
		ModelBuyer buyer= new ModelBuyer();
	
		for(Object[] obj :buyerObject){
			String houseId = String.valueOf(obj[0]); // houseId is at first place in your query
			 buyer.setBuyerName(String.valueOf(obj[1])); // country is at second and so on....
			 buyer.setShortCode(String.valueOf(obj[2]));
			 buyer.setEmail(String.valueOf(obj[3]));
			 if(String.valueOf(obj[4])=="1")
				 buyer.setActive(true);
			 else
				 buyer.setActive(false);
			 buyer.setPhoneNumber(String.valueOf(obj[5]));
			 
			
			//System.out.println(houseId+""+country);
			}
		
		
	return	null;
		
	}

}
