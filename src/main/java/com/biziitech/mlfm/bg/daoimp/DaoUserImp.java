package com.biziitech.mlfm.bg.daoimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.dao.DaoUser;
import com.biziitech.mlfm.bg.model.ModelUser;
import com.biziitech.mlfm.repository.UserRepository;

@Service
public class DaoUserImp implements DaoUser{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<ModelUser> getAllUSerName() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
