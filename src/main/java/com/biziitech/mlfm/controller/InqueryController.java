package com.biziitech.mlfm.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biziitech.mlfm.repository.OrderOwnerRepository;
import com.biziitech.mlfm.repository.UserRepository;

@Controller
public class InqueryController {  //Controller for Intial inquery page. inquery_table.html
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private OrderOwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path="/owners/orders")
	public String getOwnerOrders(Model model) {
		model.addAttribute("userList",userRepository.findAll());
		model.addAttribute("ownerList",ownerRepository.findAll());
		return "inquery_table";
	}
	
	@RequestMapping(path="/owners/")
	public String getOrderOwner(Model model,@RequestParam("owner_name")String OwnerName,@RequestParam("user")String user) {
		Query query=entityManager.createNativeQuery("?");
		List <Object[]> ownerList=query.setParameter(1, 0).getResultList();
		model.addAttribute("ownerList", ownerRepository.findAll());
		model.addAttribute("userList",userRepository.findAll());
		return "inquery_table";
	}
	
	
	

}
