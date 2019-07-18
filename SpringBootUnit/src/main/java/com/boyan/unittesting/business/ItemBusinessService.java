package com.boyan.unittesting.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boyan.unittesting.data.ItemRepository;
import com.boyan.unittesting.model.Item;

@Service
public class ItemBusinessService {

	private ItemRepository repository;
	
	@Autowired
	public void setRepository(ItemRepository repository) {
		this.repository = repository;
	}

	public Item retrieveHardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;
	}
	
}
