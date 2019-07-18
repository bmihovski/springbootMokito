package com.boyan.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.boyan.unittesting.model.Item;

@Component
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
