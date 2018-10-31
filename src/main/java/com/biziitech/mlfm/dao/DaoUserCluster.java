package com.biziitech.mlfm.dao;

import java.util.List;

import com.biziitech.mlfm.model.ModelUserCluster;

public interface DaoUserCluster {
	
	public List<ModelUserCluster> getClusterByUser(Long userId);

}
