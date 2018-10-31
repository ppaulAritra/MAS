package com.biziitech.mlfm.dao;

import java.util.List;

import com.biziitech.mlfm.model.ModelBusinessType;
import com.biziitech.mlfm.model.ModelOrderOwnerType;

public interface DaoOrderOwnerType {
	public List<ModelOrderOwnerType> getTypeName() ;
	public long getTypeId(String typeName);
}
