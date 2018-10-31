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
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelBuyer;
import com.biziitech.mlfm.repository.BusinessTypeRepository;
import com.biziitech.mlfm.repository.BuyerRepository;


@Controller
public class BuyerController {
	@Autowired

	private DaoBuyerImp buyer;
	
	@Autowired
	private DaoPhoneImp phone;
	
	@Autowired
	private DaoCountryImp country;
	
	@Autowired
	private DaoBusinessTypeImp businessType;
	
	@Autowired 
	private BuyerRepository bus;;
	
	@RequestMapping(path = "/")
    public String index() {
        return "index";
}
	
	 @RequestMapping(path = "/buyers/add", method = RequestMethod.GET)
	    public String createBuyer(Model model) {
		 ModelBuyer newBuyer= new ModelBuyer();
		 ModelCountry defaultCountry= new ModelCountry();
		 defaultCountry.setCountryId(1);
		 
		 ModelBusinessType defaultType = new ModelBusinessType();
		 defaultType.setTypeId(1);
		 newBuyer.setCountryId(defaultCountry);
		 newBuyer.setTypeId(defaultType);
	        model.addAttribute("buyer", newBuyer);
	        String msg=" ";
	        model.addAttribute("message", " ");
	        List <ModelCountry> countryList= country.getCountryName();
	        
	        model.addAttribute("countryList",countryList);

	        List <ModelBusinessType> typeList=  businessType.getTypeName();
	        model.addAttribute("typeList",typeList);
	        ModelPhone phone= new ModelPhone();
	        
	        
	        
	        ModelCountry defaultC= new ModelCountry();
			defaultC.setCountryId(1);
			phone.setCountryId(defaultC);
			
	        model.addAttribute("phone",phone);
	        
	        List<ModelPhone> numberList= new ArrayList<>();
	        
	        model.addAttribute("phoneList",numberList);
	        
	        return "buyer_data_upload";
	}
	
	 @RequestMapping(path = "buyers", method = RequestMethod.POST)
	    public String saveBuyer(ModelBuyer buyer) {

	      this.buyer.saveBuyer(buyer);

	        return "redirect:/buyers/add/"+buyer.getBuyerId();
	}
	 
	 
	 @RequestMapping(path = "/buyers", method = RequestMethod.GET)
	    public String getAllBuyer(Model model) {
	     
		// model.addAttribute("buyerList",bus.findAll());
	        return "buyer_data_list";
	}
	 
	
	 @RequestMapping(path = "/buyers/add/{id}", method = RequestMethod.GET)
	    public String editBuyer(@PathVariable long id, Model model) {
		 Optional<ModelBuyer> buyerById;
		 buyerById= bus.findById(id);
		if( buyerById.get().getActiveStatus()==1)
			buyerById.get().setActive(true);
			else
			buyerById.get().setActive(false);
	        model.addAttribute("buyer", buyerById);
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
	        
	        ModelPhone phone= new ModelPhone();
	        phone.setOwnerId(id);
	        ModelCountry defaultCountry= new ModelCountry();
			defaultCountry.setCountryId(1);
			phone.setCountryId(defaultCountry);
	        model.addAttribute("phone",phone);
	        
	        List<ModelPhone> numberList= this.phone.getUserPhoneData(phone.getOwnerId());
	        
	        model.addAttribute("phoneList",numberList);
	        
	        return "buyer_data_upload";
	}
	 
	 
	 @RequestMapping(path = "/buyer/phone", method = RequestMethod.POST)
	    public String savePhone(ModelPhone phone) {

	      this.phone.savePhone(phone);

	        return "redirect:/buyers/add/"+phone.getOwnerId();
	}
	
	 @ResponseBody
	    @RequestMapping(value = "/buyer/phone/{id}", method = RequestMethod.GET)
	    public Optional<ModelPhone> loadEntity(@PathVariable("id") long id) {
	//	 System.out.println(phone.getPhoneById(id));
	        return phone.getPhoneById(id);
	}
	 
	 
	
	    @RequestMapping(value = "/buyer/phone/update", method = RequestMethod.POST)
	    public String update(@ModelAttribute("phone") ModelPhone phone) {
		 this.phone.savePhone(phone);
		 
		 return "redirect:/buyers/add/"+phone.getOwnerId();
	}
	  
	  
	 @ResponseBody
	  @RequestMapping(path = "/buyer/loadphone/{id}", method = RequestMethod.GET)
	    public List<ModelPhone> loadBuyerPhone(@PathVariable long id, Model model) {
		
	        List<ModelPhone> numberList= this.phone.getUserPhoneData(id);
	        
	     return  numberList;
	        
	       
	}
	
}
