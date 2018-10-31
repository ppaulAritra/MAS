package com.biziitech.mlfm.controller;


import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biziitech.mlfm.bg.daoimp.DaoUserImp;
import com.biziitech.mlfm.bg.model.ModelPhone;
import com.biziitech.mlfm.bg.model.ModelUser;
import com.biziitech.mlfm.dao.DaoOrderOwner;
import com.biziitech.mlfm.daoimpl.DaoOrderImp;
import com.biziitech.mlfm.daoimpl.DaoOrderItemQtyImageImp;
import com.biziitech.mlfm.daoimpl.DaoOrderOwnerImp;
import com.biziitech.mlfm.daoimpl.DaoOrderOwnerTypeImp;
import com.biziitech.mlfm.daoimpl.DaoUserClusterImp;
import com.biziitech.mlfm.model.ModelOrder;
import com.biziitech.mlfm.model.ModelOrderItemQtyImage;
import com.biziitech.mlfm.model.ModelOrderOwner;
import com.biziitech.mlfm.model.ModelOrderOwnerType;
import com.biziitech.mlfm.model.ModelUserCluster;
import com.biziitech.mlfm.repository.OrderOwnerRepository;
import com.biziitech.mlfm.repository.OrderRepository;
import com.biziitech.mlfm.repository.UserClusterRepository;


@Controller
public class InqueryMsDetailController {
	
	@Autowired
	private DaoOrderImp order;
	
	@Autowired
	private DaoOrderOwnerTypeImp ownerType;
	
	@Autowired
	private DaoOrderOwnerImp orderOwner;
	
	@Autowired
	private DaoUserImp user;
	
	@Autowired
	private UserClusterRepository userClusterRepository;
	
	@Autowired
	private DaoUserClusterImp userCluster;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderOwnerRepository ownerRepository;
	@Autowired
	private DaoOrderItemQtyImageImp imageImp;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	// For Inquiry MS detail inquery_ms_detail.html
	
		@RequestMapping(path="/inquery/details")
		public String getDetailsInquery(Model model) {
			
			ModelOrder newOrder= new ModelOrder();
			newOrder.setActive(true);	
			newOrder.setOrderDate(new Date());
			model.addAttribute("order",newOrder);
			
			List<ModelOrderOwnerType> ownerTypeList= ownerType.getTypeName();			
	        model.addAttribute("ownerTypeList",ownerTypeList);

	        
			List<ModelOrderOwner> ownerList= orderOwner.getAllOwnerName();
			model.addAttribute("ownerList",ownerList);
			
			List<ModelUser> userList= user.getAllUSerName();
			model.addAttribute("userList",userList);
			
			List<ModelUserCluster> clusterList= userClusterRepository.findAll();						
			model.addAttribute("clusterList",clusterList);
			
			model.addAttribute("imageList",imageImp.retriveData());
			
			
			return "inquery_ms_details"; 
		}
		
		
		@RequestMapping(path="/inquery/owner")
		@ResponseBody
		public List<ModelOrderOwner> findOwner(@RequestParam("ownerType")Long typeId){
			
			
			return orderOwner.getOwnerByType(typeId);
		}
		
		
		
		@RequestMapping(path="/inquery/user/cluster")
		@ResponseBody
		public List <ModelUserCluster> findCluster(@RequestParam("user")Long userId){			
			return userCluster.getClusterByUser(userId);
		}
		
		@RequestMapping(path="/inquery/owner/person")
		@ResponseBody
		public Optional <ModelOrderOwner> findContactPerson(@RequestParam("owner")Long ownerId){	
			System.out.println(ownerId);
			return ownerRepository.findById(ownerId);
		}
		
		
		
		@RequestMapping(path="/inquery/save", method = RequestMethod.POST)

