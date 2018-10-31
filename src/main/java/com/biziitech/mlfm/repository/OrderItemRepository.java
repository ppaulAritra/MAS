package com.biziitech.mlfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biziitech.mlfm.model.ModelOrderItem;

public interface OrderItemRepository extends JpaRepository<ModelOrderItem,Long> {

}
