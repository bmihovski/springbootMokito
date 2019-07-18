package com.boyan.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boyan.unittesting.business.ItemBusinessService;
import com.boyan.unittesting.model.Item;

@RestController
public class ItemController {

	private ItemBusinessService businessService;

	@Autowired
	public void getBusinessService(ItemBusinessService businessService) {
		this.businessService = businessService;
	}
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-bussiness-service")
	public Item itemFromBusinessService() {
		return businessService.retrieveHardCodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
}
