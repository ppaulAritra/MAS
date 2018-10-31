package com.biziitech.mlfm.daoimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.dao.DaoOrder;
import com.biziitech.mlfm.model.ModelOrder;
import com.biziitech.mlfm.repository.OrderRepository;

@Service
public class DaoOrderImp implements DaoOrder{
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveOrder(ModelOrder order) {
		if(order.isActive())
			order.setActiveStatus(1);
		else
			order.setActiveStatus(0);
		
		orderRepository.save(order);
	}

	@Override
	public List<ModelOrder> getOrderData() {

		List<ModelOrder>  tableDataFinal= new ArrayList<>();
		List<ModelOrder> tableData=orderRepository.findAll();
		for(ModelOrder order:tableData) {
			if(order.getActiveStatus()==1)
			 { order.setsActive("Yes");
			  order.setActive(true);
			 }
			 
			 else
			 {	 order.setsActive("NO");
			     order.setActive(false);
			 }
			 
			
			tableDataFinal.add(order);
		 }
		return tableDataFinal;
	}
	@Override
	public Optional<ModelOrder> getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		Optional<ModelOrder> order=orderRepository.findById(orderId);
		
		if(order.get().getActiveStatus()==1)
		 {
			 order.get().setActive(true);
			 
		 }
		 
		 else
		 {	 
			 order.get().setActive(false);
		 }
			order.get().setDateCheck(format.format( order.get().getOrderDate())  );
			order.get().setDateMailReceive(format.format(order.get().getMailReceiveDate()));
			order.get().setDateMailSent(format.format(order.get().getMailSentDate()));
			order.get().setDateBuyerExpectedDate(format.format(order.get().getExpectedDeliveryDate()));
		return order;
	}
	public Long getOrderOwnerTypeId(Long orderId) {
		ModelOrder order=orderRepository.findOwnerTypeId(orderId);
		return order.getModelOrderOwnerType().getOrderOwnerTypeId();
	}
	
	

	@Override
	public List<Map<String, Object>> report() {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		for(ModelOrder order:orderRepository.findAll()) {
			Map<String,Object> item= new HashMap<String,Object>();
			item.put("id", order.getOrderId());
			item.put("type", order.getModelOrderOwnerType().getOrderOwnerTypeName());
			item.put("owner", order.getModelOrderOwner().getOwnerName());
			item.put("ultimate", order.getUltimateOwner().getOwnerName());
			item.put("contact", order.getModelOrderOwner().getContactPersonName());
			item.put("enteredBy", order.getEnteredBy().getUserName());
			item.put("entryTime", order.getEntryTimestamp());
			result.add(item);
		}
		// TODO Auto-generated method stub
		return result;
	}

	
}
