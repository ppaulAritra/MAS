package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biziitech.mlfm.model.ModelUserCluster;

public interface UserClusterRepository extends JpaRepository<ModelUserCluster,Long>{
	@Query("select a from MLFM_USER_CLUSTER a where a.modelUser.userId=:id")
	public List<ModelUserCluster> getClusterByUser(@Param("id")Long id);

}
