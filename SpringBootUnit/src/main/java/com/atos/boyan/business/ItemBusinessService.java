package com.atos.boyan.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.boyan.data.ItemRepository;
import com.atos.boyan.model.Item;

@Service
public class ItemBusinessService {

	@Autowired
	ItemRepository repository;

	public Item retrieveHardcodedItem() {
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
