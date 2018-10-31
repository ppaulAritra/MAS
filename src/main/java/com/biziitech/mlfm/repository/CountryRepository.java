package com.biziitech.mlfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biziitech.mlfm.bg.model.ModelCountry;

public interface CountryRepository extends JpaRepository<ModelCountry,Long>{
	@Query("select b.countryName,b.countryId from BG_COUNTRY b where b.countryName=:countryName")
	public ModelCountry findCountryIdByName(String countryName);

}
