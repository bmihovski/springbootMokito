package com.boyan.unittesting.business;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeBusinessTest {
	
	private SomeBusinessImpl someBusinessImpl;
	
	@Autowired
	public void setSomeBusinessImpl(SomeBusinessImpl someBusinessImpl) {
		this.someBusinessImpl = someBusinessImpl;
	}
	

	@Test
	public void calculateSum_basic() {
		int actualResult = someBusinessImpl.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	public void calculateSum_empty() {
		int actualResult = someBusinessImpl.calculateSum(new int[] {});
		assertThat(actualResult).isEqualTo(0);
	}
	
	@Test
	public void calculateSum_one_value() {
		int actualResult = someBusinessImpl.calculateSum(new int[] {5});
		assertThat(actualResult).isEqualTo(5);
	}

	
}
