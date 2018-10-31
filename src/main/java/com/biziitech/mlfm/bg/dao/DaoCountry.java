package com.biziitech.mlfm.bg.dao;

import java.sql.SQLException;
import java.util.List;

import com.biziitech.mlfm.bg.model.ModelCountry;

public interface DaoCountry {
	
	public List<ModelCountry> getCountryName() ;
	public ModelCountry getCountry(String name) throws SQLException;
	

}
