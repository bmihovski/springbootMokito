package com.atos.boyan.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.atos.boyan.data.ItemRepository;
import com.atos.boyan.model.Item;
import com.atos.boyan.model.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceMockTest {

	@InjectMocks
	private ItemBusinessService businessService;

	@Mock
	ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10),
				new Item(3, "Item3", 20, 30)));
		List<Item> items = businessService.retrieveAllItems();
		assertEquals(100, items.get(0).getValue());
		assertEquals(600, items.get(1).getValue());
	}

}
