package com.biziitech.mlfm.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.dao.DaoItem;
import com.biziitech.mlfm.dao.DaoItemType;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelItem;
import com.biziitech.mlfm.model.ModelItemType;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.repository.ItemRepository;
import com.biziitech.mlfm.repository.ItemTypeRepository;

@Service
public class DaoItemImp implements DaoItem {
	
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@Override
	public List<ModelItem> findItems() {
		
		List<ModelItem> resultList = itemRepository.findAll();
		List<ModelItem> itemList= new ArrayList<>();
		for(ModelItem type: resultList) {
			if(type.getActiveStatus()==1)
				{
				type.setActive(true);
				type.setsActive("Yes");
				}
			else
			{
				type.setActive(true);
				type.setsActive("No");
			}
			itemList.add(type);
		}
		
		
		
		return itemList;
	}
	
	
	@Override
	public void saveItem(ModelItem item) {
		 if(item.isActive())
			 item.setActiveStatus(1);
		 else
			 item.setActiveStatus(0);
		 //System.out.println(owner.getCountryName());
		
		itemRepository.save(item);
		
	}
	
	
}