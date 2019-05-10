package com.atos.boyan.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.atos.boyan.model.Item;

public class ItemBusinessServiceTest {
	ItemBusinessService businessService;
	@Before
	public void setup() {
		businessService = new ItemBusinessService();
	}

	@Test
	public void retrieveHardcodedItem_basic() {
		assertEquals("Ball", businessService.retrieveHardcodedItem().getName());
	}

}
