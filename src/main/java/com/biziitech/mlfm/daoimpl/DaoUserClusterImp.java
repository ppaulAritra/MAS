package com.biziitech.mlfm.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.dao.DaoUserCluster;
import com.biziitech.mlfm.model.ModelUserCluster;
import com.biziitech.mlfm.repository.UserClusterRepository;
@Service
public class DaoUserClusterImp implements DaoUserCluster {

	@Autowired
	private UserClusterRepository clusterRepository;
	@Override
	public List<ModelUserCluster> getClusterByUser(Long userId) {
		
		return clusterRepository.getClusterByUser(userId);
	}

}
