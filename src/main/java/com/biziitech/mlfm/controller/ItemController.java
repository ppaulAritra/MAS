package com.biziitech.mlfm.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.daoimpl.DaoItemImp;
import com.biziitech.mlfm.daoimpl.DaoItemTypeImp;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelItem;
import com.biziitech.mlfm.model.ModelItemType;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.model.ModelUOM;
import com.biziitech.mlfm.repository.ItemRepository;
import com.biziitech.mlfm.repository.ItemTypeRepository;

@Controller
public class ItemController {
	
	@Autowired
	private DaoItemImp item;
	
	@Autowired
	private DaoItemTypeImp itemType;
	
	@Autowired
	private ItemRepository itemRepository;
			
	

	@RequestMapping(path="/item/add", method = RequestMethod.GET)
	public String itemEntry(Model model) {
		 ModelItem newItem = new  ModelItem();
		newItem.setActive(true);
		
		model.addAttribute("item",newItem);
		//model.addAttribute("parentList",item.findItems());
		
		// category data populate
		
				//List<ModelItemType> itemCategoryList=itemType.findItemCategory();
				model.addAttribute("categoryList",itemType.findItemCategory());
		return "item";
	}
	
	/*
	 @RequestMapping(path = "/owners/add", method = RequestMethod.GET)
	    public String createBuyer(Model model) {

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
	
	*/
	
	/*
	@RequestMapping(path="/item/add/{id}")
	public String itemEntry(Model model,@PathVariable("id")Long id) {
		//model.addAttribute("item",item.findItemTypeById(id));
		//model.addAttribute("parentList",item.findItems());
		
		
		
		  if(id!=0) {
	        	String msg="Successfully Saved";
	        	 model.addAttribute("message",msg );
	        }
	        else
	        {
	        	String msg="Some Error Occured";
	        	 model.addAttribute("message",msg);
	        }
		return "item";
	}
	*/
	
	@RequestMapping(path="/item/subcategory")
	@ResponseBody
	public List<ModelItemType> findSubcategory(@RequestParam("category") Long categoryId){
		
		return itemType.findItemSubcategory(categoryId);
		
	}
	
	
	
	
	@RequestMapping(path="/item/subsubcategory")
	@ResponseBody
	public List<ModelItemType> findSububcategory(@RequestParam("subcategory") Long subcategoryId){
		
		return itemType.findItemSubsubcategory(subcategoryId);
		
	}
	
	
	 @RequestMapping(path = "item/datasave", method = RequestMethod.POST)
	    public String saveItem(ModelItem modelItem, @RequestParam("categoryName")String pCategoryId, @RequestParam("subcategoryName")Long pSubcategoryId, @RequestParam("subsubcategoryName")Long pSubsubcategoryId) throws ParseException {
		
		 System.out.println(pCategoryId);
		 
		if(modelItem.getItemId()==null )
		{
		// category id is not blank but subcategory and subsubcategory are blank	
		if (Long.parseLong(pCategoryId)>0 && pSubcategoryId==0 && pSubsubcategoryId==0 ) {
			modelItem.getItemTypeId().setItemTypeId(Long.parseLong(pCategoryId));
		}
		// Category and Subcategory Id are not blank but Subsubcategory is blank
		else if (Long.parseLong(pCategoryId)>0 && pSubcategoryId>0 && pSubsubcategoryId==0) {
			modelItem.getItemTypeId().setItemTypeId(pSubcategoryId);
		}
		// Category, Subcategory and Subsubcategory are not blank.
		else if (Long.parseLong(pCategoryId)>0 && pSubcategoryId>0 && pSubsubcategoryId>0) {
			modelItem.getItemTypeId().setItemTypeId(pSubsubcategoryId);
		}

		
		
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
		modelItem.setEntryTimestamp(entryTime);
		modelItem.setEnteredBy(1);
		
		item.saveItem(modelItem);
			
		}
		else
		{
			Optional<ModelItem> existItem= itemRepository.findById(modelItem.getItemId());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp updateTime = new java.sql.Timestamp(date.getTime());
			
			modelItem.setEnteredBy(existItem.get().getEnteredBy());
			modelItem.setEntryTimestamp(existItem.get().getEntryTimestamp());
			modelItem.setUpdatedBy(2);
			modelItem.setUpdateTimestap(updateTime);
			item.saveItem(modelItem);
		}
	    

	        return "redirect:/item/add/"+modelItem.getItemId();
	}
	
	
	/*
	@RequestMapping(path="/item/save", method =RequestMethod.POST)
	
	public String saveItemType(ModelItemType item) {
		if(item.getItemTypeId()== null) {
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
			item.setEnteredBy(1);//later from System
			item.setEntryTimestamp(entryTime);
			if(item.getParentItemTypeId()==0||item.getParentItemTypeId()==item.getItemTypeId())
				item.setLevelNo(0);
			else
			{
				Optional<ModelItemType> parent=this.item.findItemTypeById(item.getParentItemTypeId());
				if(parent.get().getParentItemTypeId()==0)
					item.setLevelNo(1);
				else
					item.setLevelNo(2);
			}
				
			this.item.saveItemType(item);
		}
		else
		{
			Optional<ModelItemType> model=this.item.findItemTypeById(item.getItemTypeId());
			item.setEnteredBy(model.get().getEnteredBy());
			item.setEntryTimestamp(model.get().getEntryTimestamp());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
			item.setUpdatedBy(2);//latter from system
			item.setUpdateTimestap(date);
			if(item.getParentItemTypeId()==0 ||item.getParentItemTypeId()==item.getItemTypeId() )
				item.setLevelNo(0);
			else
			{
				Optional<ModelItemType> parent=this.item.findItemTypeById(item.getParentItemTypeId());
				if(parent.get().getParentItemTypeId()==0)
					item.setLevelNo(1);
				else
					item.setLevelNo(2);
			}
			
			
			this.item.saveItemType(item);
		}
		return "redirect:/item/type/"+item.getItemTypeId();
	}
	*/
}