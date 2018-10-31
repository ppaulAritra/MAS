package com.biziitech.mlfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biziitech.mlfm.bg.model.ModelUser;
public interface UserRepository extends JpaRepository<ModelUser,Long> {
	
	@Query("select c.userName,c.userId from BG_USER c where c.activeStatus=1")
	public List<ModelUser> getUserName();
	

}
