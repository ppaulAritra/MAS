package com.biziitech.mlfm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biziitech.mlfm.daoimpl.DaoItemTypeImp;
import com.biziitech.mlfm.model.ModelItemType;
import com.biziitech.mlfm.repository.ItemTypeRepository;

@Controller
public class ItemTypeListController {
	
	@Autowired 
	private DaoItemTypeImp itemType;
	
	@Autowired
	private ItemTypeRepository itemRepository;

	
	@RequestMapping(path="/item/type/list")
	public String getItemTypes(Model model) {
		model.addAttribute("typeList",new ArrayList<ModelItemType>());
		return "item_type_list";
	}
	
	
	@RequestMapping(path="/item/type/search")
	public String findItemType(Model model,@RequestParam("item_name")String itemName,@RequestParam("level")Integer level,@RequestParam("remarks")String remarks,
								@RequestParam(value="active", required= false)String active
			) {
		
		
		int status=1;
		if(active == null)
			status =0;
		System.out.println( itemRepository.findItemDetails());
		
					
		model.addAttribute("typeList",itemRepository.findItemDetails());
		
		
		
		return "item_type_list";
	}
}
