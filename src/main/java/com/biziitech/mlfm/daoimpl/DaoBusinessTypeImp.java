package com.biziitech.mlfm.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.dao.DaoBusinessType;
import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.repository.BusinessTypeRepository;

@Service
public class DaoBusinessTypeImp implements DaoBusinessType {

	@Autowired
	private BusinessTypeRepository typeRepository;
	
	@Override
	public List<ModelBusinessType> getTypeName() {
		
		return typeRepository.findAll();
	}

	@Override
	public long getTypeId(String typeName) {
	return 0;
	}
	
	
	

}
