package com.biziitech.mlfm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biziitech.mlfm.daoimpl.DaoItemTypeImp;
import com.biziitech.mlfm.model.ModelItemType;
import com.biziitech.mlfm.repository.ItemTypeRepository;

@Controller
public class ItemTypeController {
	
	@Autowired
	private DaoItemTypeImp item;
	
	@Autowired
	private ItemTypeRepository itemRepository;
			
	

	@RequestMapping(path="/item/type")
	public String itemEntry(Model model) {
		 ModelItemType newItem = new  ModelItemType();
		newItem.setActive(true);
		
		model.addAttribute("item",newItem);
		model.addAttribute("parentList",item.findItems());
		return "item_type";
	}
	
	@RequestMapping(path="/item/type/{id}")
	public String itemEntry(Model model,@PathVariable("id")Long id) {
		model.addAttribute("item",item.findItemTypeById(id));
		model.addAttribute("parentList",item.findItems());
		  if(id!=0) {
	        	String msg="Successfully Saved";
	        	 model.addAttribute("message",msg );
	        }
	        else
	        {
	        	String msg="Some Error Occured";
	        	 model.addAttribute("message",msg);
	        }
		return "item_type";
	}
	
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
	
}
