package com.biziitech.mlfm.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biziitech.mlfm.bg.daoimp.DaoCountryImp;
import com.biziitech.mlfm.bg.daoimp.DaoPhoneImp;
import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.dao.DaoBusinessType;
import com.biziitech.mlfm.daoimpl.DaoBusinessTypeImp;
import com.biziitech.mlfm.daoimpl.DaoBuyerImp;
import com.biziitech.mlfm.daoimpl.DaoOrderOwnerImp;
import com.biziitech.mlfm.daoimpl.DaoOrderOwnerTypeImp;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelBuyer;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.repository.BusinessTypeRepository;
import com.biziitech.mlfm.repository.BuyerRepository;
import com.biziitech.mlfm.repository.OrderOwnerRepository;
import com.biziitech.mlfm.repository.PhoneRepository;


@Controller
public class OwnerController {

	
	@Autowired
	private DaoPhoneImp phone;
	
	@Autowired
	private DaoCountryImp country;
	
	@Autowired
	private DaoBusinessTypeImp businessType;
	

	
	@Autowired
	private DaoOrderOwnerImp orderOwner;
	
	@Autowired
	private DaoOrderOwnerTypeImp ownerType;
	
	@Autowired 
	private OrderOwnerRepository ownerRepository;
	

	
	@RequestMapping(path = "/")
    public String index() {
        return "index";
}
	
	 @RequestMapping(path = "/owners/add", method = RequestMethod.GET)
	    public String createBuyer(Model model) {
	//	 ModelBuyer newBuyer= new ModelBuyer();
		 ModelOrderOwner newOwner= new ModelOrderOwner();
		 ModelCountry defaultCountry= new ModelCountry();
		 defaultCountry.setCountryId(1l);
		 
		 ModelBusinessType defaultType = new ModelBusinessType();
		 defaultType.setTypeId(1l);
		 
		 ModelOrderOwnerType defaultOwnerType= new ModelOrderOwnerType();
		 defaultOwnerType.setOrderOwnerTypeId(1l);
		 
		 newOwner.setOwnerCountry(defaultCountry);
		 newOwner.setModelBusinessType(defaultType);
		 newOwner.setOrderOwnerType(defaultOwnerType);
	        model.addAttribute("owner", newOwner);
	        String msg=" ";
	        model.addAttribute("message", " ");
	        List <ModelCountry> countryList= country.getCountryName();
	        
	        model.addAttribute("countryList",countryList);

	        List <ModelBusinessType> typeList=  businessType.getTypeName();
	        model.addAttribute("typeList",typeList);
	        
	        List<ModelOrderOwnerType> ownerTypeList= ownerType.getTypeName();
	        model.addAttribute("ownerTypeList",ownerTypeList);
	        
	        
	        ModelPhone phone= new ModelPhone();
	        
	        
	        
	        ModelCountry defaultC= new ModelCountry();
			defaultC.setCountryId(1l);
			phone.setModelCountry(defaultC);
			
	        model.addAttribute("phone",phone);
	        
	        List<ModelPhone> numberList= new ArrayList<>();
	        
	        model.addAttribute("phoneList",numberList);
	        
	        return "buyer_data_upload";
	}
	