		public String saveInquery(ModelOrder order,@RequestParam("order-date")String orderDate,@RequestParam("sent-date")String sentDate,@RequestParam("view-date")String viewDate,@RequestParam("delivery-date")String deliveryDate) throws ParseException {
			//System.out.println("=================================here============================"+orderDate);

			if(order.getOrderId()==null) {
				
				java.util.Date date = new java.util.Date();
				java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
				order.setEntryTimestamp(entryTime);
				order.setOrderDate(format.parse(orderDate));
				
				order.setMailSentDate(format.parse(sentDate));
				order.setMailReceiveDate(format.parse(viewDate));
				if(deliveryDate!= null)
				order.setExpectedDeliveryDate(format.parse(deliveryDate));
				//System.out.println("=================================here============================"+order.getsActive());
				ModelUser enteredBy= new ModelUser();
			//	enteredBy.setUserId(1l);
				this.order.saveOrder(order);
				
			}
			else
			{
				Optional<ModelOrder> existOrder= orderRepository.findById(order.getOrderId());
				java.util.Date date = new java.util.Date();
				java.sql.Timestamp updateTime = new java.sql.Timestamp(date.getTime());
				
				order.setUpdateTimestap(updateTime);
				order.setEntryTimestamp(existOrder.get().getEntryTimestamp());

				order.setEnteredBy(existOrder.get().getEnteredBy());
				existOrder.get().setUpdateTimestap(updateTime);
				order.setOrderDate(format.parse(orderDate));
				
				order.setMailSentDate(format.parse(sentDate));
				order.setMailReceiveDate(format.parse(viewDate));
				if(deliveryDate!= null)
				order.setExpectedDeliveryDate(format.parse(deliveryDate));
				this.order.saveOrder(order);
			}
			
			
			
			
	
			return  "redirect:/inquery/details/data";
		}
		@RequestMapping(path="/inquery/details/data")
		public String getDetailsInqueryWithData(Model model) {
			
			ModelOrder newOrder= new ModelOrder();
			newOrder.setActive(true);			
			model.addAttribute("order",newOrder);
			
			List<ModelOrderOwnerType> ownerTypeList= ownerType.getTypeName();			
	        model.addAttribute("ownerTypeList",ownerTypeList);

	        
			List<ModelOrderOwner> ownerList= orderOwner.getAllOwnerName();
			model.addAttribute("ownerList",ownerList);
			
			List<ModelUser> userList= user.getAllUSerName();
			model.addAttribute("userList",userList);
			
			List<ModelUserCluster> clusterList= userClusterRepository.findAll();						
			model.addAttribute("clusterList",clusterList);
			
		
			model.addAttribute("orderData",order.getOrderData());
			
			
			
			return "inquery_ms_details"; 
		}
		
		@ResponseBody
	    @RequestMapping(value = "/inquery/details/data/edit/{id}", method = RequestMethod.GET)
	    public Optional<ModelOrder> loadEntity(@PathVariable("id") Long id) {
		//System.out.println(id);
	        return order.getOrderById(id);
		}
		
		
		
		@ResponseBody
	    @RequestMapping(value = "/inquery/owner/edit/{id}", method = RequestMethod.GET)
	    public List<ModelOrderOwner> generateOwnerTypeId(@PathVariable("id") Long id) {
			Long owner=order.getOrderOwnerTypeId(id);
			System.out.println(owner);
			List<ModelOrderOwner> orderOwnerList= orderOwner.getOwnerByType(owner);
			return orderOwnerList;
			
		}
		
		
	    @RequestMapping(value = "/inquery/details/save/image", method = RequestMethod.POST)
	    public String storeImage( @RequestParam("image") MultipartFile image){
			
			 imageImp.storeImage(image);
			
			 return "redirect:/inquery/details";
		}
	    
	    
	    
	    @RequestMapping(value="/inquery/details/delete/image/{id}", method=RequestMethod.GET)
	    public String deleteImage(@PathVariable("id")Long id) {
	    	imageImp.deleteImage(id);
	    	return "redirect:/inquery/details";
	    }
	    
	 
	 
		
		
		
}
