package com.biziitech.mlfm.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biziitech.mlfm.bg.daoimp.DaoCountryImp;
import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.daoimpl.DaoUOMImp;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.model.ModelUOM;
import com.biziitech.mlfm.repository.OrderOwnerRepository;
import com.biziitech.mlfm.repository.UOMRepository;




@Controller
public class UOMController {

@Autowired
private DaoUOMImp daoUOM;

@Autowired
private DaoUOMImp uomName;

@Autowired 
private UOMRepository uomRepository;


	 @RequestMapping(path = "/uom/init", method = RequestMethod.GET)
	    public String createUom(Model model) {
		 
		 ModelUOM newUOM=new ModelUOM();
		 model.addAttribute("uom", newUOM);
		 
		 String msg=" ";
	     model.addAttribute("message", " ");
	        
	        return "uom_upload";
	}
	 
    @RequestMapping(path = "/uom/save", method = RequestMethod.POST) 
    	public  String saveuom(ModelUOM uom) {
    	
    	if(uom.getUomId()==null )
    			{
    			java.util.Date date = new java.util.Date();
    			java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
    				uom.setEntryTimestamp(entryTime);
    				uom.setEnteredBy(1);
    				daoUOM.saveUOM(uom);
    			}
    			else
    			{
    				Optional<ModelUOM> existsuom=uomRepository.findById(uom.getUomId());
    				uom.setEnteredBy(existsuom.get().getEnteredBy());
    				uom.setEntryTimestamp(existsuom.get().getEntryTimestamp());
    				
    				daoUOM.saveUOM(uom);
    			}
    	
    	 // daoUOM.saveUOM(uom);
    	 return "redirect:/uom/init/"+uom.getUomId();
    	
    }
    
    
    @RequestMapping(path = "/uom/init/{id}", method = RequestMethod.GET)
    public String edituom(@PathVariable Long id, Model model) {
    
     Optional<ModelUOM> uomById;
     uomById=uomRepository.findById(id);
	 if( uomById.get().getActiveStatus()==1)
		uomById.get().setActive(true); 
		else
		uomById.get().setActive(false);	
        model.addAttribute("uom", uomById);
        if(id!=0) {
        	String msg="Successfully Saved";
        	 model.addAttribute("message",msg );
        }
        else
        {
        	String msg="Some Error Occured";
        	 model.addAttribute("message",msg);
        }
               
        return "uom_upload";
}
    
 
    	 
	  
}
