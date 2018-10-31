package com.biziitech.mlfm.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.biziitech.mlfm.model.ModelMachine;
public interface MachineRepository extends JpaRepository<ModelMachine,Long>{

}
