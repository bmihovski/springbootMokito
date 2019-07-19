package com.boyan.unittesting.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	private ItemRepository itemRepository;
	
	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Test
	public void itemRepository_findAll() {
		assertThat(itemRepository.findAll().size()).isEqualTo(3);
		assertThat(itemRepository.findAll().get(0).getName()).isEqualTo("Item1");
	}

}
