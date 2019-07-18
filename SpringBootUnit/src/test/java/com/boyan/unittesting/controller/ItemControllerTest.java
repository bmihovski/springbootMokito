package com.boyan.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boyan.unittesting.business.ItemBusinessService;
import com.boyan.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

	MockMvc mockMvc;

	@Autowired
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
	
	@MockBean
	ItemBusinessService businessService;
	

	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"));
	}
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Item2", 10, 10));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-bussiness-service")
													   .accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().isOk())
								.andExpect(content().json("{id: 2,name:Item2,price:10,quantity:10}"));
	}

}