	 @RequestMapping(path = "owners", method = RequestMethod.POST)
	    public String saveOwner(ModelOrderOwner owner) {
		 
		if(owner.getOrderOwnerId()==null )
		{
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
			owner.setEntryTimestamp(entryTime);
			owner.setEnteredBy(1);
			 orderOwner.saveOwner(owner);
		}
		else
		{
			Optional<ModelOrderOwner> existOwner= ownerRepository.findById(owner.getOrderOwnerId());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp updateTime = new java.sql.Timestamp(date.getTime());
			
			owner.setEnteredBy(existOwner.get().getEnteredBy());
			owner.setEntryTimestamp(existOwner.get().getEntryTimestamp());
			owner.setUpdatedBy(2);
			owner.setUpdateTimestap(updateTime);
			orderOwner.saveOwner(owner);
		}
	    

	        return "redirect:/owners/add/"+owner.getOrderOwnerId();
	}
	 
	 

	
	 @RequestMapping(path = "/owners/add/{id}", method = RequestMethod.GET)
	    public String editOwner(@PathVariable Long id, Model model) {
		 Optional<ModelOrderOwner> ownerById;
		 ownerById= ownerRepository.findById(id);
		if( ownerById.get().getActiveStatus()==1)
			ownerById.get().setActive(true);
			else
				ownerById.get().setActive(false);
	        model.addAttribute("owner", ownerById);
	        if(id!=0) {
	        	String msg="Successfully Saved";
	        	 model.addAttribute("message",msg );
	        }
	        else
	        {
	        	String msg="Some Error Occured";
	        	 model.addAttribute("message",msg);
	        }
	        List <ModelCountry> countryList= country.getCountryName();
	        
	        model.addAttribute("countryList",countryList);

	        List <ModelBusinessType> typeList=  businessType.getTypeName();
	        model.addAttribute("typeList",typeList);
	        
	        List<ModelOrderOwnerType> ownerTypeList= ownerType.getTypeName();
	        model.addAttribute("ownerTypeList",ownerTypeList);
	        
	        ModelOrderOwner  orderOwner= new ModelOrderOwner();
	        orderOwner.setOrderOwnerId(id);
	        
	        ModelPhone phone= new ModelPhone();
	        phone.setOwner(orderOwner);
	        ModelCountry defaultCountry= new ModelCountry();
			defaultCountry.setCountryId(1l);
			phone.setModelCountry(defaultCountry);
	        model.addAttribute("phone",phone);
	        
	        List<ModelPhone> numberList= this.phone.getUserPhoneData(phone.getOwner().getOrderOwnerId());
	        
	        model.addAttribute("phoneList",numberList);
	        
	        return "buyer_data_upload";
	}
	 
	 
	 @RequestMapping(path = "/owner/phone", method = RequestMethod.POST)
	    public String savePhone(ModelPhone phone) {
		 java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
			if(phone.getPhoneId()==null )
			{
				phone.setEntryTimestap(sqlDate);
				phone.setEntered_By(1);
				 this.phone.savePhone(phone);
			}
			
	        return "redirect:/owners/add/"+phone.getOwner().getOrderOwnerId();
	}
	
	 @ResponseBody
	    @RequestMapping(value = "/owner/phone/{id}", method = RequestMethod.GET)
	    public Optional<ModelPhone> loadEntity(@PathVariable("id") Long id) {
	//	 System.out.println(phone.getPhoneById(id));
	        return phone.getPhoneById(id);
	}
	 
	 
	
	    @RequestMapping(value = "/owner/phone/update", method = RequestMethod.POST)
	    public String updatePhone(@ModelAttribute("phone") ModelPhone phone) {
	    	java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
			Optional<ModelPhone> exitsPhone= this.phone.getPhoneById(phone.getPhoneId());
			
			phone.setUpdatedBy(2);
			phone.setUpdateTimestap(sqlDate);
	    	phone.setEntered_By(exitsPhone.get().getEntered_By());
	    	phone.setEntryTimestap(exitsPhone.get().getEntryTimestap());
		 this.phone.savePhone(phone);
		 
		 return "redirect:/owners/add/"+phone.getOwner().getOrderOwnerId();
	}
	  
	  
	 @ResponseBody
	  @RequestMapping(path = "/owner/loadphone/{id}", method = RequestMethod.GET)
	    public List<ModelPhone> loadOwnerPhone(@PathVariable Long id, Model model) {
		
	        List<ModelPhone> numberList= this.phone.getUserPhoneData(id);
	        
	     return  numberList;
	        
	       
	}
	
}
