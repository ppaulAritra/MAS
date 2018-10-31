package com.biziitech.mlfm.bg.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.dao.DaoPhone;
import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.repository.PhoneRepository;
@Service
public class DaoPhoneImp implements DaoPhone {
	
@Autowired
 private PhoneRepository phoneRepository;
	@Override
	public long getPhoneId() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ModelPhone> getUserPhoneData(Long userId) {
		 List<ModelPhone> numberList= phoneRepository.findPhones(userId);
		 List<ModelPhone> phoneList = new ArrayList<>();
		 for(ModelPhone phone:numberList) {
			 if(phone.getActiveStatus()==1)
			 { phone.setsActive("Yes");
			  phone.setActive(true);
			 }
			 
			 else
			 {	 phone.setsActive("NO");
			     phone.setActive(false);
			 }
			 
			 if(phone.getEmergencyStatus()==1)
				 phone.setsEmergency("Yes");
			 else
				 phone.setsEmergency("No");
			 if(phone.getTypeId()==1)
				 phone.setPhoneType("Cell");
			 else if(phone.getTypeId()==2)
					 phone.setPhoneType("Lan");
			 phoneList.add(phone);
		 }
		return phoneList;
	}

	@Override
	public void savePhone(ModelPhone phone) {
		
		 if(phone.isActive())
			 phone.setActiveStatus(1);
		 else
			 phone.setActiveStatus(0);
		 
		 if(phone.isEmergency())
			 phone.setEmergencyStatus(1);
		 else
			 phone.setEmergencyStatus(0);
		 
		 //System.out.println(phone.getCountryName());
		 ModelCountry country= new ModelCountry();
		 country.setCountryId(phone.getModelCountry().getCountryId());
		 phone.setModelCountry(country);//setCountryId(Long.valueOf(phone.getCountryName()));
		
		phoneRepository.save(phone);
		
	}

	@Override
	public void updatePhone(ModelPhone phone) {
		phoneRepository.save(phone);
		
	}

	@Override
	public long getPhoneId(Long userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<ModelPhone> getPhoneById(Long phoneId) {
		// TODO Auto-generated method stub
		Optional<ModelPhone> phone= phoneRepository.findById(phoneId);
		 if(phone.get().getActiveStatus()==1)
		 {
			 phone.get().setActive(true);
		  
		 }
		 
		 else
		 {	 
			 phone.get().setActive(false);
		 }
		 
		 if(phone.get().getEmergencyStatus()==1)
			 phone.get().setEmergency(true);
		 else
			 phone.get().setEmergency(false);
		return phone;
	}
	

}
