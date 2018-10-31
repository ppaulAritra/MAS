package com.biziitech.mlfm.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.dao.DaoOrderOwnerType;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.repository.OrderOwnerTypeRepository;

@Service
public class DaoOrderOwnerTypeImp implements DaoOrderOwnerType {
	
	@Autowired
	private OrderOwnerTypeRepository ownerType;

	@Override
	public List<ModelOrderOwnerType> getTypeName() {
		// TODO Auto-generated method stub
		return ownerType.findAll();
	}

	@Override
	public long getTypeId(String typeName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
