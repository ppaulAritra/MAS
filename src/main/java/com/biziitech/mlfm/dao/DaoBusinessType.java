package com.biziitech.mlfm.dao;


import java.util.List;

import com.biziitech.mlfm.model.ModelBusinessType;

public interface DaoBusinessType {
	public List<ModelBusinessType> getTypeName() ;
	public long getTypeId(String typeName);
	
}
