package com.boyan.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.boyan.unittesting.data.ItemRepository;
import com.boyan.unittesting.model.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ItemBusinessTest {

	private ItemBusinessService itemBusinessService;
	
	@Autowired
	public void setItemBusinessService(ItemBusinessService itemBusinessService) {
		this.itemBusinessService = itemBusinessService;
	}
	
	@MockBean
	private ItemRepository itemRepository;
	
	@Test
	public void itemBusinessServiceAllItems_basic() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "test", 10, 10), new Item(2, "test3", 100, 10)));
		assertThat(itemBusinessService.retrieveAllItems().get(0).getValue()).isEqualTo(100);
		assertThat(itemBusinessService.retrieveAllItems().get(1).getValue()).isEqualTo(1000);
		
	}

}
