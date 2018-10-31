package com.biziitech.mlfm.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.biziitech.mlfm.model.ModelOrder;

public interface DaoOrder {
	
	public void saveOrder(ModelOrder order);
	public List<ModelOrder> getOrderData();
	public Optional<ModelOrder> getOrderById(Long orderId);
	public List<Map<String,Object>> report();
}
