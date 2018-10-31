package com.biziitech.mlfm.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.dao.DaoUOM;
import com.biziitech.mlfm.model.ModelUOM;
import com.biziitech.mlfm.repository.UOMRepository;




@Service
public class DaoUOMImp implements DaoUOM {
	
	@Autowired
	private UOMRepository uomRepository;
	
	public void saveUOM(ModelUOM modelUOM) {
		if (modelUOM.isActive()) {
			modelUOM.setActiveStatus(1);
		}
		
		else
		{
			modelUOM.setActiveStatus(0);
		}
		
		
		uomRepository.save(modelUOM);
		
	}

}
