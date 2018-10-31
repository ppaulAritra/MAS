package com.biziitech.mlfm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biziitech.mlfm.bg.daoimp.DaoCountryImp;
import com.biziitech.mlfm.bg.daoimp.DaoPhoneImp;
import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.daoimpl.DaoBusinessTypeImp;
import com.biziitech.mlfm.daoimpl.DaoOrderOwnerImp;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.repository.OrderOwnerRepository;
import com.biziitech.mlfm.repository.PhoneRepository;

@Controller
public class OwnerListController {

	
	@Autowired
	private DaoCountryImp country;
	
	@Autowired
	private DaoBusinessTypeImp businessType;
	
	@Autowired
	private DaoPhoneImp phone;
	@Autowired 
	private OrderOwnerRepository ownerRepository;
	@Autowired
	private DaoOrderOwnerImp owner;
	@Autowired
	private PhoneRepository phoneRepository;
	
	
	 @RequestMapping(path = "/owners", method = RequestMethod.GET)
	    public String getAllOwner(Model model) {
		 List <ModelCountry> countryList= country.getCountryName()	;        
	        model.addAttribute("countryList",countryList);
	        List <ModelBusinessType> typeList=  businessType.getTypeName();
	        model.addAttribute("typeList",typeList);
	        
	    // model.addAttribute("owner", newOwner);
		 model.addAttribute("ownerList",new ArrayList<ModelOrderOwner>());
	//	 System.out.println("ALL LIST"+ownerRepository.findAll());
	        return "buyer_data_list";
	}
	 
	
	
	@RequestMapping(path="/owners/search")
	 public String getAllOwner(Model model,@RequestParam("owner_name") String name,@RequestParam("shortCode") String code,
			 
			 				@RequestParam("phoneNumber") String phoneNumber,@RequestParam("countryName") Long countryId,
			 				@RequestParam(value = "active", required = false) String active, @RequestParam("businessType") Long typeId
			 ) {
		
		int status=1;
		
		if(active!=null)
			status=1;
		else
			status=0;
		
	
	        List <ModelCountry> countryList= country.getCountryName();
	        
	        model.addAttribute("countryList",countryList);

	        List <ModelBusinessType> typeList=  businessType.getTypeName();
	        model.addAttribute("typeList",typeList);
	        
	       // System.out.println(phoneNumber+" "+active);
		
		if(typeId==0)
			typeId=null;
		if(countryId==0)
			countryId=null;
		
		 model.addAttribute("ownerList",owner.getAllOwner(typeId, countryId, name, code, status));
		 
	        return "buyer_data_list";
	}
	
	@ResponseBody
	@RequestMapping(path="/owners/search/phone/{id}")
	public List<ModelPhone> findOwnerPhone(Model  model, @PathVariable("id")Long id) {
		model.addAttribute("phoneList",phone.getUserPhoneData(id));
		return phone.getUserPhoneData(id);
		
	}
	
}
