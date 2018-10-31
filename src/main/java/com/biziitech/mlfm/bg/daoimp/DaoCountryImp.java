package com.biziitech.mlfm.bg.daoimp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.dao.DaoCountry;
import com.biziitech.mlfm.bg.model.ModelCountry;
import com.biziitech.mlfm.repository.CountryRepository;

@Service
public class DaoCountryImp implements DaoCountry{
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<ModelCountry> getCountryName()  {
		return countryRepository.findAll();
	}

	@Override
	public ModelCountry getCountry(String name) throws SQLException {
		// TODO Auto-generated method stub
		return countryRepository.findCountryIdByName(name);
	}

}
